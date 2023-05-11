package com.project.helloworld.security.oauth2;

import com.project.helloworld.domain.User;
import com.project.helloworld.dto.UserResponseDto;
import com.project.helloworld.repository.UserRepository;
import com.project.helloworld.security.jwt.JwtTokenProvider;
import com.project.helloworld.util.CookieUtils;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static com.project.helloworld.security.oauth2.HttpCookieOAuth2AuthorizationRequestRepository.REDIRECT_URI_PARAM_COOKIE_NAME;

// OAuth2 로그인 성공시 호출되는 Handler
// 로그인에 성공하면 JWT를 생성한 다음 authorizedRedirectUri로 client에 전송
@Component
public class Oauth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private JwtTokenProvider jwtTokenProvider;
    private AppProperties appProperties;
    private HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository;
    private UserRepository userRepository;
    private RedisTemplate redisTemplate;


    @Autowired
    Oauth2AuthenticationSuccessHandler(JwtTokenProvider jwtTokenProvider, AppProperties appProperties,
                                       HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository, UserRepository userRepository,
                                       RedisTemplate redisTemplate) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.appProperties = appProperties;
        this.httpCookieOAuth2AuthorizationRequestRepository = httpCookieOAuth2AuthorizationRequestRepository;
        this.userRepository = userRepository;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String targetUrl = determineTargetUrl(request, response, authentication);

        if (response.isCommitted()) {
            logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }

        clearAuthenticationAttributes(request, response);
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }

    /**
     * 소셜 인증 성공시 호출
     * 마지막으로 서버에 저장된 redirectUri와 호출된 redirectUri가 동일한지 검사하고
     * AT, RT 생성과 함께 RT는 redis에 저장한다(RT 만료시간 7일)
     *
     * @queryParam에 userSeq, accessToken, refreshToken 담아 return
     */
    @SneakyThrows
    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        Optional<String> redirectUri = CookieUtils.getCookie(request, REDIRECT_URI_PARAM_COOKIE_NAME)
                .map(Cookie::getValue);

        if(redirectUri.isPresent() && !isAuthorizedRedirectUri(redirectUri.get())) {
            throw new BadRequestException("죄송합니다, 허용되지 않는 Redirect URI 입니다. 인증 과정을 진행할 수 없습니다.");
        }

        String targetUrl = redirectUri.orElse(getDefaultTargetUrl());
        UserResponseDto.TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);
        User user = userRepository.findByEmail(authentication.getName()).orElseThrow(()-> new Exception("해당하는 유저가 없습니다." + authentication.getName()));

        redisTemplate.opsForValue()
                .set("RT:" + authentication.getName(), tokenInfo.getRefreshToken(), tokenInfo.getRefreshTokenExpirationTime(), TimeUnit.MILLISECONDS);

        return UriComponentsBuilder.fromUriString(targetUrl)
                .queryParam("userSeq", user.getUserSeq())
                .queryParam("accessToken", tokenInfo.getAccessToken())
                .queryParam("refreshToken", tokenInfo.getRefreshToken())
                .build().toUriString();
    }

    protected void clearAuthenticationAttributes(HttpServletRequest request, HttpServletResponse response) {
        super.clearAuthenticationAttributes(request);
        httpCookieOAuth2AuthorizationRequestRepository.removeAuthorizationRequestCookies(request, response);
    }

    // 프론트에서 로그인 요청으로 포함한 redirectURI와 application-db.yml에 저장한 주소가 같아야 redirect
    private boolean isAuthorizedRedirectUri(String uri) {
        URI clientRedirectUri = URI.create(uri);

        return appProperties.getOauth2().getAuthorizedRedirectUris()
                .stream()
                .anyMatch(authorizedRedirectUri -> {
                    URI authorizedURI = URI.create(authorizedRedirectUri);
                    if(authorizedURI.getHost().equalsIgnoreCase(clientRedirectUri.getHost())
                            && authorizedURI.getPort() == clientRedirectUri.getPort()) {
                        return true;
                    }
                    return false;
                });
    }
}

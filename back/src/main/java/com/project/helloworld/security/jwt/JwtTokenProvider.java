package com.project.helloworld.security.jwt;

import com.project.helloworld.domain.User;
import com.project.helloworld.dto.UserResponseDto;
import com.project.helloworld.repository.UserRepository;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class JwtTokenProvider {

    private final String AUTHORITIES_KEY = "auth";
    private final String BEARER_TYPE = "Bearer";
    private final String SECRET_KEY;
    private final UserRepository userRepository;
    private static final long ACCESS_TOKEN_EXPIRE_TIME = 30 * 60 * 1000L;              // 30분
    private static final long REFRESH_TOKEN_EXPIRE_TIME = 7 * 24 * 60 * 60 * 1000L;    // 7일

    public JwtTokenProvider(@Value("${app.auth.token.secret-key}") String secretKey, UserRepository userRepository) {
        this.SECRET_KEY = Base64.getEncoder().encodeToString(secretKey.getBytes());
        this.userRepository = userRepository;
    }

    public Key getSignKey(String SECRET_KEY){
        byte[] keyBytes = SECRET_KEY.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // token 생성
    public UserResponseDto.TokenInfo generateToken(Authentication authentication){
        // 권한 가져오기
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        Optional<User> user = userRepository.findByEmail(authentication.getName());
        Long userSeq = user.get().getUserSeq();

        long now = (new Date()).getTime();
        // Access Token 생성
        Date accessTokenExpiresIn = new Date(now + ACCESS_TOKEN_EXPIRE_TIME);
        String accessToken = Jwts.builder()
                .setSubject(authentication.getName())
                .claim(AUTHORITIES_KEY, authorities)
                .claim("userSeq", userSeq)
                .setExpiration(accessTokenExpiresIn)
                .signWith(getSignKey(SECRET_KEY), SignatureAlgorithm.HS256)
                .compact();

        // Refresh Token 생성
        String refreshToken = Jwts.builder()
                .setExpiration(new Date(now + REFRESH_TOKEN_EXPIRE_TIME))
                .signWith(getSignKey(SECRET_KEY), SignatureAlgorithm.HS256)
                .compact();

        return UserResponseDto.TokenInfo.builder()
                .grantType(BEARER_TYPE)
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .refreshTokenExpirationTime(REFRESH_TOKEN_EXPIRE_TIME)
                .build();
    }

    // Access Token을 복호화하여 토큰에 들어있는 정보 꺼내는 메소드
    public Authentication getAuthentication(String accessToken) {
        // Token 복호화
        Claims claims = parseClaims(accessToken);

        if(claims.get(AUTHORITIES_KEY) == null){
            throw new RuntimeException("권한 정보가 없는 토큰입니다.");
        }

        // claim에서 권한 정보 가져오기
        Collection<? extends GrantedAuthority> authorities = 
                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        // UserDetails 객체 만들어서 Authentication 리턴
        UserDetails principal = new org.springframework.security.core.userdetails.User(claims.getSubject(), "", authorities);
        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
    }

    // token으로 Email 얻는 메소드
    public String getUserEmail(String token){
        Claims claims = parseClaims(token);
        String email = claims.getSubject();
        return email;
    }

    // token으로 userSeq 얻는 메소드
    public Long getUserSeq(String token){
        Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(getSignKey(SECRET_KEY)).build().parseClaimsJws(token);
        String user_seq = String.valueOf(claims.getBody().get("userSeq"));
        return Long.parseLong(user_seq);
    }

    // 토큰 유효성, 만료시간 검사
    public Boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(getSignKey(SECRET_KEY)).build().parseClaimsJws(token);
            return true;
        }catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e){
            log.info("유효하지 않은 JWT Token", e);
        } catch (ExpiredJwtException e) {
            log.info("만료된 JWT Token", e);
        } catch (UnsupportedJwtException e) {
            log.info("지원되지 않는 JWT Token 입니다.", e);
        } catch (IllegalStateException e) {
            log.info("JWT claims String is empty", e);
        }
        return false;
    }

    public Long getExpiration(String accessToken){
        // accessToken 남은 시간
        Date expiration = Jwts.parserBuilder().setSigningKey(getSignKey(SECRET_KEY)).build().parseClaimsJws(accessToken).getBody().getExpiration();
        
        // 현재시간
        Long now = new Date().getTime();
        return (expiration.getTime() - now);
    }

    // Access Token 만료시 갱신때 사용할 정보를 얻기 위해 Claim 리턴
    private Claims parseClaims(String accessToken) {
        try {
            log.debug("pasreClaims", "Claim 리턴");
            return Jwts.parserBuilder().setSigningKey(getSignKey(SECRET_KEY)).build().parseClaimsJws(accessToken).getBody();
        } catch (ExpiredJwtException e) { // 만료된 경우
            log.debug("만료된 토큰입니다.", e.getClaims());
            return e.getClaims();
        }
    }
}

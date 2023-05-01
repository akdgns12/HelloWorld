package com.project.helloworld.security;

import com.project.helloworld.domain.User;
import com.project.helloworld.repository.UserRepository;
import com.project.helloworld.security.oauth2.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// 인증에 필요한 UserDetailsService interface의 loadUserByUsername 메서드를 구현하는 클래스,
//  loadUserByUsername 메서드를 통해 Database에 접근하여 사용자 정보 가져옴
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
        return UserPrincipal.create(user);
    }

    public UserDetails loadByUserSeq(Long userSeq) {
        User user = userRepository.findByUserSeq(userSeq)
                .orElseThrow(()-> new ResourceNotFoundException("사용자를 찾을 수 없습니다." + userSeq));
        return UserPrincipal.create(user);
    }
}

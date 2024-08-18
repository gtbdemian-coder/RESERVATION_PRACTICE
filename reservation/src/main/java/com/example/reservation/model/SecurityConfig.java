package com.example.reservation.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
// 프로그램 보안을 위한 클래스
public class SecurityConfig {

    @Bean
    // 보안 필터 체인 메소드(*HTTP 요청이 애플리케이션에 도달 하기 전 다양한 보안검사를 수행)
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // CSRF: 요청이 실제로 요청자가 의도한 것인지 검증하기 위한 토큰(비활성화 사유: API서버로만 작동)
                .authorizeHttpRequests(auth -> auth // 인가 규칙을 정의
                        .requestMatchers("/partner/signup", "/user/signup","/restaurants/register",
                                "/reservation/register", "/reservation/check-in", "/restaurants/search").permitAll()  // 인증없이 모든 사용자가 접근가능하도록 설정
                        .anyRequest().authenticated()  // 이외 모든 요청에 대해서는 인증 필요
                );
        return http.build();
    }

    @Bean
    // 비밀번호 암호화 메소드
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // BCryptPasswordEncoder를 사용하여 비밀번호 암호화
    }

}

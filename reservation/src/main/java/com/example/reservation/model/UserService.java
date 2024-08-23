package com.example.reservation.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
// 사용자 관련 비즈니스 로직 처리 클래스
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 사용자 회원가입 메소드
    public User registerNewUser(UserDto userDto) {

        // 중복 확인
        if (userRepository.findByuAddress(userDto.getUAddress()).isPresent()) {
            throw new IllegalArgumentException("이미 동일한 유저가 등록되어 있습니다.");
        }

        User user = new User();
        user.setUPassword(passwordEncoder.encode(userDto.getUPassword()));
        user.setUName(userDto.getUName());
        user.setUAddress(userDto.getUAddress());
        user.setUPhoneNumber(userDto.getUPhoneNumber());
        return userRepository.save(user);

    }

}

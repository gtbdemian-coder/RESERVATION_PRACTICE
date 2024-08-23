package com.example.reservation.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


// 레스토랑 테이블 리포지토리
public interface UserRepository extends JpaRepository<User, Long> {

    // 유저 가입 시 중복확인을 위한 쿼리 메서드
    Optional<User> findByuAddress(String uAddress);
}

package com.example.reservation.model;

import org.springframework.data.jpa.repository.JpaRepository;


// 레스토랑 테이블 리포지토리
public interface UserRepository extends JpaRepository<User, Long> {

}

package com.example.reservation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
// 사용자 테이블
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uId; // 사용자 id

    private String uName; // 사용자 이름
    private String uAddress; // 사용자 주소
    private String uPhoneNumber; // 사용자 연락처
    private String uPassword; // 사용자 비밀번호
}

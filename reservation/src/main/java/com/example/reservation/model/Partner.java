package com.example.reservation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
// 파트너사 테이블
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pId; // 파트너 id

    private String pName; // 파트너 이름
    private String pAddress; // 파트너 주소
    private String pPhoneNumber; // 파트너 연락처
    private String pPassword; // 파트너 비밀번호

    @OneToMany(mappedBy = "partner", cascade = CascadeType.ALL)private List<Restaurants> restaurants;

}

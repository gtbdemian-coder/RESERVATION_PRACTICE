package com.example.reservation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
// 매장 테이블
public class Restaurants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rId; // 레스토랑 id

    private String rName; // 레스토랑 이름
    private String rAddress; // 레스토랑 주소
    private String rPhoneNumber; // 레스토랑 연락처

    @ManyToOne
    @JoinColumn(name = "p_id") //순환참조 방지를 위한 코드
    private Partner partner;
}

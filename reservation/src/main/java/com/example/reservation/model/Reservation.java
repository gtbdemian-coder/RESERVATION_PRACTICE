package com.example.reservation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

// 예약 테이블
@Entity
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rvId; // 예약 아이디

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "uId")
    private User user; // User테이블 多(예약):1(User) 관계

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false, referencedColumnName = "rId")
    private Restaurants restaurants; // Restaurants 테이블 多(예약):1(Restaurants) 관계

    private LocalDateTime rvTime; // 예약 시간
    private int rvNumber; // 예약 인원
    private boolean checkedIn = false; // 체크인(*예약 확인용)

}

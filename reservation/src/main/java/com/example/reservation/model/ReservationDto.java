package com.example.reservation.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
// 예약 테이블 DTO
public class ReservationDto {

    private User user;
    private Restaurants restaurants;
    private LocalDateTime rvTime;
    private int rvNumber;
    private boolean checkedIn;

}

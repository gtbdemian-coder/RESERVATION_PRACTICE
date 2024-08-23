package com.example.reservation.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// User 테이블 DTO
public class UserDto {
    private Long uId;
    private String uName;
    private String uPhoneNumber;
    private String uPassword;
    private String uAddress;
}

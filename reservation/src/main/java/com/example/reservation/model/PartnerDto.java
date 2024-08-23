package com.example.reservation.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// 파트너사 테이블 DTO
public class PartnerDto {
    private Long pId;
    private String pName;
    private String pAddress;
    private String pPhoneNumber;
    private String pPassword;
}

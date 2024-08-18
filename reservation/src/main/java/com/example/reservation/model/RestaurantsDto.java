package com.example.reservation.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// 매장 테이블 DTO
public class RestaurantsDto {
    private Long rId;
    private String rName;
    private String rAddress;
    private String rPhoneNumber;
}

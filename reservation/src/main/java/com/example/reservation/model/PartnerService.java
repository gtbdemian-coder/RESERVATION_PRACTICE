package com.example.reservation.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
// 파트너사 관련 비즈니스 로직 처리 클래스
public class PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 파트너 회원가입 메소드
    public Partner registerNewRestaurantPartner(PartnerDto partnerDto) {

        Partner partner = new Partner();
        partner.setPName(partnerDto.getPName());
        partner.setPAddress(partnerDto.getPAddress());
        partner.setPPhoneNumber(partnerDto.getPPhoneNumber());
        partner.setPPassword(passwordEncoder.encode(partnerDto.getPPassword()));
        return partnerRepository.save(partner);

    }


}

package com.example.reservation.model;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


// 파트너사 테이블 리포지토리
public interface PartnerRepository extends JpaRepository<Partner, Long> {

    // 파트너 가입 시 중복확인을 위한 쿼리 메서드
    Optional<Partner> findBypAddress(String pAddress);

}

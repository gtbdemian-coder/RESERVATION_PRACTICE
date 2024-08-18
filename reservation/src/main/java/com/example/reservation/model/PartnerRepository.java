package com.example.reservation.model;

import org.springframework.data.jpa.repository.JpaRepository;


// 파트너사 테이블 리포지토리
public interface PartnerRepository extends JpaRepository<Partner, Long> {

}

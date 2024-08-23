package com.example.reservation.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


// 매장 테이블 리포지토리
public interface RestaurantsRepository extends JpaRepository<Restaurants, Long> {

    // 매장 검색
    List<Restaurants> findByrName(String rName);

    // 매장 등록 시 중복확인을 위한 쿼리 메서드
    Optional<Restaurants> findByrAddress(String rAddress);
}

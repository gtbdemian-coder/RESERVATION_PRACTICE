package com.example.reservation.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


// 매장 테이블 리포지토리
public interface RestaurantsRepository extends JpaRepository<Restaurants, Long> {

    // 매장 검색
    List<Restaurants> findByrName(String rName);
}

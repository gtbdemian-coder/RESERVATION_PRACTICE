package com.example.reservation.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


// 예약 테이블 리포지토리
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByRestaurantsAndRvTimeBetween(Restaurants restaurants, LocalDateTime start, LocalDateTime end);
    Optional<Reservation> findByUser_uNameAndRvNumber(String uName, int rvNumber);
}

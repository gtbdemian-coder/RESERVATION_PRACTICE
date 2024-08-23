package com.example.reservation.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
// 예약 관련 비즈니스 로직 처리 클래스
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    //예약 메소드
    public Reservation newReservation(User user, Restaurants restaurants, LocalDateTime rvTime) {

        // 중복 확인
        List<Reservation> existingReservations = reservationRepository.findByRestaurantsAndRvTimeBetween(
                restaurants,
                rvTime.minusHours(1),
                rvTime.plusHours(1)
        );

        if (!existingReservations.isEmpty()) {
            throw new IllegalArgumentException("지정하신 시간에는 이미 예약이 있습니다.");
        }

        ReservationDto reservationDto = new ReservationDto();
        Reservation reservation = new Reservation();
        reservation.setUser(reservationDto.getUser());
        reservation.setRestaurants(reservationDto.getRestaurants());
        reservation.setRvTime(reservationDto.getRvTime());
        reservation.setRvNumber(reservationDto.getRvNumber());
        reservation.setCheckedIn(reservationDto.isCheckedIn());

        return reservationRepository.save(reservation);

    }

    // 도착확인 메소드
    public void checkIn(String uName, int rvNumber) {

        Reservation reservation = reservationRepository.findByUser_uNameAndRvNumber(uName, rvNumber)
                .orElseThrow(() -> new IllegalArgumentException("일치하는 예약 정보가 없습니다."));

        LocalDateTime now = LocalDateTime.now();

        if (now.isAfter(reservation.getRvTime().minusMinutes(10)) && now.isBefore(reservation.getRvTime().plusMinutes(10))) {
            reservation.setCheckedIn(true);
            reservationRepository.save(reservation);
        } else {
            throw new IllegalArgumentException("지정된 시간에 방문 확인이 불가능합니다.");
        }
    }


}

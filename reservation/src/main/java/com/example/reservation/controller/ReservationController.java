package com.example.reservation.controller;

import com.example.reservation.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestaurantsRepository restaurantsRepository;

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/register")
    public ResponseEntity<Reservation> newReservation(@RequestBody Map<String, Object> reservationDto) {

        Long uId = Long.valueOf((Integer) reservationDto.get("uId"));
        Long rId = Long.valueOf((Integer) reservationDto.get("rId"));
        LocalDateTime rvTime = LocalDateTime.parse((String) reservationDto.get("rvTime"));
        int rvNumber = (Integer) reservationDto.get("rvNumber");

        User user = userRepository.findById(uId)
                .orElseThrow();
        Restaurants restaurant = restaurantsRepository.findById(rId)
                .orElseThrow();

        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setRestaurants(restaurant);
        reservation.setRvTime(rvTime);
        reservation.setRvNumber(rvNumber);
        reservation.setCheckedIn(false);

        Reservation savedReservation = reservationRepository.save(reservation);
        return ResponseEntity.ok(savedReservation);

    }

    @PostMapping("/check-in")
    public ResponseEntity<String> checkIn(@RequestParam String uName, @RequestParam int rvNumber) {
        try {
            reservationService.checkIn(uName, rvNumber);
            return ResponseEntity.ok("도착확인 완료");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}

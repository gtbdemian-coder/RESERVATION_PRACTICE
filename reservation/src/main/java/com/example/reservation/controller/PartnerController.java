package com.example.reservation.controller;

import com.example.reservation.model.Partner;
import com.example.reservation.model.PartnerDto;
import com.example.reservation.model.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partner")
public class PartnerController {
    @Autowired
    private PartnerService partnerService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerRestaurant(@RequestBody PartnerDto partnerDto) {
        try {
            Partner newPartner = partnerService.registerNewRestaurantPartner(partnerDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(newPartner);
        } catch(IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

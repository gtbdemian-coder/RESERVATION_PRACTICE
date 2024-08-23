package com.example.reservation.controller;

import com.example.reservation.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantsController {
    @Autowired
    private RestaurantsService restaurantsService;

    @PostMapping("/register")
    public ResponseEntity<?> registerRestaurants(@RequestBody RestaurantsDto restaurantsDto) {

        try {
            Restaurants registeredRestaurants = restaurantsService.registerNewRestaurants(restaurantsDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(registeredRestaurants);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Restaurants>> searchRestaurants(@RequestParam String rName) {
        List<Restaurants> restaurantsList = restaurantsService.searchRestaurantsByRName(rName);
        return new ResponseEntity<>(restaurantsList, HttpStatus.OK);
    }
}

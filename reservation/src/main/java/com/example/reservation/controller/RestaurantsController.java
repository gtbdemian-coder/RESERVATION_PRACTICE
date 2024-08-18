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
    public ResponseEntity<Restaurants> registerRestaurants(@RequestBody RestaurantsDto restaurantsDto) {

        Restaurants restaurants = new Restaurants();
        restaurants.setRName(restaurantsDto.getRName());
        restaurants.setRAddress(restaurantsDto.getRAddress());
        restaurants.setRPhoneNumber(restaurantsDto.getRPhoneNumber());

        Restaurants registeredRestaurants = restaurantsService.registerNewRestaurants(restaurants);

        return new ResponseEntity<>(registeredRestaurants, HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Restaurants>> searchRestaurants(@RequestParam String rName) {
        List<Restaurants> restaurantsList = restaurantsService.searchRestaurantsByRName(rName);
        return new ResponseEntity<>(restaurantsList, HttpStatus.OK);
    }
}

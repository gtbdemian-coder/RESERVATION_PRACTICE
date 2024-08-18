package com.example.reservation.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// 매장 관련 비즈니스 로직 처리 클래스
public class RestaurantsService {

    @Autowired
    private RestaurantsRepository restaurantsRepository;


    // 매장 등록 메소드
    public Restaurants registerNewRestaurants(Restaurants restaurants) {

        return restaurantsRepository.save(restaurants);
    }

    // 매장 검색 메소드
    public List<Restaurants> searchRestaurantsByRName(String rName) {
        return restaurantsRepository.findByrName(rName);
    }

}

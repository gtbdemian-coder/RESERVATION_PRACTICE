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

    @Autowired
    private PartnerRepository partnerRepository;


    // 매장 등록 메소드
    public Restaurants registerNewRestaurants(RestaurantsDto restaurantsDto) {

        // Partner 객체 찾기
        Partner partner = partnerRepository.findById(restaurantsDto.getPid())
                .orElseThrow(() -> new IllegalArgumentException("유효한 파트너 ID가 아닙니다."));


        // 중복 확인
        if (restaurantsRepository.findByrAddress(restaurantsDto.getRAddress()).isPresent()) {
            throw new IllegalArgumentException("이미 동일한 매장이 등록되어 있습니다.");
        }

        Restaurants restaurants = new Restaurants();
        restaurants.setRName(restaurantsDto.getRName());
        restaurants.setRAddress(restaurantsDto.getRAddress());
        restaurants.setRPhoneNumber(restaurantsDto.getRPhoneNumber());
        restaurants.setPartner(partner);

        return restaurantsRepository.save(restaurants);
    }

    // 매장 검색 메소드
    public List<Restaurants> searchRestaurantsByRName(String rName) {
        return restaurantsRepository.findByrName(rName);
    }

}

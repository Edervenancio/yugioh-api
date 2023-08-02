package com.example.apisrc.ApiYugioh.Service;


import com.example.apisrc.ApiYugioh.Entity.CardsConfig;
import com.example.apisrc.ApiYugioh.Repositorie.CardsConfigRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardsConfigService {


    private CardsConfigRepositories cardsConfigRepositories;

    public CardsConfigService(CardsConfigRepositories cardsConfigRepositories) {
        this.cardsConfigRepositories = cardsConfigRepositories;
    }


    public List<CardsConfig> findCardByType(String cardType){
        return cardsConfigRepositories.findByType(cardType);
    }

    public List<CardsConfig> findCardByAttribute(String cardAttribute){
        return cardsConfigRepositories.findByCardAttribute(cardAttribute);
    }
}

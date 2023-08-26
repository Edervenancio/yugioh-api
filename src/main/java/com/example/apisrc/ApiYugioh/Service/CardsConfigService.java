package com.example.apisrc.ApiYugioh.Service;


import com.example.apisrc.ApiYugioh.Entity.CardsConfig;
import com.example.apisrc.ApiYugioh.Exceptions.CardsConfigNotFoundException;
import com.example.apisrc.ApiYugioh.Repositorie.CardsConfigRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CardsConfigService {




    private CardsConfigRepositories cardsConfigRepositories;
    @Autowired
    public CardsConfigService(CardsConfigRepositories cardsConfigRepositories) {
        this.cardsConfigRepositories = cardsConfigRepositories;
    }

    @Transactional
    public CardsConfig save(CardsConfig cardsConfig){

        CardsConfig cardList = cardsConfigRepositories.findCardByTypeAndAttribute(
                cardsConfig.getCardType(), cardsConfig.getCardAttribute()
        );

        if(!ObjectUtils.isEmpty(cardList)){
            throw new CardsConfigNotFoundException("This card Already exist!");
        } else {
            return cardsConfigRepositories.save(cardsConfig);
        }
    }


    @Transactional
    public CardsConfig updateCards(CardsConfig cardsConfig){



        cardsConfig.setIdCardConfig(cardsConfig.getIdCardConfig());
        CardsConfig updateCard = cardsConfigRepositories.save(cardsConfig);

        return updateCard;

    }


    public List<CardsConfig> findAll(){

        List <CardsConfig> listOfCards = cardsConfigRepositories.findAll();

        if(listOfCards.isEmpty()){
            throw new CardsConfigNotFoundException("Cards not Found");
        } else {
            return cardsConfigRepositories.findAll();
        }
    }

    public CardsConfig findCardByTypeAndAttribute(String cardType, String cardAttribute){
        CardsConfig foundCard = cardsConfigRepositories.findCardByTypeAndAttribute(cardType, cardAttribute);

        if(ObjectUtils.isEmpty(foundCard)){
            throw new CardsConfigNotFoundException("Not found any card with these type or attribute");
        } else {
            return foundCard;
        }
    }


    public CardsConfig findCardById(int id) {
        CardsConfig cardFound = cardsConfigRepositories.findCardById(id);

        if (!ObjectUtils.isEmpty(cardFound)) {
            if (id >= 0) {
                return cardFound;
            } else {
                throw new CardsConfigNotFoundException("You can't find a card with id lower than 0");
            }
        } else {
            throw new CardsConfigNotFoundException("There's no card to search");
        }
    }

    public List<CardsConfig> findCardByType(String cardType){
        List cardResult = cardsConfigRepositories.findByType(cardType);
        return cardResult;
    }

    public List<CardsConfig> findCardByAttribute(String cardAttribute) {

            return cardsConfigRepositories.findByCardAttribute(cardAttribute);

    }

    @Transactional
    public void deleteAll(){
        List <CardsConfig> cards = cardsConfigRepositories.findAll();

        if(cards.isEmpty()){
            throw new CardsConfigNotFoundException("Not found card to delete");
        } else {
            cardsConfigRepositories.deleteAll();
        }
    };

    @Transactional
    public void deleteCardConfig(int id) {


        CardsConfig cardFound = cardsConfigRepositories.findCardById(id);
        if(id < 0){
            throw new CardsConfigNotFoundException("There's no card to delete");
        } else if (ObjectUtils.isEmpty(cardFound)){
            throw new CardsConfigNotFoundException("Not found any card to Delete");
        } else {
            cardsConfigRepositories.deleteCardConfig(id);
        }

    }


    }


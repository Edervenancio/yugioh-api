package com.example.apisrc.ApiYugioh.Controller;


import com.example.apisrc.ApiYugioh.Entity.CardsConfig;
import com.example.apisrc.ApiYugioh.Exceptions.CardsConfigErrorResponse;
import com.example.apisrc.ApiYugioh.Exceptions.CardsConfigNotFoundException;
import com.example.apisrc.ApiYugioh.Service.CardsConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class CardsConfigController {


    private final CardsConfigService cardsConfigService;

    @Autowired
    public CardsConfigController(CardsConfigService cardsConfigService) {
        this.cardsConfigService = cardsConfigService;
    }




    @GetMapping(value = "/card/{id}")
    public CardsConfig findCardsConfigById(int id){
        return cardsConfigService.findCardById(id);
    }

    @GetMapping(value = "/card/{cardType}/{cardAttribute}")
    public CardsConfig findCardConfigByTypeAndAttribute(@PathVariable String cardType, @PathVariable String cardAttribute){
        return cardsConfigService.findCardByTypeAndAttribute(cardType, cardAttribute);
    }


    @GetMapping(value = "/cardType/{cardType}")
    public ResponseEntity<List<CardsConfig>> findCardConfigByType(@PathVariable String cardType){

        String found = cardsConfigService.findCardByType(cardType).toString();

        System.out.println(found);
            if((cardType.equals(""))){
                throw new CardsConfigNotFoundException("Not found Card Type");
            }
                return new ResponseEntity<>(cardsConfigService.findCardByType(cardType), HttpStatus.OK);

    }

   @GetMapping(value = "/cardAttribute/{cardAttribute}")
   public ResponseEntity<List<CardsConfig>> findCardConfigByAttribute(@PathVariable String cardAttribute){

        return new ResponseEntity<>(cardsConfigService.findCardByAttribute(cardAttribute), HttpStatus.OK);
   }


   @PostMapping("/cards/add")
   public CardsConfig addCardsConfig(@RequestBody CardsConfig cardsConfig){

       CardsConfig addCardsConfig = cardsConfigService.save(cardsConfig);
       cardsConfig.setIdCardConfig(0);


       return addCardsConfig;
   }

   @PutMapping("/cards/update")
   public CardsConfig updateCardsConfig(@RequestBody CardsConfig cardsConfig){

        CardsConfig updateCardsConfig = cardsConfigService.save(cardsConfig);

        return updateCardsConfig;
   }



   @GetMapping("/cards")
    public List <CardsConfig> getAllCardsConfig(){
        return cardsConfigService.findAll();
   }


   @DeleteMapping(value = "/cardDelete")
   public void deleteAllCardsConfig(){
        cardsConfigService.deleteAll();
    }
   @DeleteMapping(value = "/cardDelete/{id}")
   public void deleteCardConfig(@PathVariable int id){
        cardsConfigService.deleteCardConfig(id);
   }




}

package com.example.apisrc.ApiYugioh.Controller;


import com.example.apisrc.ApiYugioh.Entity.CardsConfig;
import com.example.apisrc.ApiYugioh.Repositorie.CardsConfigRepositories;
import com.example.apisrc.ApiYugioh.Service.CardsConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CardsConfigController {

    private CardsConfigService cardsConfigService;
    @Autowired
    public CardsConfigController(CardsConfigService cardsConfigService) {
        this.cardsConfigService = cardsConfigService;
    }




    @GetMapping(value = "/cardType/{cardType}")
    public ResponseEntity<List<CardsConfig>> findCardByType(@PathVariable String cardType){
       return new ResponseEntity<>(cardsConfigService.findCardByType(cardType), HttpStatus.OK);
    }

   @GetMapping(value = "/cardAttribute/{cardAttribute}")
   public ResponseEntity<List<CardsConfig>> findCardByAttribute(@PathVariable String cardAttribute){
        return new ResponseEntity<>(cardsConfigService.findCardByAttribute(cardAttribute), HttpStatus.OK);
   }


}

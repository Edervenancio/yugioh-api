package com.example.apisrc.ApiYugioh.Controller;


import com.example.apisrc.ApiYugioh.Entity.CardsConfig;
import com.example.apisrc.ApiYugioh.Entity.Monster;
import com.example.apisrc.ApiYugioh.Service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MonsterController {



    private final MonsterService monsterService;

    @Autowired
    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }


    @GetMapping(value = "/monster")
    public List<Monster> findAllMonsters(){
        return monsterService.findAllMonsters();
    }
}

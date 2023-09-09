package com.example.apisrc.ApiYugioh.Service;

import com.example.apisrc.ApiYugioh.Entity.Monster;
import com.example.apisrc.ApiYugioh.Repositorie.MonsterRepositories;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MonsterService {


    private MonsterRepositories monsterRepositories;

    public MonsterService(MonsterRepositories monsterRepositories) {
        this.monsterRepositories = monsterRepositories;
    }


    public List<Monster> findAllMonsters(){
        return monsterRepositories.findAll();
    }



}

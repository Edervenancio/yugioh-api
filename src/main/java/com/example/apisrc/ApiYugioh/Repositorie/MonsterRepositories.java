package com.example.apisrc.ApiYugioh.Repositorie;

import com.example.apisrc.ApiYugioh.Entity.Monster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MonsterRepositories extends JpaRepository<Monster, Integer> {



    @Query(value = "SELECT tm FROM tbMonster tm where tm.monsterName = ?1")
    Monster findByName(String monsterName);


}

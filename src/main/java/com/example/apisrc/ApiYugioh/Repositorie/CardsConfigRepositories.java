package com.example.apisrc.ApiYugioh.Repositorie;

import com.example.apisrc.ApiYugioh.Entity.CardsConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CardsConfig")
public interface CardsConfigRepositories extends JpaRepository<CardsConfig, Integer> {

    @Query(value = "SELECT cc FROM CardsConfig cc where cc.cardType = ?1")
    List<CardsConfig> findByType(String cardType);

    @Query(value = "SELECT cc FROM CardsConfig cc where cc.cardAttribute = ?1")
     List<CardsConfig> findByCardAttribute(String cardAttribute);
}

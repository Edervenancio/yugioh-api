package com.example.apisrc.ApiYugioh.Repositorie;

import com.example.apisrc.ApiYugioh.Entity.CardsConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.print.DocFlavor;
import java.util.List;

@Repository("CardsConfig")
public interface CardsConfigRepositories extends JpaRepository<CardsConfig, Integer> {

    CardsConfig save(CardsConfig cardsConfig);



    @Query(value = "SELECT cc from CardsConfig cc where cc.cardType =?1 and cc.cardAttribute =?2 ")
    CardsConfig findCardByTypeAndAttribute(String cardType, String cardAttribute);
    @Query(value = "SELECT cc FROM CardsConfig cc where cc.cardType = ?1")
    List<CardsConfig> findByType(String cardType);

    @Query(value = "SELECT cc FROM CardsConfig cc where cc.cardAttribute = ?1")
     List<CardsConfig> findByCardAttribute(String cardAttribute);





    @Override
    void deleteAll();

    @Query(value = "delete from CardsConfig cc where cc.idCardConfig = ?1")
    void deleteCardConfig(int id);




}

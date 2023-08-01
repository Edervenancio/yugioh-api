package com.example.apisrc.ApiYugioh.Repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardsConfig extends JpaRepository<CardsConfig, Integer> {
    List<CardsConfig> findByType(String name);
    List<CardsConfig> findByAttribute(String name);
}

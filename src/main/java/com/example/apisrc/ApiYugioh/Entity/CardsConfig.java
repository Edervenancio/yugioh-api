package com.example.apisrc.ApiYugioh.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="cardsConfig")
public class CardsConfig {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cardConfigId")
    private int idCardConfig;

    @Column(name="cardType")
    private String cardType;

    @Column(name="cardAttribute")
    private String cardAttribute;
}

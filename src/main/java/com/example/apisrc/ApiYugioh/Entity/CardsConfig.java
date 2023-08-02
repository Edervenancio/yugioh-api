package com.example.apisrc.ApiYugioh.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name="CardsConfig")
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


    public CardsConfig(int idCardConfig, String cardType, String cardAttribute) {
        this.idCardConfig = idCardConfig;
        this.cardType = cardType;
        this.cardAttribute = cardAttribute;
    }

    public CardsConfig(){

    }

    @Override
    public String toString() {
        return "CardsConfig{" +
                "idCardConfig=" + idCardConfig +
                ", cardType='" + cardType + '\'' +
                ", cardAttribute='" + cardAttribute + '\'' +
                '}';
    }
}

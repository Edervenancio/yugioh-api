package com.example.apisrc.ApiYugioh.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name="CardsConfig")
@Getter
@Setter

@Table(name="cardsConfig")
public class CardsConfig {



    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cardsConfig")
    @JsonBackReference
    private List <Monster> monsters;



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

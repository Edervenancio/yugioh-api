package com.example.apisrc.ApiYugioh.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name="tbMonster")
@Getter
@Setter

@Table(name="tbMonster")
public class Monster {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "monsterId")
    private int monsterId;

    @ManyToOne
    @JoinColumn(name="cardConfiguration")
    @JsonManagedReference
    private CardsConfig cardsConfig;

    @Column(name="monsterName")
    private String monsterName;

    @Column(name="monsterAttack")
    private int cardAttack;

    @Column(name="monsterDefense")
    private int cardDefense;


    public Monster(int monsterId, String monsterName, int cardAttack, int cardDefense) {
        this.monsterId = monsterId;
        this.monsterName = monsterName;
        this.cardAttack = cardAttack;
        this.cardDefense = cardDefense;
    }

    public Monster(){


    }
}



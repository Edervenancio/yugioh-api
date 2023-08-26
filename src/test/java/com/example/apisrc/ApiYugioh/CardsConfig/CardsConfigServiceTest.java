package com.example.apisrc.ApiYugioh.CardsConfig;


import com.example.apisrc.ApiYugioh.Entity.CardsConfig;
import com.example.apisrc.ApiYugioh.Exceptions.CardsConfigNotFoundException;
import com.example.apisrc.ApiYugioh.Repositorie.CardsConfigRepositories;
import com.example.apisrc.ApiYugioh.Service.CardsConfigService;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Component
@RunWith(MockitoJUnitRunner.class)
class CardsConfigServiceTest {
   @Mock
   CardsConfigRepositories cardsConfigRepositories;

   @InjectMocks
   CardsConfigService cardsConfigService;




    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @DisplayName("checkTypeAndAttributeCardsConfig")
    @Test
    @Order(1)
    void testFindByTypeAndAttribute(){

        CardsConfig cards = new CardsConfig(1, "Zumbi", "Terra");

        Mockito.when(cardsConfigRepositories.findCardByTypeAndAttribute(
                "Zumbi", "Terra")).thenReturn(cards);

        this.cardsConfigService.findCardByTypeAndAttribute("Zumbi", "Terra");
        Assert.assertEquals(cards.getCardType(), "Zumbi");
        Assert.assertEquals(cards.getCardAttribute(), "Terra");
        Assert.assertNotNull(cards);

    }

    @DisplayName("checkCardsConfigList")
    @Test
    @Order(2)
    void checkCardsConfigList(){

        List <CardsConfig> cardList = new ArrayList<>();
        CardsConfig cardOne = new CardsConfig(1, "Mago", "Agua");
        CardsConfig cardTwo = new CardsConfig(2, "Guerreiro", "fogo");
        cardList.add(cardOne);
        cardList.add(cardTwo);

        when(cardsConfigRepositories.findAll()).thenReturn(cardList);

        this.cardsConfigService.findAll();

        Assert.assertNotNull(cardList);
        Assert.assertNotEquals(cardList.isEmpty(), cardList);
        Assert.assertEquals(cardList.size(), 2);
    }


    @DisplayName("checkCardsConfigSave")
    @Test
    @Order(3)

    void checkCardsConfigSave(){
        CardsConfig card = new CardsConfig(1, "Guerreiro", "Trevas");


        Mockito.when(cardsConfigRepositories.save(any(CardsConfig.class))).thenReturn(card);

        this.cardsConfigService.save(card);

        Assert.assertNotNull("Object cant'be null for saving", card);
        Assert.assertTrue("Object can't have id equals to 0", card.getIdCardConfig() > 0);

    }

    @DisplayName("CheckCardsConfigUpdate")
    @Test
    @Order(4)

    void checkCardsConfigUpdate(){
        CardsConfig cardUpdate = new CardsConfig(1, "Dragão", "Metal");

        Mockito.when(cardsConfigRepositories.save(any(CardsConfig.class))).thenReturn(cardUpdate);

        cardUpdate.setIdCardConfig(cardUpdate.getIdCardConfig());
        cardUpdate.setCardType("Lagarto");
        cardUpdate.setCardAttribute("Fogo");

        this.cardsConfigService.save(cardUpdate);

        Assert.assertEquals(1, cardUpdate.getIdCardConfig());
        Assert.assertEquals("Lagarto", cardUpdate.getCardType());
        Assert.assertEquals("Fogo", cardUpdate.getCardAttribute());

    }


    @DisplayName("checkCardsConfigDelete")
    @Test
    @Order(5)
    void checkCardsConfigDelete() {
        CardsConfig card = new CardsConfig();
        int id = 1;
        card.setIdCardConfig(id);
        card.setCardType("Guerreiro");
        card.setCardAttribute("Luz");

        Mockito.when(cardsConfigRepositories.findCardById(id)).thenReturn(card);
        Mockito.doNothing().when(cardsConfigRepositories).deleteCardConfig(eq(id));

        this.cardsConfigService.deleteCardConfig(id);

        verify(cardsConfigRepositories, times(1)).deleteCardConfig(eq(id));
    }



}










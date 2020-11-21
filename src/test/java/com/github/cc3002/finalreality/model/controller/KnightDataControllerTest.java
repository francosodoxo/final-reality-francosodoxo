package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.AbstractSetUpTest;
import com.github.cc3002.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.BeforeEach;

public class KnightDataControllerTest extends AbstractSetUpTest {
  private Knight knight;
  private CharacterController characterController;
  @BeforeEach
  public void setUp(){
    super.setUp();
    characterController = super.getCharacterController();
    knight = characterController.createKnight(super.getKnightName(),
            super.getTurnsQueue(),
            super.getHealthPoints(),
            super.getDefensePoints());
  }
}

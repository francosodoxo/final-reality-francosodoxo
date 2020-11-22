package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.AbstractSetUpTest;
import com.github.cc3002.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnightDataPlayerControllerTest extends AbstractSetUpTest {
  private Knight knight;
  private PlayerController playerController;
  private CharacterController characterController;

  @BeforeEach
  public void setUp(){
    super.setUp();
    playerController = super.getPlayerController();
    characterController = super.getCharacterController();
    knight = characterController.createKnight(super.getKnightName(),
            super.getTurnsQueue(),
            super.getHealthPoints(),
            super.getDefensePoints());
    playerController.add(knight);
  }

  @Test
  public void getName(){
    String name = playerController.getName(knight);
    assertEquals(super.getKnightName(),name);
  }

  @Test
  public void getKnightHealthPoints(){
    int hp = playerController.getHealthPoints(super.getKnightName());
    assertEquals(super.getHealthPoints(),hp);
  }

  @Test
  public void getKnightDefense(){
    int def = playerController.getDefense(super.getKnightName());
    assertEquals(super.getDefensePoints(),def);
  }
}

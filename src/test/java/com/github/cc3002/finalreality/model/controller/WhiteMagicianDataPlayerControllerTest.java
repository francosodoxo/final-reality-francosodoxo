package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.AbstractSetUpTest;
import com.github.cc3002.finalreality.model.character.player.WhiteMagician;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhiteMagicianDataPlayerControllerTest extends AbstractSetUpTest {
  private WhiteMagician whiteMagician;
  private PlayerController playerController;
  private CharacterController characterController;

  @BeforeEach
  public void setUp(){
    super.setUp();
    playerController = super.getPlayerController();
    characterController = super.getCharacterController();
    whiteMagician = characterController.createWhite(super.getWhiteMagicianName(),
            super.getTurnsQueue(),
            super.getHealthPoints(),
            super.getDefensePoints());
    playerController.add(whiteMagician);
  }

  @Test
  public void getName(){
    String name = playerController.getName(whiteMagician);
    assertEquals(super.getWhiteMagicianName(),name);
  }

  @Test
  public void getWhiteHealthPoints(){
    int hp = playerController.getHealthPoints(super.getWhiteMagicianName());
    assertEquals(super.getHealthPoints(),hp);
  }

  @Test
  public void getWhiteDefense(){
    int def = playerController.getDefense(super.getWhiteMagicianName());
    assertEquals(super.getDefensePoints(),def);
  }
}

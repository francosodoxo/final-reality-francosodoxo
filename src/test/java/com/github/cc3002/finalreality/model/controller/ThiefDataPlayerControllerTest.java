package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.AbstractSetUpTest;
import com.github.cc3002.finalreality.model.character.player.Thief;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThiefDataPlayerControllerTest extends AbstractSetUpTest {
  private Thief thief;
  private PlayerController playerController;
  private CharacterController characterController;

  @BeforeEach
  public void setUp(){
    super.setUp();
    playerController = super.getPlayerController();
    characterController = super.getCharacterController();
    thief = characterController.createThief(super.getThiefName(),
            super.getTurnsQueue(),
            super.getHealthPoints(),
            super.getDefensePoints());
    playerController.add(thief);
  }

  @Test
  public void getName(){
    String name = playerController.getName(thief);
    assertEquals(super.getThiefName(),name);
  }

  @Test
  public void getThiefHealthPoints(){
    int hp = playerController.getHealthPoints(super.getThiefName());
    assertEquals(super.getHealthPoints(),hp);
  }

  @Test
  public void getThiefDefense(){
    int def = playerController.getDefense(super.getThiefName());
    assertEquals(super.getDefensePoints(),def);
  }
}

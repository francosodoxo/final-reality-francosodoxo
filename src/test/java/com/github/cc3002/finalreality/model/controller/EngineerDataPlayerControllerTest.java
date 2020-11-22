package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.AbstractSetUpTest;
import com.github.cc3002.finalreality.model.character.player.Engineer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EngineerDataPlayerControllerTest extends AbstractSetUpTest {
  private Engineer engineer;
  private CharacterController characterController;
  private PlayerController playerController;

  @BeforeEach
  public void setUp(){
    super.setUp();
    characterController = super.getCharacterController();
    playerController = super.getPlayerController();
    engineer = characterController.createEngineer(super.getEngineerName(),
            super.getTurnsQueue(),
            super.getHealthPoints(),
            super.getDefensePoints());
    playerController.add(engineer);
  }

  @Test
  public void getName(){
    String name = playerController.getName(engineer);
    assertEquals(super.getEngineerName(),name);
  }

  @Test
  public void getEngineerHealthPoints(){
    int hp = playerController.getHealthPoints(super.getEngineerName());
    assertEquals(super.getHealthPoints(),hp);
  }

  @Test
  public void getEngineerDefense(){
    int def = playerController.getDefense(super.getEngineerName());
    assertEquals(super.getDefensePoints(),def);
  }
}

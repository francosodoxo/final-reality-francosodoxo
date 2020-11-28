package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.AbstractSetUpTest;
import com.github.cc3002.finalreality.model.character.player.BlackMagician;
import com.github.cc3002.finalreality.model.weapon.IWeaponBlack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlackMagicianDataPlayerControllerTest extends AbstractSetUpTest {
  private BlackMagician blackMagician;
  private PlayerController playerController;
  private CharacterController characterController;

  @BeforeEach
  public void setUp(){
    super.setUp();
    playerController = super.getPlayerController();
    characterController = super.getCharacterController();
    blackMagician = characterController.createBlack(super.getBlackName(),
            super.getTurnsQueue(),
            super.getHealthPoints(),
            super.getDefensePoints());
    playerController.add(blackMagician);
  }
  @Test
  public void getName(){
    String name = playerController.getName(blackMagician);
    assertEquals(super.getBlackName(),name);
  }

  @Test
  public void getBlackHealthPoints(){
    int hp = playerController.getHealthPoints(super.getBlackName());
    assertEquals(super.getHealthPoints(),hp);
  }

  @Test
  public void getBlackDefense(){
    int def = playerController.getDefense(super.getBlackName());
    assertEquals(super.getDefensePoints(),def);
  }
}

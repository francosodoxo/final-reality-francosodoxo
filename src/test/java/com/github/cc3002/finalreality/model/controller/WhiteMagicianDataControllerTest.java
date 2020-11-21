package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.AbstractSetUpTest;
import com.github.cc3002.finalreality.model.character.player.WhiteMagician;
import com.github.cc3002.finalreality.model.weapon.IWeaponWhite;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhiteMagicianDataControllerTest extends AbstractSetUpTest {
  private WhiteMagician whiteMagician;
  private CharacterController characterController;

  @BeforeEach
  public void setUp(){
    super.setUp();
    characterController = super.getCharacterController();
    whiteMagician = characterController.createWhite(super.getWhiteMagicianName(),
            super.getTurnsQueue(),
            super.getHealthPoints(),
            super.getDefensePoints());
  }

  @Test
  public void getName(){
    String name = characterController.getName(whiteMagician);
    assertEquals(super.getWhiteMagicianName(),name);
  }

  @Test
  public void getWhiteHealthPoints(){
    int hp = characterController.getHealthPoints(super.getWhiteMagicianName());
    assertEquals(super.getHealthPoints(),hp);
  }

  @Test
  public void getWhiteDefense(){
    int def = characterController.getDefense(super.getWhiteMagicianName());
    assertEquals(super.getDefensePoints(),def);
  }

  public void getWhiteWeapon(){
    whiteMagician.equip(super.getStaffWhite());
    IWeaponWhite weapon = characterController.getWhiteWeapon(super.getWhiteMagicianName());
    assertEquals(super.getStaffWhite(), weapon);
  }
}

package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.AbstractSetUpTest;
import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.weapon.IWeaponThief;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThiefDataControllerTest extends AbstractSetUpTest {
  private Thief thief;
  private CharacterController characterController;
  @BeforeEach
  public void setUp(){
    super.setUp();
    characterController = super.getCharacterController();
    thief = characterController.createThief(super.getThiefName(),
            super.getTurnsQueue(),
            super.getHealthPoints(),
            super.getDefensePoints());
  }

  @Test
  public void getName(){
    String name = characterController.getName(thief);
    assertEquals(super.getThiefName(), name);
  }

  @Test
  public void getThiefHealthPoints(){
    int hp = characterController.getHealthPoints(super.getThiefName());
    assertEquals(super.getHealthPoints(),hp);
  }

  @Test
  public void getThiefDefense(){
    int def = characterController.getDefense(super.getThiefName());
    assertEquals(super.getDefensePoints(),def);
  }

  @Test
  public void getThiefWeapon(){
    thief.tryToEquip(super.getBowThief());
    IWeaponThief weapon = characterController.getThiefWeapon(super.getThiefName());
    assertEquals(super.getBowThief(),weapon);
  }
}

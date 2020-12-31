package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.AbstractSetUpTest;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.character.player.BlackMagician;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.IWeaponBlack;
import com.github.cc3002.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlackMagicianDataControllerTest extends AbstractSetUpTest {

  private BlackMagician blackMagician;

  private CharacterController characterController;

  @BeforeEach
  public void setUp(){
    super.setUp();
    characterController = super.getCharacterController();
    blackMagician = characterController.createBlack(super.getBlackName(),
            super.getTurnsQueue(),
            super.getHealthPoints(),
            super.getDefensePoints());
  }

  @Test
  public void getName(){
    String name = characterController.getName(blackMagician);
    assertEquals(super.getBlackName(),name);
  }

  @Test
  public void getBlackHealthPoints(){
    int hp = characterController.getHealthPoints(super.getBlackName());
    assertEquals(super.getHealthPoints(), hp);
  }

  @Test
  public void getBlackDefense(){
    int def = characterController.getDefense(super.getBlackName());
    assertEquals(super.getDefensePoints(),def);
  }

  @Test
  public void getBlackWeapon(){
    blackMagician.tryToEquip(super.getKnifeBlack());
    IWeaponBlack weapon = characterController.getBlackWeapon(super.getBlackName());
    assertEquals(super.getKnifeBlack(),weapon);
  }

}

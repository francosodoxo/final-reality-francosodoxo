package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.AbstractSetUpTest;
import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.weapon.IWeaponEngineer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EngineerDataControllerTest extends AbstractSetUpTest {
  private Engineer engineer;

  CharacterController characterController;

  @BeforeEach
  public void setUp(){
    characterController = new CharacterController();
    engineer = characterController.createEngineer(super.getEngineerName(),
            super.getTurnsQueue(),
            super.getHealthPoints(),
            super.getDefensePoints());
  }

  @Test
  public void getName(){
    String name = characterController.getName(engineer);
    assertEquals(super.getEngineerName(),name);
  }

  @Test
  public void getEngineerHealthPoints(){
    int hp = characterController.getHealthPoints(super.getEngineerName());
    assertEquals(super.getHealthPoints(),hp);
  }

  @Test
  public void getEngineerDefense(){
    int def = characterController.getDefense(super.getEngineerName());
    assertEquals(super.getDefensePoints(),def);
  }

  @Test
  public void getEngineerWeapon(){
    engineer.equip(super.getAxeEngineer());
    IWeaponEngineer weapon = characterController.getEngineerWeapon(super.getEngineerName());
    assertEquals(super.getAxeEngineer(),weapon);
  }
}

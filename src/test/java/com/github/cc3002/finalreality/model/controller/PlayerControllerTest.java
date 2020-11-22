package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.AbstractSetUpTest;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerControllerTest extends AbstractSetUpTest {
  private CharacterController characterController;
  private PlayerController playerController;
  private WeaponController weaponController;

  private BlackMagician blackMagician;
  private Engineer engineer;
  private Knight knight;
  private Thief thief;
  private WhiteMagician whiteMagician;
  private Axe axe;
  private Bow bow;
  private Knife knife;
  private Staff staff;
  private Sword sword;
  @BeforeEach
  public void setUp(){
    super.setUp();
    characterController = super.getCharacterController();
    playerController = super.getPlayerController();
    weaponController = super.getWeaponController();
    blackMagician = characterController.createBlack(super.getBlackName(),
            super.getTurnsQueue(),
            super.getHealthPoints(),
            super.getDefensePoints());
    engineer = characterController.createEngineer(super.getEngineerName(),
            super.getTurnsQueue(),
            super.getHealthPoints(),
            super.getDefensePoints());
    knight = characterController.createKnight(super.getKnightName(),
            super.getTurnsQueue(),
            super.getHealthPoints(),
            super.getDefensePoints());
    thief = characterController.createThief(super.getThiefName(),
            super.getTurnsQueue(),
            super.getHealthPoints(),
            super.getDefensePoints());
    whiteMagician = characterController.createWhite(super.getWhiteMagicianName(),
            super.getTurnsQueue(),
            super.getHealthPoints(),
            super.getDefensePoints());
    playerController.add(blackMagician);
    playerController.add(engineer);
    playerController.add(knight);
    playerController.add(thief);
    playerController.add(whiteMagician);
  }

  @Test
  public void containsBlack(){
    assertTrue(playerController.contains(super.getBlackName()));
  }
  @Test
  public void containsEngineer(){
    assertTrue(playerController.contains(super.getEngineerName()));
  }
  @Test
  public void containsKnight(){
    assertTrue(playerController.contains(super.getKnightName()));
  }
  @Test
  public void containsThief(){
    assertTrue(playerController.contains(super.getThiefName()));
  }

  @Test
  public void containsWhite(){
    assertTrue(playerController.contains(super.getWhiteMagicianName()));
  }

  @Test
  public void equipWeaponBlack(){
    playerController.equipBlack(super.getBlackName(),getKnifeBlack());
    IWeaponBlack weapon = playerController.getBlackWeapon(super.getBlackName());
    assertEquals(super.getKnifeBlack(),weapon);
  }

  @Test
  public void equipWeaponEngineer(){
    playerController.equipEngineer(super.getEngineerName(),super.getAxeEngineer());
    IWeaponEngineer weapon = playerController.getEngineerWeapon(super.getEngineerName());
    assertEquals(super.getAxeEngineer(),weapon);
  }

  @Test
  public void equipWeaponKnight(){
    playerController.equipKnight(super.getKnightName(),super.getKnifeKnight());
    IWeaponKnight weapon = playerController.getKnightWeapon(super.getKnightName());
    assertEquals(super.getKnifeKnight(),weapon);
  }

  @Test
  public void equipWeaponThief(){
    playerController.equipThief(super.getThiefName(),super.getBowThief());
    IWeaponThief weapon = playerController.getThiefWeapon(super.getThiefName());
    assertEquals(super.getBowThief(),weapon);
  }

  @Test
  public void equipWeaponWhite(){
    playerController.equipWhite(super.getWhiteMagicianName(),super.getStaffWhite());
    IWeaponWhite weapon = playerController.getWhiteWeapon(super.getWhiteMagicianName());
    assertEquals(super.getStaffWhite(),weapon);
  }

  @Test
  public void addAxeToInventory(){
    axe = weaponController.createAxe(super.getAxeName(),
            super.getDamage(),
            super.getWeight());
    playerController.addToInventory(axe);
    assertEquals(axe,playerController.getFromInventory(axe.getName()));
  }

  @Test
  public void addBowToInventory(){
    bow = weaponController.createBow(super.getBowName(),
            super.getDamage(),
            super.getWeight());
    playerController.addToInventory(bow);
    assertEquals(bow,playerController.getFromInventory(bow.getName()));
  }

  @Test
  public void addKnifeToInventory(){
    knife = weaponController.createKnife(super.getKnifeName(),
            super.getDamage(),
            super.getWeight());
    playerController.addToInventory(knife);
    assertEquals(knife, playerController.getFromInventory(knife.getName()));
  }

  @Test
  public void addStaffInventory(){
    staff = weaponController.createStaff(super.getStaffName(),
            super.getDamage(),
            super.getWeight());
    playerController.addToInventory(staff);
    assertEquals(staff,playerController.getFromInventory(staff.getName()));
  }

  @Test
  public void addSwordToInventory(){
    sword = weaponController.createSword(super.getSwordName(),
            super.getDamage(),
            super.getWeight());
    playerController.addToInventory(sword);
    assertEquals(sword,playerController.getFromInventory(sword.getName()));
  }
}

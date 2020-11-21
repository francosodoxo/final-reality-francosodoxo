package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeaponControllerTest {
  private Axe axe;
  private Bow bow;
  private Knife knife;
  private Staff staff;
  private Sword sword;

  private String AXE_NAME;
  private String BOW_NAME;
  private String KNIFE_NAME;
  private String STAFF_NAME;
  private String SWORD_NAME;

  private int ATTACK_WEAPON;
  private int WEAPON_WEIGHT;

  WeaponController weaponController;

  @BeforeEach
  public void setUp(){
    ATTACK_WEAPON = 4;
    WEAPON_WEIGHT = 5;

    AXE_NAME = "axe1";
    BOW_NAME = "bow1";
    KNIFE_NAME = "knife1";
    STAFF_NAME = "staff1";
    SWORD_NAME = "sword1";

    axe = new Axe(AXE_NAME,ATTACK_WEAPON,WEAPON_WEIGHT);
    bow = new Bow(BOW_NAME,ATTACK_WEAPON,WEAPON_WEIGHT);
    knife = new Knife(KNIFE_NAME,ATTACK_WEAPON,WEAPON_WEIGHT);
    staff = new Staff(STAFF_NAME,ATTACK_WEAPON,WEAPON_WEIGHT);
    sword = new Sword(SWORD_NAME, ATTACK_WEAPON,WEAPON_WEIGHT);

    weaponController = new WeaponController();
  }

  @Test
  public void createAxe(){
    Axe newAxe = weaponController.createAxe(AXE_NAME,ATTACK_WEAPON,WEAPON_WEIGHT);
    assertEquals(axe,newAxe);
  }

  @Test
  public void createBow(){
    Bow newBow = weaponController.createBow(BOW_NAME,ATTACK_WEAPON,WEAPON_WEIGHT);
    assertEquals(bow,newBow);
  }

  @Test
  public void createKnife(){
    Knife newKnife = weaponController.createKnife(KNIFE_NAME,ATTACK_WEAPON,WEAPON_WEIGHT);
    assertEquals(knife,newKnife);
  }

  @Test
  public void createStaff(){
    Staff newStaff = weaponController.createStaff(STAFF_NAME,ATTACK_WEAPON,WEAPON_WEIGHT);
    assertEquals(staff, newStaff);
  }

  @Test
  public void createSword(){
    Sword newSword = weaponController.createSword(SWORD_NAME,ATTACK_WEAPON,WEAPON_WEIGHT);
    assertEquals(sword, newSword);
  }
}

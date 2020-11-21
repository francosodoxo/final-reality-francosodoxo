package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;

public class WeaponControllerTest {
  private Axe axe;
  private Bow bow;
  private Knife knife;
  private Staff staff;
  private Sword sword;

  private int ATTACK_WEAPON;
  private int WEAPON_WEIGHT;

  @BeforeEach
  public void setUp(){
    ATTACK_WEAPON = 4;
    WEAPON_WEIGHT = 5;

    axe = new Axe("axe1",ATTACK_WEAPON,WEAPON_WEIGHT);
    bow = new Bow("bow1",ATTACK_WEAPON,WEAPON_WEIGHT);
    knife = new Knife("knife1",ATTACK_WEAPON,WEAPON_WEIGHT);
    staff = new Staff("staff1",ATTACK_WEAPON,WEAPON_WEIGHT);
    sword = new Sword("sword1", ATTACK_WEAPON,WEAPON_WEIGHT);
  }

}

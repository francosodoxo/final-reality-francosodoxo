package com.github.cc3002.finalreality.model.equipweapon;

import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;

public class TestEquipWeapon {
  private BlackMagician blackMagician;
  private WhiteMagician whiteMagician;
  private Engineer engineer;
  private Knight knight;
  private Thief thief;

  private IWeapon axe;
  private IWeapon bow;
  private IWeapon knife;
  private IWeapon staff;
  private IWeapon sword;

  private String BLACK_MAGICIAN_NAME;
  private String WHITE_MAGICIAN_NAME;
  private String ENGINEER_NAME;
  private String KNIGHT_NAME;
  private String THIEF_NAME;

  private int HEALTH_POINTS;
  private int DEFENSE_POINTS;
  private int DAMAGE;
  private int WEIGHT;
  @BeforeEach
  public void setUp(){
    blackMagician = new BlackMagician();
  }
}

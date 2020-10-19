package com.github.cc3002.finalreality.model.equipweapon;

import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;

import java.util.concurrent.BlockingQueue;

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

  private BlockingQueue<IUnit> turnsQueue;
  @BeforeEach
  public void setUp(){
    blackMagician = new BlackMagician(BLACK_MAGICIAN_NAME,turnsQueue,HEALTH_POINTS,DEFENSE_POINTS);
    whiteMagician = new WhiteMagician(WHITE_MAGICIAN_NAME,turnsQueue,HEALTH_POINTS,DEFENSE_POINTS);
    engineer = new Engineer(ENGINEER_NAME,turnsQueue,HEALTH_POINTS,DEFENSE_POINTS);
    knight = new Knight(KNIGHT_NAME,turnsQueue,HEALTH_POINTS,DEFENSE_POINTS);
    thief = new Thief(THIEF_NAME,turnsQueue,HEALTH_POINTS,DEFENSE_POINTS);
  }
}

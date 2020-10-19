package com.github.cc3002.finalreality.model.equipweapon;

import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

  private String AXE_NAME;
  private String BOW_NAME;
  private String KNIFE_NAME;
  private String STAFF_NAME;
  private String SWORD_NAME;

  private int HEALTH_POINTS;
  private int DEFENSE_POINTS;
  private int DAMAGE;
  private int WEIGHT;

  private BlockingQueue<IUnit> turnsQueue;
  @BeforeEach
  public void setUp(){
    BLACK_MAGICIAN_NAME = "Javier";
    WHITE_MAGICIAN_NAME = "Rodrigo";
    ENGINEER_NAME = "Malu";
    KNIGHT_NAME = "Quijote";
    THIEF_NAME = "Andrea";

    AXE_NAME = "Basic Axe";
    BOW_NAME = "Basic Bow";
    KNIFE_NAME = "Basic knife";
    STAFF_NAME = "Basic Staff";
    SWORD_NAME = "Basic Sword";

    HEALTH_POINTS = 10;
    DEFENSE_POINTS = 5;
    DAMAGE = 3;
    WEIGHT = 2;

    blackMagician = new BlackMagician(BLACK_MAGICIAN_NAME,turnsQueue,HEALTH_POINTS,DEFENSE_POINTS);
    whiteMagician = new WhiteMagician(WHITE_MAGICIAN_NAME,turnsQueue,HEALTH_POINTS,DEFENSE_POINTS);
    engineer = new Engineer(ENGINEER_NAME,turnsQueue,HEALTH_POINTS,DEFENSE_POINTS);
    knight = new Knight(KNIGHT_NAME,turnsQueue,HEALTH_POINTS,DEFENSE_POINTS);
    thief = new Thief(THIEF_NAME,turnsQueue,HEALTH_POINTS,DEFENSE_POINTS);

    axe = new Axe(AXE_NAME,DAMAGE,WEIGHT);
    bow = new Bow(BOW_NAME,DAMAGE,WEIGHT);
    knife = new Knife(KNIFE_NAME,DAMAGE,WEIGHT);
    staff = new Staff(STAFF_NAME,DAMAGE, WEIGHT);
    sword = new Sword(SWORD_NAME,DAMAGE,WEIGHT);
  }

  @Test
  public void axeToBlackMag(){
    assertEquals(NullWeapon.getNullWeapon(),blackMagician.getEquippedWeapon());
    blackMagician.equip(axe);
    assertEquals(NullWeapon.getNullWeapon(),blackMagician.getEquippedWeapon());
  }

  @Test
  public void axeToWhiteMag(){
    assertEquals(NullWeapon.getNullWeapon(),whiteMagician.getEquippedWeapon());
    whiteMagician.equip(axe);
    assertEquals(NullWeapon.getNullWeapon(),whiteMagician.getEquippedWeapon());
  }

  @Test
  public void axeToEngineer(){
    assertEquals(NullWeapon.getNullWeapon(),engineer.getEquippedWeapon());
    engineer.equip(axe);
    assertEquals(axe,engineer.getEquippedWeapon());
  }

  @Test
  public void axeToKnight(){
    assertEquals(NullWeapon.getNullWeapon(),knight.getEquippedWeapon());
    knight.equip(axe);
    assertEquals(axe,knight.getEquippedWeapon());
  }

  @Test
  public void axeToThief(){
    assertEquals(NullWeapon.getNullWeapon(),thief.getEquippedWeapon());
    thief.equip(axe);
    assertEquals(NullWeapon.getNullWeapon(),thief.getEquippedWeapon());
  }

  @Test
  public void BowToThief(){
    assertEquals(NullWeapon.getNullWeapon(),thief.getEquippedWeapon());
    thief.equip(axe);
    assertEquals(axe,thief.getEquippedWeapon());
  }
}

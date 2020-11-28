package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.AbstractSetUpTest;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TurnControllerTest {
  private static TurnController turnController;
  private static BlackMagician blackMagician;
  private static Engineer engineer;
  private static Knight knight;
  private static Thief thief;
  private static WhiteMagician whiteMagician;
  private static Enemy enemy;

  private static Axe axe;
  private static Bow bow;
  private static Knife knife;
  private static Staff staff;
  private static Sword sword;

  private static String BLACK_MAGICIAN_NAME;
  private static String WHITE_MAGICIAN_NAME;
  private static String ENGINEER_NAME;
  private static String KNIGHT_NAME;
  private static String THIEF_NAME;
  private static String ENEMY_NAME;

  private static String AXE_NAME;
  private static String BOW_NAME;
  private static String KNIFE_NAME;
  private static String STAFF_NAME;
  private static String SWORD_NAME;

  private static int HEALTH_POINTS;
  private static int DEFENSE_POINTS;
  private static int DAMAGE;
  private static int WEIGHT;

  private static int ENEMY_WEIGHT;
  private static int ENEMY_ATTACK;

  private static BlockingQueue<IUnit> turnsQueue;

  @BeforeAll
  public static void setUp(){
    BLACK_MAGICIAN_NAME = "Javier";
    WHITE_MAGICIAN_NAME = "Rodrigo";
    ENGINEER_NAME = "Malu";
    KNIGHT_NAME = "Quijote";
    THIEF_NAME = "Andrea";
    ENEMY_NAME = "enemy1";

    AXE_NAME = "Basic Axe";
    BOW_NAME = "Basic Bow";
    KNIFE_NAME = "Basic knife";
    STAFF_NAME = "Basic Staff";
    SWORD_NAME = "Basic Sword";

    HEALTH_POINTS = 10;
    DEFENSE_POINTS = 4;
    DAMAGE = 5;
    WEIGHT = 2;

    ENEMY_WEIGHT = 10;
    ENEMY_ATTACK = 7;

    turnController = new TurnController();
    turnsQueue = turnController.getTurnQueue();

    blackMagician = new BlackMagician(BLACK_MAGICIAN_NAME, turnsQueue, HEALTH_POINTS, DEFENSE_POINTS);
    engineer = new Engineer(ENGINEER_NAME, turnsQueue, HEALTH_POINTS, DEFENSE_POINTS);
    knight = new Knight(KNIGHT_NAME, turnsQueue, HEALTH_POINTS, DEFENSE_POINTS);
    thief = new Thief(THIEF_NAME, turnsQueue, HEALTH_POINTS, DEFENSE_POINTS);
    whiteMagician = new WhiteMagician(WHITE_MAGICIAN_NAME, turnsQueue, HEALTH_POINTS, DEFENSE_POINTS);
    enemy = new Enemy(ENEMY_NAME,ENEMY_WEIGHT,turnsQueue,HEALTH_POINTS,ENEMY_ATTACK,DEFENSE_POINTS);

    axe = new Axe(AXE_NAME,DAMAGE,WEIGHT);
    bow = new Bow(BOW_NAME,DAMAGE,WEIGHT);
    knife = new Knife(KNIFE_NAME,DAMAGE,WEIGHT);
    staff = new Staff(STAFF_NAME,DAMAGE,WEIGHT);
    sword = new Sword(SWORD_NAME,DAMAGE,WEIGHT);
    blackMagician.equip(knife);
    engineer.equip(axe);
    knight.equip(sword);
    thief.equip(bow);
    whiteMagician.equip(staff);

    turnController.waitTurn(blackMagician);
    turnController.waitTurn(engineer);
    turnController.waitTurn(knight);
    turnController.waitTurn(thief);
    turnController.waitTurn(whiteMagician);
    turnController.waitTurn(enemy);
    try {
      Thread.sleep(6000);
    }catch (InterruptedException e){
      e.printStackTrace();
    }
  }

  @Test
  public void getUnitFromQueue(){
    while(!turnsQueue.isEmpty()) {
      IUnit fromQueue = turnController.getUnit();
      assertTrue(turnController.waitInput(fromQueue));
      turnController.waitTurn(fromQueue);
    }
  }
}

package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.AbstractSetUpTest;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FightControllerEnemyAttack extends AbstractSetUpTest {
  private FightController fightController;
  private BlackMagician blackMagician;
  private Engineer engineer;
  private Knight knight;
  private Thief thief;
  private WhiteMagician whiteMagician;
  private Enemy enemy;

  @BeforeEach
  public void setUp(){
    super.setUp();
    fightController = super.getFightController();
    blackMagician = super.getBlackMagician();
    engineer = super.getEngineer();
    knight = super.getKnight();
    thief = super.getThief();
    whiteMagician = super.getWhiteMagician();
    enemy = super.getEnemy();
  }

  @Test
  public void enemyAttacksToBlack(){
    int expectedHp = blackMagician.getHealthPoints() +
            blackMagician.getDefense() -
            enemy.getAtk();
    fightController.enemyAttacksTo(enemy,blackMagician);
    assertEquals(expectedHp,blackMagician.getHealthPoints());
  }

  @Test
  public void enemyAttacksToEngineer(){
    int expectedHp = engineer.getHealthPoints() +
            engineer.getDefense() -
            enemy.getAtk();
    fightController.enemyAttacksTo(enemy,engineer);
    assertEquals(expectedHp,engineer.getHealthPoints());
  }

  @Test
  public void enemyAttacksToKnight(){
    int expectedHp = knight.getHealthPoints() +
            knight.getDefense() -
            enemy.getAtk();
    fightController.enemyAttacksTo(enemy,knight);
    assertEquals(expectedHp,knight.getHealthPoints());
  }

  @Test
  public void enemyAttacksToThief(){
    int expectedHp = thief.getHealthPoints() +
            thief.getDefense() -
            enemy.getAtk();
    fightController.enemyAttacksTo(enemy,thief);
    assertEquals(expectedHp,thief.getHealthPoints());
  }

  @Test
  public void enemyAttacksToWhite(){
    int expectedHp = whiteMagician.getHealthPoints() +
            whiteMagician.getDefense() -
            enemy.getAtk();
    fightController.enemyAttacksTo(enemy,whiteMagician);
    assertEquals(expectedHp,whiteMagician.getHealthPoints());
  }
}

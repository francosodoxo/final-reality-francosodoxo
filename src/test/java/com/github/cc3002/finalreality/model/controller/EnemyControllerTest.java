package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.AbstractSetUpTest;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.IUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnemyControllerTest extends AbstractSetUpTest {

  private EnemyController enemyController;
  private Enemy enemy;
  @BeforeEach
  public void  setUp(){
    super.setUp();
    enemyController = new EnemyController(super.getTurnController(), super.getPlayerController().getAttackToCharacterHandler());
    enemy = enemyController.createEnemy(super.getEnemyName(),
            super.getWeight(),
            super.getTurnsQueue(),
            super.getHealthPoints(),
            super.getEnemyAttack(),
            super.getDefensePoints());
  }

  @Test
  public void createEnemy(){
    Enemy newEnemy = enemyController.createEnemy(super.getEnemyName(),
            super.getEnemyWeight(),
            super.getTurnsQueue(),
            super.getHealthPoints(),
            super.getEnemyAttack(),
            super.getDefensePoints());
    assertEquals(super.getEnemy(),newEnemy);
  }

  @Test
  public void addEnemy(){
    assertTrue(enemyController.contains(super.getEnemyName()));
  }

  @Test
  public void getEnemyNameByController(){
    String name = enemyController.getName(enemy);
    assertEquals(super.getEnemyName(),name);
  }

  @Test
  public void getEnemyHealthPoints(){
    int hp = enemyController.getHealthPoints(super.getEnemyName());
    assertEquals(super.getHealthPoints(),hp);
  }

  @Test
  public void getEnemyAttackByController(){
    int atk = enemyController.getAttack(super.getEnemyName());
    assertEquals(super.getEnemyAttack(),atk);
  }

  @Test
  public void getEnemyDefenseByController(){
    int def = enemyController.getDefense(super.getEnemyName());
    assertEquals(super.getDefensePoints(),def);
  }
}

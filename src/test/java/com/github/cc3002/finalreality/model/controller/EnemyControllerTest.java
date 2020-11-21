package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.IUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnemyControllerTest {
  private Enemy enemy;
  private String NAME;
  private int HEALTH_POINTS;
  private int ATTACK;
  private int DEFENSE;
  private int WEIGHT;

  EnemyController enemyController;

  private BlockingQueue<IUnit> turns;
  @BeforeEach
  public void  setUp(){
    NAME = "enemy1";
    HEALTH_POINTS = 10;
    ATTACK = 7;
    DEFENSE = 5;
    WEIGHT = 8;
    turns = new LinkedBlockingQueue<IUnit>();
    enemy = new Enemy(NAME,WEIGHT,turns,HEALTH_POINTS,ATTACK,DEFENSE);
    enemyController = new EnemyController();
  }

  @Test
  public void createEnemy(){
    Enemy newEnemy = enemyController.createEnemy(NAME,WEIGHT,turns,HEALTH_POINTS,ATTACK,DEFENSE);
    assertEquals(enemy,newEnemy);
  }
}

package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.IUnit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

public class EnemyController {
  private HashMap<String,Enemy> enemies;

  public EnemyController(){
    enemies = new HashMap<String,Enemy>();
  }

  public Enemy createEnemy(String name, int weight, BlockingQueue<IUnit> turns, int healthPoints, int attack, int defense) {
    Enemy enemy = new Enemy(name,weight,turns,healthPoints,attack,defense);
    enemies.put(enemy.getName(),enemy);
    return enemy;
  }

  public boolean contains(String enemyName) {
    return enemies.containsKey(enemyName);
  }

  public String getName(Enemy enemy) {
    return enemy.getName();
  }

  public int getHealthPoints(String enemyName) {
    return enemies.get(enemyName).getHealthPoints();
  }

  public int getAttack(String enemyName) {
    return enemies.get(enemyName).getAtk();
  }

  public int getDefense(String enemyName) {
    return enemies.get(enemyName).getDefense();
  }
}

package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.IUnit;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class EnemyController {
  private ArrayList<Enemy> enemies;

  public EnemyController(){
    enemies = new ArrayList<Enemy>();
  }

  public Enemy createEnemy(String name, int weight, BlockingQueue<IUnit> turns, int healthPoints, int attack, int defense) {
    Enemy enemy = new Enemy(name,weight,turns,healthPoints,attack,defense);
    enemies.add(enemy);
    return enemy;
  }
}

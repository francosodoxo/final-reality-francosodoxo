package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.listeners.EnemyDeadHandler;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

public class EnemyController {
  private HashMap<String,Enemy> enemies;
  private int enemiesAlive;
  private PropertyChangeSupport noEnemiesOnGame = new PropertyChangeSupport(this);
  private EnemyDeadHandler enemyDeadHandler= new EnemyDeadHandler(this);
  public EnemyController(){
    enemies = new HashMap<String,Enemy>();
    enemiesAlive = 0;
  }

  public void addNoEnemiesOnGameListener(PropertyChangeListener listener){
    noEnemiesOnGame.addPropertyChangeListener(listener);
  }
  public void enemyDead(){
    int oldEnemiesAlive = enemiesAlive;
    enemiesAlive--;
    if(enemiesAlive==0){
      noEnemiesOnGame.firePropertyChange("enemiesDead", oldEnemiesAlive, enemiesAlive);
    }
  }

  public Enemy createEnemy(String name, int weight, BlockingQueue<IUnit> turns, int healthPoints, int attack, int defense) {
    Enemy enemy = new Enemy(name,weight,turns,healthPoints,attack,defense);
    enemy.addUnitDeadListener(enemyDeadHandler);
    enemies.put(enemy.getName(),enemy);
    enemiesAlive++;
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

  public int getNumberOfEnemies() {
    return enemies.size();
  }

  public int getEnemiesAlive() {
    return enemiesAlive;
  }
}

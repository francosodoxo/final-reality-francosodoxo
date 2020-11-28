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

  /**
   * Creates a Enemy Controller
   */
  public EnemyController(){
    enemies = new HashMap<String,Enemy>();
    enemiesAlive = 0;
  }

  /**
   * Add an observer when all enemies are dead
   * @param listener
   */
  public void addNoEnemiesOnGameListener(PropertyChangeListener listener){
    noEnemiesOnGame.addPropertyChangeListener(listener);
  }

  /**
   * This get fired when a enemy is dead
   */
  public void enemyDead(){
    int oldEnemiesAlive = enemiesAlive;
    enemiesAlive--;
    if(enemiesAlive==0){
      noEnemiesOnGame.firePropertyChange("enemiesDead", oldEnemiesAlive, enemiesAlive);
    }
  }

  /**
   * Creates an enemy
   * @param name
   * @param weight
   * @param turns
   * @param healthPoints
   * @param attack
   * @param defense
   * @return
   */
  public Enemy createEnemy(String name, int weight, BlockingQueue<IUnit> turns, int healthPoints, int attack, int defense) {
    Enemy enemy = new Enemy(name,weight,turns,healthPoints,attack,defense);
    enemy.addUnitDeadListener(enemyDeadHandler);
    enemies.put(enemy.getName(),enemy);
    enemiesAlive++;
    return enemy;
  }

  /**
   * Check if a name corresponds to an enemy in game
   * @param enemyName
   * @return
   */
  public boolean contains(String enemyName) {
    return enemies.containsKey(enemyName);
  }

  /**
   * Get the enemy name
   * @param enemy
   * @return
   */
  public String getName(Enemy enemy) {
    return enemy.getName();
  }

  /**
   * Get the health points of an enemy identified by its name
   * @param enemyName
   * @return
   */
  public int getHealthPoints(String enemyName) {
    return enemies.get(enemyName).getHealthPoints();
  }

  /**
   * Get an enemy's attack identified by its name
   * @param enemyName
   * @return
   */
  public int getAttack(String enemyName) {
    return enemies.get(enemyName).getAtk();
  }

  /**
   * Get an enemy's defense identified by its name
   * @param enemyName
   * @return
   */
  public int getDefense(String enemyName) {
    return enemies.get(enemyName).getDefense();
  }

  /**
   * Get the number of enemies in the current game. It does not matter if they are dead.
   * To know the alive enemies use getEnemiesAlive
   * @return
   */
  public int getNumberOfEnemies() {
    return enemies.size();
  }

  /**
   * Get the alive enemies
   * @return
   */
  public int getEnemiesAlive() {
    return enemiesAlive;
  }
}

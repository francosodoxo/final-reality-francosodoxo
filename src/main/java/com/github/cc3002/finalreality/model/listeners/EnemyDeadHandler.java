package com.github.cc3002.finalreality.model.listeners;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.controller.EnemyController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EnemyDeadHandler implements PropertyChangeListener {
  private EnemyController enemyController;

  /**
   * Class that listens a enemy's death event
   * @param enemyController
   */
  public EnemyDeadHandler(EnemyController enemyController){
    this.enemyController = enemyController;
  }

  /**
   * Fired when a enemy is dead
   * @param evt
   */
  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    enemyController.enemyDead((Enemy) evt.getNewValue());
  }
}

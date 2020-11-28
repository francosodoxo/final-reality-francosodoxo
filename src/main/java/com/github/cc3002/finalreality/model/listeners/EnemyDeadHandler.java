package com.github.cc3002.finalreality.model.listeners;

import com.github.cc3002.finalreality.model.controller.EnemyController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EnemyDeadHandler implements PropertyChangeListener {
  private EnemyController enemyController;

  public EnemyDeadHandler(EnemyController enemyController){
    this.enemyController = enemyController;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    enemyController.enemyDead();
  }
}

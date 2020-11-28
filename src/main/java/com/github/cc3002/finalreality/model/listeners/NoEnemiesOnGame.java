package com.github.cc3002.finalreality.model.listeners;

import com.github.cc3002.finalreality.model.controller.FlowController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NoEnemiesOnGame implements PropertyChangeListener {
  private FlowController flowController;
  public NoEnemiesOnGame(FlowController flowController) {
    this.flowController = flowController;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    flowController.goToPlayerWins();
  }
}

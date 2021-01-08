package com.github.cc3002.finalreality.model.listeners;

import com.github.cc3002.finalreality.model.controller.FlowController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NoEnemiesOnGame implements PropertyChangeListener {
  private FlowController flowController;

  /**
   * Class that listens when a player wins the game,
   * through all enemies deaths.
   * @param flowController
   */
  public NoEnemiesOnGame(FlowController flowController) {
    this.flowController = flowController;
  }

  /**
   * Fired when a player wins the game
   * @param evt
   */
  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    try {
      flowController.goToPlayerWins();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

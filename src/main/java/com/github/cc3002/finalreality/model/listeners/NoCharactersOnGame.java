package com.github.cc3002.finalreality.model.listeners;

import com.github.cc3002.finalreality.model.controller.FlowController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NoCharactersOnGame implements PropertyChangeListener {
  private FlowController flowController;

  /**
   * Class that listens when a player loses the game
   * @param flowController
   */
  public NoCharactersOnGame(FlowController flowController) {
    this.flowController = flowController;
  }

  /**
   * Fired when a player loses the game
   * @param evt
   */
  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    flowController.goToPlayerLoses();
  }
}

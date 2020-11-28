package com.github.cc3002.finalreality.model.listeners;

import com.github.cc3002.finalreality.model.controller.PlayerController;
import com.github.cc3002.finalreality.model.states.PlayerWinsState;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CharacterDeadHandler implements PropertyChangeListener {
  private PlayerController playerController;

  /**
   * Class that listens a character's death event
   * @param playerController
   */
  public CharacterDeadHandler(PlayerController playerController) {
    this.playerController = playerController;
  }

  /**
   * Fired when a character is dead
   * @param evt
   */
  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    playerController.characterDead();
  }
}

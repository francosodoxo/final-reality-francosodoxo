package com.github.cc3002.finalreality.model.listeners;

import com.github.cc3002.finalreality.model.controller.PlayerController;
import com.github.cc3002.finalreality.model.states.PlayerWinsState;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CharacterDeadHandler implements PropertyChangeListener {
  private PlayerController playerController;
  public CharacterDeadHandler(PlayerController playerController) {
    this.playerController = playerController;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    playerController.characterDead();
  }
}

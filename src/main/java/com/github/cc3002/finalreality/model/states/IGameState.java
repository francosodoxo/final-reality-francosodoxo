package com.github.cc3002.finalreality.model.states;

public interface IGameState {
  /**
   * Goes to the player wins state
   * @return
   */
  IGameState goToPlayerWins();

  /**
   * Goes to the player loses state
   * @return
   */
  IGameState goToPlayerLoses();
}

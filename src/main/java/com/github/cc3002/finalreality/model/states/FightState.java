package com.github.cc3002.finalreality.model.states;

/**
 * Class that represents the fight game state
 */
public class FightState implements IGameState{

  /**
   * Fired when a player wins the game
   * @return
   */
  @Override
  public IGameState goToPlayerWins() {
    return new PlayerWinsState();
  }

  /**
   * Fired when a player loses the game
   * @return
   */
  @Override
  public IGameState goToPlayerLoses() {
    return new PlayerLosesState();
  }
}

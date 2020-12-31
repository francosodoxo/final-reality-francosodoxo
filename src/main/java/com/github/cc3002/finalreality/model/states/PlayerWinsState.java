package com.github.cc3002.finalreality.model.states;

/**
 * Represents a player's win
 */
public class PlayerWinsState implements IGameState{
  @Override
  public boolean equals(Object o){
    return o instanceof PlayerWinsState;
  }

  /**
   * Only for finishing the game
   * @return
   */
  @Override
  public IGameState goToPlayerWins() {
    return null;
  }

  /**
   * Only for finishing the game
   * @return
   */
  @Override
  public IGameState goToPlayerLoses() {
    return null;
  }

}

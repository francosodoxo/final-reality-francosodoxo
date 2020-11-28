package com.github.cc3002.finalreality.model.states;

public class PlayerWinsState implements IGameState{
  @Override
  public boolean equals(Object o){
    return o instanceof PlayerWinsState;
  }

  @Override
  public IGameState goToPlayerWins() {
    return null;
  }

  @Override
  public IGameState goToPlayerLoses() {
    return null;
  }
}

package com.github.cc3002.finalreality.model.states;

public class FightState implements IGameState{
  @Override
  public IGameState goToPlayerWins() {
    return new PlayerWinsState();
  }

  @Override
  public IGameState goToPlayerLoses() {
    return new PlayerLosesState();
  }
}

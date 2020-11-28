package com.github.cc3002.finalreality.model.states;

public interface IGameState {

  IGameState goToPlayerWins();
  IGameState goToPlayerLoses();
}

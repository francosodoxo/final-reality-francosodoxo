package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.listeners.NoCharactersOnGame;
import com.github.cc3002.finalreality.model.listeners.NoEnemiesOnGame;
import com.github.cc3002.finalreality.model.states.FightState;
import com.github.cc3002.finalreality.model.states.IGameState;
import com.github.cc3002.finalreality.model.states.PlayerWinsState;

public class FlowController {
  private IGameState currentState;
  private PlayerController playerController;
  private EnemyController enemyController;
  private NoCharactersOnGame noCharactersOnGame = new NoCharactersOnGame(this);
  private NoEnemiesOnGame noEnemiesOnGame = new NoEnemiesOnGame(this);

  public FlowController(EnemyController enemyController, PlayerController playerController){
    currentState = new FightState();
    this.playerController = playerController;
    this.enemyController = enemyController;
    playerController.addNoPlayersOnGameListener(noCharactersOnGame);
    enemyController.addNoEnemiesOnGameListener(noEnemiesOnGame);
  }

  public void goToPlayerWins(){
    currentState = currentState.goToPlayerWins();
  }

  public void goToPlayerLoses(){
    currentState = currentState.goToPlayerLoses();
  }

  public IGameState getCurrentState() {
    return currentState;
  }
}

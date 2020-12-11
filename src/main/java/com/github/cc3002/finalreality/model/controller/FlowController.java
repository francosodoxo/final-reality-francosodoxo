package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.listeners.NoCharactersOnGame;
import com.github.cc3002.finalreality.model.listeners.NoEnemiesOnGame;
import com.github.cc3002.finalreality.model.states.FightState;
import com.github.cc3002.finalreality.model.states.IGameState;
import com.github.cc3002.finalreality.model.states.PlayerWinsState;

public class FlowController {
  private IGameState currentState;
  private PlayerController playerController;
  private EnemyController enemyController;
  private TurnController turnController;
  private NoCharactersOnGame noCharactersOnGame = new NoCharactersOnGame(this);
  private NoEnemiesOnGame noEnemiesOnGame = new NoEnemiesOnGame(this);

  /**
   * Class for manage the game's flow, it has 3 states: fight, player wins and player loses
   * @param enemyController
   * @param playerController
   */
  public FlowController(EnemyController enemyController, PlayerController playerController, TurnController turnController){
    currentState = new FightState();
    this.playerController = playerController;
    this.enemyController = enemyController;
    this.turnController = turnController;
    playerController.addNoPlayersOnGameListener(noCharactersOnGame);
    enemyController.addNoEnemiesOnGameListener(noEnemiesOnGame);
  }

  /**
   * Go to player wins state
   */
  public void goToPlayerWins(){
    currentState = currentState.goToPlayerWins();
  }

  /**
   * Go to player loses state
   */
  public void goToPlayerLoses(){
    currentState = currentState.goToPlayerLoses();
  }

  /**
   * Get the current game state
   * @return
   */
  public IGameState getCurrentState() {
    return currentState;
  }

  public void runFightState(){
    IUnit unit = turnController.getUnit();
    currentState.setCurrentUnit(unit);
    currentState.run();
  }

}

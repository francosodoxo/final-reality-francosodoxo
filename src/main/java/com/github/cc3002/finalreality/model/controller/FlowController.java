package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.gui.actions.IAction;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.character.player.BlackMagician;
import com.github.cc3002.finalreality.model.listeners.NoCharactersOnGame;
import com.github.cc3002.finalreality.model.listeners.NoEnemiesOnGame;
import com.github.cc3002.finalreality.model.states.FightState;
import com.github.cc3002.finalreality.model.states.IFightState;
import com.github.cc3002.finalreality.model.states.IGameState;
import com.github.cc3002.finalreality.model.states.PlayerWinsState;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

public class FlowController {
  private IGameState currentState;
  private PlayerController playerController;
  private EnemyController enemyController;
  private TurnController turnController;
  private NoCharactersOnGame noCharactersOnGame = new NoCharactersOnGame(this);
  private NoEnemiesOnGame noEnemiesOnGame = new NoEnemiesOnGame(this);
  private IAction action;

  /**
   * Class for manage the game's flow, it has 3 states: fight, player wins and player loses
   * @param enemyController
   * @param playerController
   */
  public FlowController(EnemyController enemyController,
                        PlayerController playerController,
                        TurnController turnController){
    this.turnController = turnController;
    this.playerController = playerController;
    this.enemyController = enemyController;
    playerController.addNoPlayersOnGameListener(noCharactersOnGame);
    enemyController.addNoEnemiesOnGameListener(noEnemiesOnGame);
    currentState = new FightState(this.turnController);
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

  /*public void setSelected() {
    ((IFightState)currentState).setSelected(turnController.getUnit());
  }*/

  public void setSelectedWeapon(IWeapon weapon){
    ((IFightState)currentState).setSelectedWeapon(weapon);
  }

  public void setTarget(Enemy unit) {
    ((IFightState)currentState).setTarget(unit);
  }

  public void setAction(IAction action){
    ((IFightState) currentState).setAction(action);
  }

  public void doAction() {
    ((IFightState) currentState).doAction();
    turnController.waitTurn(turnController.getUnit());
    currentState = new FightState(turnController);
  }
}

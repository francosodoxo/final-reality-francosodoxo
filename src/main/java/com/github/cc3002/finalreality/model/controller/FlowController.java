package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.gui.FinalReality;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.listeners.NoCharactersOnGame;
import com.github.cc3002.finalreality.model.listeners.NoEnemiesOnGame;
import com.github.cc3002.finalreality.model.listeners.RefreshLabelCurrentTurn;
import com.github.cc3002.finalreality.model.listeners.RefreshLabelsHealthHandler;
import com.github.cc3002.finalreality.model.states.FightState;
import com.github.cc3002.finalreality.model.states.IFightState;
import com.github.cc3002.finalreality.model.states.IGameState;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import javafx.application.Application;

import java.beans.PropertyChangeSupport;

public class FlowController {
  private IGameState currentState;
  private PlayerController playerController;
  private EnemyController enemyController;
  private TurnController turnController;
  private NoCharactersOnGame noCharactersOnGame = new NoCharactersOnGame(this);
  private NoEnemiesOnGame noEnemiesOnGame = new NoEnemiesOnGame(this);
  private PropertyChangeSupport labelHealthChange;
  private PropertyChangeSupport refreshCurrentUnitLabel;
  private Application application;
  /**
   * Class for manage the game's flow, it has 3 states: fight, player wins and player loses
   * @param playerController
   */
  public FlowController(PlayerController playerController,
                        TurnController turnController){
    this.turnController = turnController;
    this.playerController = playerController;
    playerController.addNoPlayersOnGameListener(noCharactersOnGame);
    labelHealthChange = new PropertyChangeSupport(this);
    refreshCurrentUnitLabel= new PropertyChangeSupport(this);
  }

  /**
   * Go to player wins state
   */
  public void goToPlayerWins() throws Exception {
    currentState = currentState.goToPlayerWins();
    if(application != null) {
      application.stop();
    }
  }

  /**
   * Go to player loses state
   */
  public void goToPlayerLoses() throws Exception {
    currentState = currentState.goToPlayerLoses();
    if (application != null) {
      application.stop();
    }
  }

  /**
   * Get the current game state
   * @return
   */
  public IGameState getCurrentState() {
    return currentState;
  }

  public void setTarget(IUnit enemy) {
    ((IFightState)currentState).setTarget(enemy);
  }

  public IUnit getTarget(){
    return ((IFightState) currentState).getTarget();
  }

  public void doAttackAction() {
    ((IFightState) currentState).attackTo();
    try {
      refreshHealthLabels(getTarget());
      ((IFightState) currentState).waitTurn();
      currentState = new FightState(turnController);
      refreshCurrentUnit(((IFightState)currentState).getSource());
    }catch (ClassCastException e){
      ;
    }

  }

  public void refreshCurrentUnit(IUnit unit){
    refreshCurrentUnitLabel.firePropertyChange("current",0,unit);
  }

  public void equip() {
    ((IFightState)currentState).equip();
  }

  public void setWeapon(IWeapon weapon) {
    ((IFightState)currentState).setWeapon(weapon);
  }

  public void addApplication(FinalReality finalReality) {
    application = finalReality;
  }

  public void run() {
    currentState = new FightState(this.turnController);
  }

  public void addRefreshLabelListener(RefreshLabelsHealthHandler refreshLabelsHealthHandler) {
    labelHealthChange.addPropertyChangeListener(refreshLabelsHealthHandler);
  }

  public void refreshHealthLabels(IUnit target){
    labelHealthChange.firePropertyChange("refresh",0,target);
  }

  public void addRefreshLabelCurrentTurnListener(RefreshLabelCurrentTurn refreshLabelCurrentTurn) {
    refreshCurrentUnitLabel.addPropertyChangeListener(refreshLabelCurrentTurn);
  }

  public void addEnemyController(EnemyController enemyController) {
    this.enemyController = enemyController;
    enemyController.addNoEnemiesOnGameListener(noEnemiesOnGame);
  }
}

  /*public void setSelected() {
    ((IFightState)currentState).setSelected(turnController.getUnit());
  }*/

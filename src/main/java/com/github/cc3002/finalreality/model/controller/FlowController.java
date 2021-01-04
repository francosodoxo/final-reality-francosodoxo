package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.gui.FinalReality;
import com.github.cc3002.finalreality.gui.actions.IAction;
import com.github.cc3002.finalreality.gui.elements.LabelElement;
import com.github.cc3002.finalreality.gui.elements.LabelElementBuilder;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.character.player.BlackMagician;
import com.github.cc3002.finalreality.model.listeners.NoCharactersOnGame;
import com.github.cc3002.finalreality.model.listeners.NoEnemiesOnGame;
import com.github.cc3002.finalreality.model.listeners.RefreshLabelsHandler;
import com.github.cc3002.finalreality.model.states.FightState;
import com.github.cc3002.finalreality.model.states.IFightState;
import com.github.cc3002.finalreality.model.states.IGameState;
import com.github.cc3002.finalreality.model.states.PlayerWinsState;
import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

public class FlowController {
  private IGameState currentState;
  private PlayerController playerController;
  private EnemyController enemyController;
  private TurnController turnController;
  private NoCharactersOnGame noCharactersOnGame = new NoCharactersOnGame(this);
  private NoEnemiesOnGame noEnemiesOnGame = new NoEnemiesOnGame(this);
  private PropertyChangeSupport labelChange;
  private Application application;
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
    labelChange = new PropertyChangeSupport(this);

  }

  /**
   * Go to player wins state
   */
  public void goToPlayerWins() throws Exception {
    currentState = currentState.goToPlayerWins();
    application.stop();
  }

  /**
   * Go to player loses state
   */
  public void goToPlayerLoses() throws Exception {
    currentState = currentState.goToPlayerLoses();
    application.stop();
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

  public void doAttackAction() {
    ((IFightState) currentState).attackTo();
    try {
      ((IFightState) currentState).waitTurn();
      currentState = new FightState(turnController);
    }catch (ClassCastException e){
      ;
    }
    refreshLabels();
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

  public void addRefreshLabelListener(RefreshLabelsHandler refreshLabelsHandler) {
    labelChange.addPropertyChangeListener(refreshLabelsHandler);
  }

  public void refreshLabels(){
    labelChange.firePropertyChange("refresh",0,0);
  }
}

  /*public void setSelected() {
    ((IFightState)currentState).setSelected(turnController.getUnit());
  }*/

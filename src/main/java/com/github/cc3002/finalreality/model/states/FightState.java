package com.github.cc3002.finalreality.model.states;

import com.github.cc3002.finalreality.gui.actions.IAction;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.controller.FightController;
import com.github.cc3002.finalreality.model.controller.TurnController;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

/**
 * Class that represents the fight game state
 */
public class FightState implements IGameState, IFightState{
  private TurnController turnController;
  private IUnit selected;
  private IWeapon selectedWeapon;
  private Enemy target;
  private IAction action;

  public FightState(TurnController turnController) {
    this.turnController = turnController;
    selected = turnController.getUnit();
  }

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

  @Override
  public void setSelected(IUnit character) {
    selected = character;
  }

  @Override
  public void setSelectedWeapon(IWeapon weapon) {
    selectedWeapon = weapon;
  }

  @Override
  public void setTarget(Enemy unit) {
    this.action.setTarget(unit);
  }

  @Override
  public void setAction(IAction action) {
    this.action = action;
    this.action.setSelected(selected);
    this.action.setSelectedWeapon(selectedWeapon);
    this.action.setTarget(target);
  }

  @Override
  public void doAction() {
    action.performAction();
  }


  @Override
  public boolean equals(Object o){
    return o instanceof FightState;
  }
}

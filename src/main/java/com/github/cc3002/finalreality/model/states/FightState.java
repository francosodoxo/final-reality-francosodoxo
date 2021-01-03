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
  private IUnit source;
  private FightController fightController;
  private IWeapon selectedWeapon;
  private IUnit target;
  private TurnController turnController;

  public FightState(TurnController turnController) {
    fightController = new FightController();
    this.turnController = turnController;
    source = turnController.getUnit();
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
  public boolean equals(Object o){
    return o instanceof FightState;
  }


  @Override
  public void setSelectedWeapon(IWeapon weapon) {

  }

  @Override
  public void setTarget(IUnit unit) {
    target = unit;
  }

  @Override
  public void attackTo() {
    fightController.attacksTo(source, target);
  }

  @Override
  public void equip() {
    ((ICharacter)source).tryToEquip(selectedWeapon);
  }

  @Override
  public void setWeapon(IWeapon weapon) {
    selectedWeapon = weapon;
  }

  @Override
  public void waitTurn() {
    turnController.waitTurn(source);
  }
}

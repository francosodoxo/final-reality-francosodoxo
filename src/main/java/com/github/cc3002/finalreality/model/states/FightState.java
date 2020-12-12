package com.github.cc3002.finalreality.model.states;

import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.controller.FightController;
import com.github.cc3002.finalreality.model.controller.TurnController;

/**
 * Class that represents the fight game state
 */
public class FightState implements IGameState{
  TurnController turnController;

  public FightState(TurnController turnController) {
    this.turnController = turnController;
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

  public void run(){
    IUnit unit = turnController.getUnit();
    turnController.waitInput(unit);
    turnController.waitTurn(unit);
  }

  @Override
  public boolean equals(Object o){
    return o instanceof FightState;
  }
}

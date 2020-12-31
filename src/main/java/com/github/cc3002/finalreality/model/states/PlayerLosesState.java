package com.github.cc3002.finalreality.model.states;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

/**
 * Represents a player lose.
 */
public class PlayerLosesState implements IGameState {
  @Override
  public boolean equals(Object o){
    return o instanceof PlayerLosesState;
  }

  /**
   * Only for finishing the game
   * @return
   */
  @Override
  public IGameState goToPlayerWins() {
    return null;
  }

  /**
   * Only for finishing the game
   * @return
   */
  @Override
  public IGameState goToPlayerLoses() {
    return null;
  }

}

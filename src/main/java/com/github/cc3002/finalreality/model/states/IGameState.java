package com.github.cc3002.finalreality.model.states;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

public interface IGameState {
  /**
   * Goes to the player wins state
   * @return
   */
  IGameState goToPlayerWins();

  /**
   * Goes to the player loses state
   * @return
   */
  IGameState goToPlayerLoses();

  //void run();
}

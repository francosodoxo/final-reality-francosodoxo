package com.github.cc3002.finalreality.model.states;

import com.github.cc3002.finalreality.gui.actions.IAction;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

public interface IFightState {
  void setSelectedWeapon(IWeapon weapon);
  void setTarget(IUnit unit);

  void attackTo();

  void equip();

  void setWeapon(IWeapon weapon);

  void waitTurn();

  IUnit getTarget();

  IUnit getSource();
}

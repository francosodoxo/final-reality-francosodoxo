package com.github.cc3002.finalreality.model.states;

import com.github.cc3002.finalreality.gui.actions.IAction;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

public interface IFightState {
  void setSelected(IUnit character);
  void setSelectedWeapon(IWeapon weapon);
  void setTarget(Enemy unit);

  void setAction(IAction action);
  void doAction();
}

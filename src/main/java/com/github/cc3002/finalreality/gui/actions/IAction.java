package com.github.cc3002.finalreality.gui.actions;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

public interface IAction {
  void performAction();

  void setSelected(IUnit selected);


  void setSelectedWeapon(IWeapon selectedWeapon);

  void setTarget(Enemy target);
}

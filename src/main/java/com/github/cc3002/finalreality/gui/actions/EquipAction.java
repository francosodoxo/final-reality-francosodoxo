package com.github.cc3002.finalreality.gui.actions;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

public class EquipAction implements IAction {
  private IUnit selected;
  private IWeapon weapon;

  @Override
  public void performAction() {
    ((ICharacter) selected).tryToEquip(weapon);
  }

  @Override
  public void setSelected(IUnit selected) {
    this.selected = selected;
  }

  @Override
  public void setSelectedWeapon(IWeapon selectedWeapon) {
    this.weapon = selectedWeapon;
  }

  @Override
  public void setTarget(Enemy target) {
    ;
  }
}

package com.github.cc3002.finalreality.gui.actions;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.controller.FightController;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

public class AttackAction implements IAction {
  private IUnit selected;
  private Enemy target;
  private FightController fightController;

  public AttackAction(FightController fightController){
    this.fightController = fightController;
  }

  @Override
  public void performAction() {
    fightController.attacksTo(selected, target);
  }

  @Override
  public void setSelected(IUnit selected) {
    this.selected = selected;
  }

  @Override
  public void setSelectedWeapon(IWeapon selectedWeapon) {
    ;
  }

  @Override
  public void setTarget(Enemy target) {
    this.target = target;
  }
}

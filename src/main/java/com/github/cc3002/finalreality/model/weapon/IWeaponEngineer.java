package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.Engineer;

public interface IWeaponEngineer {
  public void equippedByEngineer(Engineer engineer);

  int getDamage();

  int getWeight();
}

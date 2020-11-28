package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.Engineer;

public interface IWeaponEngineer {
  /**
   * Tells the engineer to equip this weapon
   * @param engineer
   */
  public void equippedByEngineer(Engineer engineer);

  /**
   * Get this weapon's damage
   * @return
   */
  int getDamage();

  /**
   * Get this weapon's weight
   * @return
   */
  int getWeight();
}

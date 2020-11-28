package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.Thief;

public interface IWeaponThief {
  /**
   * Tells the thief to equip this weapon
   * @param thief
   */
  void equippedByThief(Thief thief);

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

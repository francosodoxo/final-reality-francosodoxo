package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.Knight;

public interface IWeaponKnight {
  /**
   * Tells the knight to equip this weapon
   * @param knight
   */
  void equippedByKnight(Knight knight);

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

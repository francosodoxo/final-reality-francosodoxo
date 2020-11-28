package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.WhiteMagician;

public interface IWeaponWhite {
  /**
   * Tells the white magician to equip this weapon
   * @param whiteMagician
   */
  void equippedByWhite(WhiteMagician whiteMagician);

  /**
   * Get this weapon's weight
   * @return
   */
  int getWeight();

  /**
   * Get this weapon's damage
   * @return
   */
  int getDamage();
}

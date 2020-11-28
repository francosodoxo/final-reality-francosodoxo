package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.BlackMagician;

public interface IWeaponBlack {
  /**
   * Method to equip a allowed weapon to a black magician
   * @param blackMagician
   */
  void equippedByBlackMagician(BlackMagician blackMagician);

  /**
   * Get the weapon's damage
   * @return
   */
  int getDamage();

  /**
   * Get the weapon's weight
   * @return
   */
  int getWeight();
}

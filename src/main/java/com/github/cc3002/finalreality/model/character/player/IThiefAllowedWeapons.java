package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.weapon.IWeaponThief;

/**
 * Interface that represents all the thief's allowed weapons
 */
public interface IThiefAllowedWeapons {
  /**
   * Equip a weapon
   * @param weapon
   */
  void equip(IWeaponThief weapon);

  /**
   * Get the equipped weapon
   * @return
   */
  IWeaponThief getEquippedWeapon();

  /**
   * Sets the equipped weapon
   * @param weapon
   */
  void setEquippedWeapon(IWeaponThief weapon);
}

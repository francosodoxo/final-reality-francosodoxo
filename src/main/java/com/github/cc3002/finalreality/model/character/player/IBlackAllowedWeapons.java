package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.weapon.IWeaponBlack;

/**
 * Interface that repensents all the black magician's allowed weapons
 */
public interface IBlackAllowedWeapons {
  /**
   * Equip a weapon to a black magician
   * @param weapon
   */
  void equip(IWeaponBlack weapon);

  /**
   * Get the equipped weapon
   * @return
   */
  IWeaponBlack getEquippedWeapon();

  /**
   * Sets the equipped weapon
   * @param weapon
   */
  void setEquippedWeapon(IWeaponBlack weapon);
}

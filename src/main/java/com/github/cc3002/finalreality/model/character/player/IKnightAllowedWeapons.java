package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.weapon.IWeaponKnight;

/**
 * Interface that represents all the knight's allowed weapons
 */
public interface IKnightAllowedWeapons {
  /**
   * Equip a weapon to a knight
   * @param weapon
   */
  void equip(IWeaponKnight weapon);

  /**
   * Get the equipped weapon
   * @return
   */
  IWeaponKnight getEquippedWeapon();

  /**
   * Sets the equipped weapon
   * @param weapon
   */
  void setEquippedWeapon(IWeaponKnight weapon);
}

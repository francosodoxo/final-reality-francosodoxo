package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.weapon.IWeaponEngineer;

/**
 * Interface that represents all the engineer's allowed weapons
 */
public interface IEngineerAllowedWeapons {

  /**
   * Equip a weapon to an engineer
   * @param weapon
   */
  void equip(IWeaponEngineer weapon);

  /**
   * Get the equipped weapon
   * @return
   */
  IWeaponEngineer getEquippedWeapon();

  /**
   * Sets the equipped weapon
   * @param weapon
   */
  void setEquippedWeapon(IWeaponEngineer weapon);
}

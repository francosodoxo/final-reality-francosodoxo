package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.weapon.IWeaponWhite;

/**
 * Interface that represents all the white magician's allowed weapons
 */
public interface IWhiteAllowedWeapons {
  void equip(IWeaponWhite weapon);
  IWeaponWhite getEquippedWeapon();
  void setEquippedWeapon(IWeaponWhite weapon);
}

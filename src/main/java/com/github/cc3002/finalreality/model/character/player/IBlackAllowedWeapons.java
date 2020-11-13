package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.weapon.IWeaponBlack;

public interface IBlackAllowedWeapons {
  void equip(IWeaponBlack weapon);
  IWeaponBlack getEquippedWeapon();
  void setEquippedWeapon(IWeaponBlack weapon);
}

package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.weapon.IWeaponThief;

public interface IThiefAllowedWeapons {
  void equip(IWeaponThief weapon);
  IWeaponThief getEquippedWeapon();
  void setEquippedWeapon(IWeaponThief weapon);
}

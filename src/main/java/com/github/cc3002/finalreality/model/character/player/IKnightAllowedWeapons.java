package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.weapon.IWeaponKnight;

public interface IKnightAllowedWeapons {
  void equip(IWeaponKnight weapon);
  IWeaponKnight getEquippedWeapon();
  void setEquippedWeapon(IWeaponKnight weapon);
}

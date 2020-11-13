package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.weapon.IWeaponEngineer;

public interface IEngineerAllowedWeapons {
  void equip(IWeaponEngineer weapon);
  IWeaponEngineer getEquippedWeapon();
  void setEquippedWeapon(IWeaponEngineer weapon);
}

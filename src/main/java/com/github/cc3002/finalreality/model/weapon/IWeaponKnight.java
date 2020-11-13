package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.Knight;

public interface IWeaponKnight {
  void equippedByKnight(Knight knight);
  int getDamage();

  int getWeight();
}

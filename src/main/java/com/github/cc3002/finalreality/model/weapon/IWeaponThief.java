package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.Thief;

public interface IWeaponThief {
  void equippedByThief(Thief thief);
  int getDamage();

  int getWeight();
}

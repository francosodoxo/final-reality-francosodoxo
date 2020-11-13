package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.WhiteMagician;

public interface IWeaponWhite {
  void equippedByWhite(WhiteMagician whiteMagician);

  int getWeight();

  int getDamage();
}

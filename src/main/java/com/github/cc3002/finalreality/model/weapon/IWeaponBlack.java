package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.BlackMagician;

public interface IWeaponBlack {
  void equippedByBlackMagician(BlackMagician blackMagician);

  int getDamage();

  int getWeight();
}

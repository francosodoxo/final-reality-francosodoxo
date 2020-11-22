package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.character.player.*;

public class FightController {
  public void blackMagicianAttacksTo(BlackMagician blackMagician, Enemy enemy) {
    blackMagician.attackTo(enemy);
  }

  public void engineerAttacksTo(Engineer engineer, Enemy enemy) {
    engineer.attackTo(enemy);
  }

  public void knightAttacksTo(Knight knight, Enemy enemy) {
    knight.attackTo(enemy);
  }

  public void thiefAttacksTo(Thief thief, Enemy enemy) {
    thief.attackTo(enemy);
  }

  public void whiteMagicianAttacksTo(WhiteMagician whiteMagician, Enemy enemy) {
    whiteMagician.attackTo(enemy);
  }

  public void enemyAttacksTo(Enemy enemy, IUnit character) {
    enemy.attackTo(character);
  }
}

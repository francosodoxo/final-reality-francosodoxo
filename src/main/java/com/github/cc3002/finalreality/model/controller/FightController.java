package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.character.player.*;

/**
 * Controller for managing the fights
 */
public class FightController {

  /**
   * Method invoked to perform an engineer's attack
   * @param engineer
   * @param enemy
   */
  public void engineerAttacksTo(Engineer engineer, Enemy enemy) {
    engineer.attackTo(enemy);
  }

  /**
   * Method invoked to perform a knight's attack
   * @param knight
   * @param enemy
   */
  public void knightAttacksTo(Knight knight, Enemy enemy) {
    knight.attackTo(enemy);
  }

  /**
   * Method invoked to perform a thief's attack
   * @param thief
   * @param enemy
   */
  public void thiefAttacksTo(Thief thief, Enemy enemy) {
    thief.attackTo(enemy);
  }

  /**
   * Method invoked to perform a white magician's attack
   * @param whiteMagician
   * @param enemy
   */
  public void whiteMagicianAttacksTo(WhiteMagician whiteMagician, Enemy enemy) {
    whiteMagician.attackTo(enemy);
  }

  /**
   * Method invoked to perform an enemy's attack
   * @param enemy
   * @param character
   */
  public void enemyAttacksTo(Enemy enemy, IUnit character) {
    enemy.attackTo(character);
  }

  public void attacksTo(IUnit source, IUnit target){
    source.attackTo(target);
  }
}

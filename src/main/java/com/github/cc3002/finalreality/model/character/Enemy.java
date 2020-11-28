package com.github.cc3002.finalreality.model.character;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import com.github.cc3002.finalreality.model.character.player.UnitClass;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author Franco Seguel Lucero
 */
public class Enemy extends AbstractUnit{

  private final int weight;
  private int atk;

  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   * @param name
   *      The enemy's name
   * @param weight
   *      The enemy's weight
   * @param turnsQueue
   *      The turns queue
   * @param healthPoints
   *      The health points
   * @param defense
   *      The defense points
   */
  public Enemy(@NotNull final String name,
               final int weight,
      @NotNull final BlockingQueue<IUnit> turnsQueue,
               int healthPoints,
               int atk,
               int defense) {
    super(turnsQueue, name, healthPoints, UnitClass.ENEMY,defense);
    this.weight = weight;
    this.atk = atk;
  }

  /**
   * Returns this enemy's weight.
   */
  public int getWeight() {
    return weight;
  }

  /**
   * Compare this unit with another or itself
   * */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;  //Check construction
    }
    if (!(o instanceof Enemy)) {
      return false;
    }
    final Enemy enemy = (Enemy) o;
    return getAtk() == enemy.getAtk() &&
            getHealthPoints() == enemy.getHealthPoints() &&
            getWeight() == enemy.getWeight() &&
            getName().equals(enemy.getName()) &&
            getDefense() == enemy.getDefense();
  }

  /**
   * Get the hashcode of this unit
   * */
  @Override
  public int hashCode() {
    return Objects.hash(getWeight());
  }

  @Override
  public void waitTurn() {
    super.getScheduledExecutor()
            .schedule(this::addToQueue, this.getWeight() / 10, TimeUnit.SECONDS);
  }

  /**
   * Get a copy of this enemy
   * */
  @Override
  public IUnit copy() {
    return new Enemy(this.getName(),this.getWeight(),this.getTurnsQueue(),this.getHealthPoints(),this.getAtk(), this.getDefense());
  }

  /**
   * Get the current atk of this character
   * */
  public int getAtk() {
    return atk;
  }

  /**
   * Set this unit atk
   * */
  public void setAtk(int newValue){
    atk = newValue;
  }

  /**
   * Attack to a unit
   * */
  public void attackTo(IUnit character){
    if(character.getHealthPoints()>0 && !character.equals(this)) {
      character.receiveAtk(getAtk());
    }
  }
}

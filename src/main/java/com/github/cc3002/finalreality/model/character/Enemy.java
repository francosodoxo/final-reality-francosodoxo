package com.github.cc3002.finalreality.model.character;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

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
   */
  public Enemy(@NotNull final String name,
               final int weight,
      @NotNull final BlockingQueue<IUnit> turnsQueue,
               int healthPoints,
               int atk) {
    super(turnsQueue, name, healthPoints, UnitClass.ENEMY);
    this.weight = weight;
    this.atk = atk;
  }

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Enemy)) {
      return false;
    }
    final Enemy enemy = (Enemy) o;
    return getWeight() == enemy.getWeight();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getWeight());
  }

  @Override
  protected IUnit copy() {
    return new Enemy(this.getName(),this.getWeight(),this.getTurnsQueue(),this.getHealthPoints(),this.getAtk());
  }

  public int getAtk() {
    return atk;
  }
}

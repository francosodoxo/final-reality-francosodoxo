package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.UnitClass;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Franco Seguel Lucero
 */
public abstract class AbstractUnit implements IUnit{

  protected final BlockingQueue<IUnit> turnsQueue;
  protected final String name;
  private int healthPoints;
  private UnitClass unitClass;

  private ScheduledExecutorService scheduledExecutor;

  /**
   * Holds the common parameters the subclasses have
   *
   * @param turnsQueue
   *    The turn the unit will have to wait for
   * @param name
   *    The unit's name
   * @param healthPoints
   *    The unit's name
   * @param unitClass
   *    The unit's class
   */
  protected AbstractUnit(@NotNull BlockingQueue<IUnit> turnsQueue,
                         @NotNull String name, int healthPoints, UnitClass unitClass) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.healthPoints = healthPoints;
    this.unitClass = unitClass;
  }
  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    if (this instanceof ICharacter) {
      scheduledExecutor
          .schedule(this::addToQueue, ((ICharacter) this).getEquippedWeapon().getWeight() / 10, TimeUnit.SECONDS);
    } else {
      var enemy = (Enemy) this;
      scheduledExecutor
          .schedule(this::addToQueue, enemy.getWeight() / 10, TimeUnit.SECONDS);
    }
  }

  /**
   * Adds this character to the turns queue.
   */
  @Override
  public void addToQueue() {
    turnsQueue.add(this.copy());
    scheduledExecutor.shutdown();
  }

  protected abstract IUnit copy();

  /**
   * Get the turns Queue
   * */
  public BlockingQueue<IUnit> getTurnsQueue(){
    return turnsQueue;
  }

  /**
   * Get the health points
   * */
  public int getHealthPoints(){
    return healthPoints;
  }

  /**
   * Get the unit's name
   * */
  @Override
  public String getName() {
    return name;
  }

  /**
   * Get the unit's class
   */
  @Override
  public UnitClass getUnitClass() {
    return unitClass;
  }
}

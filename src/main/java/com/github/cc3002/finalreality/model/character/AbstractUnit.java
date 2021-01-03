package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.UnitClass;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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

  protected BlockingQueue<IUnit> turnsQueue;
  protected final String name;
  private int healthPoints;
  private int defense;
  private UnitClass unitClass;
  private PropertyChangeSupport unitDead = new PropertyChangeSupport(this);

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
                         @NotNull String name, int healthPoints, UnitClass unitClass,
                         int defense) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.healthPoints = healthPoints;
    this.unitClass = unitClass;
    this.defense = defense;
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
  }
  public void addUnitDeadListener(PropertyChangeListener listener){
    unitDead.addPropertyChangeListener(listener);
  }
  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  @Override
  public abstract void waitTurn(); /*{
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    if (this instanceof ICharacter) {

    } else {
      var enemy = (Enemy) this;
      scheduledExecutor
          .schedule(this::addToQueue, enemy.getWeight() / 10, TimeUnit.SECONDS);
    }
  }
*/
  /**
   * Adds this character to the turns queue.
   */
  @Override
  public void addToQueue() {
    turnsQueue.add(this.copy());
    scheduledExecutor.shutdown();
  }

  /**
   * Get the turns Queue
   * */
  public BlockingQueue<IUnit> getTurnsQueue(){
    return turnsQueue;
  }

  /**
   * Set turnsQueue
   */
  public void setTurnsQueue(BlockingQueue<IUnit> turnsQueue){
    this.turnsQueue = turnsQueue;
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
   * Get this unit's defense
   * */
  public int getDefense(){
    return defense;
  }

  /**
   * Set this unit defense
   * */
  public void setDefense(int i){
    defense = i;
  }


  /**
   * Get the unit's class
   */
  @Override
  public UnitClass getUnitClass() {
    return unitClass;
  }

  /**
   * Set the health points
   * */
  public void setHealthPoints(int newValue){
    int oldHealthPoints = healthPoints;
    healthPoints = Math.max(0,newValue);
    if(healthPoints == 0){
      unitDead.firePropertyChange("unitDead",oldHealthPoints,this);
    }
  }

  /**
   * Copy the Unit
   * */
  public abstract IUnit copy();

  /**
   * Attack to a unit
   * */
  public abstract void attackTo(IUnit character);

  /**
   * Receive the atk
   * */
  public void receiveAtk(int atk){
    int damage = atk-getDefense();
    reduceHealthPoints(damage);
  }

  /**
   * Reduce health points only accesible to this unit
   * */
  private void reduceHealthPoints(int damage){
    setHealthPoints(getHealthPoints()-damage);
  }

  public ScheduledExecutorService getScheduledExecutor(){
    return scheduledExecutor;
  }

}

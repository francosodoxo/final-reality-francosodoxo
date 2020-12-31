package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractUnit;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.NullWeapon;
import com.github.cc3002.finalreality.model.weapon.WeaponType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Class that manages the player's characters
 * */
public abstract class AbstractCharacter extends AbstractUnit implements ICharacter, IUnit {
  private UnitClass unitClass;

  /**
   * Abstract Constructor for this class
   *
   * @param name
   *      The character's name
   * @param unitClass
   *      The character's class
   * @param turnsQueue
   *      The queue the characters wait for
   * @param healthPoints
   *      The maximum health points the character will have
   * @param defense
   *      The defense points the character will have.
   * */
  protected AbstractCharacter(@NotNull String name,
                              @NotNull UnitClass unitClass,
                              @NotNull BlockingQueue<IUnit> turnsQueue,
                              int healthPoints,
                              int defense){
    super(turnsQueue,name,healthPoints,unitClass,defense);
  }




  /**
   * Returns this unit class
   * */
  @Override
  public UnitClass getUnitClass() {
    return super.getUnitClass();
  }



  /**
   * Hashcode to work with
   * */
  @Override
  public int hashCode(){
    return Objects.hash(super.getDefense());
  }

  /**
   * Do an attack against an IUnit
   * */
  @Override
  public abstract void attackTo(IUnit enemy);

  public abstract void waitTurn(); /*{
    super.getScheduledExecutor()
            .schedule(this::addToQueue, this.getEquippedWeapon().getWeight() / 10, TimeUnit.SECONDS);
  }*/
  @Override
  public abstract void tryToEquip(IWeapon weapon);
}

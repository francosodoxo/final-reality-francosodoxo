package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.weapon.IWeaponThief;
import com.github.cc3002.finalreality.model.weapon.NullWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Class that manages Thieves units
 * */
public class Thief extends AbstractCharacter implements IThiefAllowedWeapons {
  IWeaponThief weapon;
  /**
   * Creates a Thief
   *
   * @param name
   *          The thief's name
   * @param turnsQueue
   *          The turns order
   * @param healthPoints
   *          The maximum health points this unit will have
   * @param defense
   *          This unit's defense
   * */
  public Thief(@NotNull String name,
               @NotNull BlockingQueue<IUnit> turnsQueue,
               int healthPoints,
               int defense){
    super(name,UnitClass.THIEF,turnsQueue,healthPoints,defense);
    equip(NullWeapon.getNullWeapon());
  }

  /**
   * Creates a copy of this Character
   * */
  @Override
  public IUnit copy() {
    Thief newThief = new Thief(this.getName(),this.getTurnsQueue(),this.getHealthPoints(),this.getDefense());
    newThief.equip(getEquippedWeapon());
    return newThief;
  }

  /**
   * Compare with another object or itself
   * */
  @Override
  public boolean equals(Object o){
    if (o == this){
      return true;
    }
    if (!(o instanceof Thief)){
      return false;
    }
    final Thief t = (Thief) o;
    if (!NullWeapon.getNullWeapon().equals(getEquippedWeapon())) {
      return getName().equals(t.getName()) &&
              getHealthPoints() == t.getHealthPoints() &&
              getDefense() == t.getDefense() &&
              getEquippedWeapon().equals(t.getEquippedWeapon());
    }
    else{
      return getName().equals(t.getName()) &&
              getHealthPoints() == t.getHealthPoints() &&
              getDefense() == t.getDefense();
    }
  }

  @Override
  public void equip(IWeaponThief weapon){
    if(getHealthPoints() > 0) {
      ((IWeaponThief) weapon).equippedByThief(this);
    }
  }

  @Override
  public IWeaponThief getEquippedWeapon() {
    return weapon;
  }

  @Override
  public void setEquippedWeapon(IWeaponThief weapon) {
    this.weapon = weapon;
  }

  @Override
  public void attackTo(IUnit enemy) {
    if(enemy.getHealthPoints()>0 && !enemy.equals(this)){
      enemy.receiveAtk(this.getEquippedWeapon().getDamage());
    }
  }

  @Override
  public void waitTurn() {
    super.getScheduledExecutor()
            .schedule(this::addToQueue, this.getEquippedWeapon().getWeight() / 10, TimeUnit.SECONDS);
  }
}

package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.IWeaponWhite;
import com.github.cc3002.finalreality.model.weapon.NullWeapon;
import com.github.cc3002.finalreality.model.weapon.WeaponType;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Class that manages the White Magicians behavior
 */
public class WhiteMagician extends AbstractMagician implements IWhiteAllowedWeapons {
  private IWeaponWhite weapon;
  /**
   * Creates a white magician
   *
   * @param name
   *      This white magician's name
   * @param turnsQueue
   *      The turn the white magician will have to wait for
   * @param healthPoints
   *      The maximum health points this white magician will have
   * @param defense
   *      The defense points this white magician will have
   */
  public WhiteMagician(@NotNull String name,
                       @NotNull BlockingQueue<IUnit> turnsQueue,
                       int healthPoints,
                       int defense){
    super(name,
            UnitClass.WHITE_MAGICIAN,
            turnsQueue,
            healthPoints,
            defense);
    equip(NullWeapon.getNullWeapon());
  }

  /**
   * Get a copy of this unit
   * */
  @Override
  public IUnit copy() {
    WhiteMagician newWhiteMagician = new WhiteMagician(this.getName(),this.getTurnsQueue(),this.getHealthPoints(),this.getDefense());
    newWhiteMagician.equip(getEquippedWeapon());
    return newWhiteMagician;
  }

  /**
   * Compare this unit with another one or itself
   * */
  @Override
  public boolean equals(Object o){
    if (o == this){
      return true;
    }
    if (!(o instanceof WhiteMagician)){
      return false;
    }
    final WhiteMagician w = (WhiteMagician) o;
    if (!NullWeapon.getNullWeapon().equals(getEquippedWeapon())) {
      return getName().equals(w.getName()) &&
              getHealthPoints() == w.getHealthPoints() &&
              getDefense() == w.getDefense() &&
              getEquippedWeapon() == w.getEquippedWeapon();
    }
    else{
      return getName().equals(w.getName()) &&
              getHealthPoints() == w.getHealthPoints() &&
              getDefense() == w.getDefense();
    }
  }

  /**
   * Equip a weapon
   * @param weapon
   */
  @Override
  public void equip(IWeaponWhite weapon) {
    if(getHealthPoints() > 0) {
      ((IWeaponWhite) weapon).equippedByWhite(this);
    }
  }

  /**
   * Get the equipped weapon
   * @return
   */
  @Override
  public IWeaponWhite getEquippedWeapon() {
    return weapon;
  }


  /**
   * Sets the equipped weapon
   * @param weapon
   */
  @Override
  public void setEquippedWeapon(IWeaponWhite weapon) {
    this.weapon = weapon;
  }

  /**
   * Attacks to an enemy
   * @param enemy
   */
  @Override
  public void attackTo(IUnit enemy) {
    if(enemy.getHealthPoints()>0 && !enemy.equals(this)){
      enemy.receiveAtk(this.getEquippedWeapon().getDamage());
    }
  }

  /**
   * Wait their turn
   */
  @Override
  public void waitTurn() {

    super.getScheduledExecutor()
            .schedule(this::addToQueue, this.getEquippedWeapon().getWeight() / 10, TimeUnit.SECONDS);
  }

  @Override
  public void tryToEquip(IWeapon weapon) {
    try{
      this.equip((IWeaponWhite) weapon);
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}

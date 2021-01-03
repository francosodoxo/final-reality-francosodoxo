package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.IWeaponBlack;
import com.github.cc3002.finalreality.model.weapon.NullWeapon;
import com.github.cc3002.finalreality.model.weapon.WeaponType;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Class to create Black Magicians
 * */
public class BlackMagician extends AbstractMagician implements IBlackAllowedWeapons {
  private IWeaponBlack weapon;
  /**
   * Public constructor visible
   *
   * @param name
   *      This magician's name
   * @param turnsQueue
   *      The turn the magician will have to wait for
   * @param healthPoints
   *      The health points this magician will have
   * @param defense
   *      The defense points this magician will have
   */
  public BlackMagician(@NotNull String name,
                       @NotNull BlockingQueue<IUnit> turnsQueue,
                       int healthPoints,
                       int defense){
    super(name,
            UnitClass.BLACK_MAGICIAN,
            turnsQueue,
            healthPoints,
            defense);
    equip(NullWeapon.getNullWeapon());
  }

  /**
   * This method copy this character
   * */
  @Override
  public IUnit copy() {
    BlackMagician newBlackMagician = new BlackMagician(this.getName(),this.getTurnsQueue(),this.getHealthPoints(), this.getDefense());
    newBlackMagician.equip(getEquippedWeapon());
    return newBlackMagician;
  }



  /**
   * Compare this object with another or itself
   * */
  @Override
  public boolean equals(Object o){
    if (o == this){
      return true;
    }
    if (!(o instanceof BlackMagician)){
      return false;
    }
    final BlackMagician b = (BlackMagician) o;
    if(!NullWeapon.getNullWeapon().equals(getEquippedWeapon())) {
      return b.getName().equals(this.getName()) &&
              b.getHealthPoints() == this.getHealthPoints() &&
              b.getDefense() == this.getDefense() &&
              b.getEquippedWeapon().equals(this.getEquippedWeapon());
    }else{
      return b.getName().equals(this.getName()) &&
              b.getHealthPoints() == this.getHealthPoints() &&
              b.getDefense() == this.getDefense();
    }
  }

  /**
   * Equip an allowed weapon to this character
   * @param weapon
   */
  @Override
  public void equip(IWeaponBlack weapon) {
    if(getHealthPoints() > 0) {
      weapon.equippedByBlackMagician(this);
    }
  }



  /**
   * Get the equipped weapon
   * @return
   */
  @Override
  public IWeaponBlack getEquippedWeapon() {
    return weapon;
  }

  /**
   * Sets the equipped weapon
   * @param weapon
   */
  @Override
  public void setEquippedWeapon(IWeaponBlack weapon) {
    this.weapon = weapon;
  }

  /**
   * Attacks to an enemy
   * @param enemy
   */
  @Override
  public void attackTo(IUnit enemy) {
    if(enemy.getHealthPoints()>0 && !enemy.equals(this) && this.getHealthPoints()>0){
      enemy.receiveAtk(this.getEquippedWeapon().getDamage());
    }
  }

  /***
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
      this.equip((IWeaponBlack) weapon);
    }catch (Exception e){
      e.printStackTrace();
    }

  }
}

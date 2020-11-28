package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.Thief;

/**
 * Class that manages the Sword behavior
 * */
public class Sword extends AbstractWeapon implements IWeaponKnight, IWeaponThief{
  /**
   * Creates a Sword
   *
   * @param name
   *      The Sword's name
   * @param damage
   *      The Sword's damage
   * @param weight
   *      The Sword's weight
   */
  public Sword(final String name,
               final int damage,
               final int weight){
    super(name,damage,weight,WeaponType.SWORD);
  }
  /**
   * Get a copy of this weapon
   * */
  public Sword copy(){
    return new Sword(getName(),getDamage(),getWeight());
  }

  /**
   * Compares to another objects or itself
   * */
  @Override
  public boolean equals(Object o){
    if( o == this){
      return true;
    }
    if(!(o instanceof Sword)){
      return false;
    }
    final Sword sword = (Sword) o;
    return getName().equals(sword.getName()) &&
            getDamage() == sword.getDamage() &&
            getWeight() == sword.getWeight();
  }

  /**
   * Tells the knight to equip this weapon
   * @param knight
   */
  @Override
  public void equippedByKnight(Knight knight) {
    knight.setEquippedWeapon(this);
  }

  /**
   * Tells the thief to equip this weapon
   * @param thief
   */
  @Override
  public void equippedByThief(Thief thief) {
    thief.setEquippedWeapon(this);
  }
}

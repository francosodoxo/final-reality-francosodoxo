package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.BlackMagician;
import com.github.cc3002.finalreality.model.character.player.Knight;

/**
 * Class that manages the Knife behavior
 * */
public class Knife extends AbstractWeapon implements IWeaponBlack, IWeaponKnight{
  /**
   * Creates a Knife
   *
   * @param name
   *      The Knife's name
   * @param damage
   *      The Knife's damage
   * @param weight
   *      The Knife's weight
   */
  public Knife(final String name,
               final int damage,
               final int weight){
    super(name,damage,weight,WeaponType.KNIFE);
  }

  /**
   * Get a copy of this weapon
   * */
  public Knife copy(){
    return new Knife(getName(),getDamage(),getWeight());
  }

  /**
   * Compares to another objects or itself
   * */
  @Override
  public boolean equals(Object o){
    if(o == this){
      return true;
    }
    if(!(o instanceof Knife)){
      return false;
    }
    final Knife knife = (Knife) o;
    return getName().equals(knife.getName()) &&
            getDamage() == knife.getDamage() &&
            getWeight() == knife.getWeight();
  }

  /**
   * Tells the black magician to equip this weapon
   * @param blackMagician
   */
  @Override
  public void equippedByBlackMagician(BlackMagician blackMagician) {
    blackMagician.setEquippedWeapon(this);
  }

  /**
   * Tells the knight to equip this weapon
   * @param knight
   */
  @Override
  public void equippedByKnight(Knight knight) {
    knight.setEquippedWeapon(this);
  }
}

package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.character.player.Thief;

/**
 * Class that manages the Bow's behavior
 * */
public class Bow extends AbstractWeapon implements IWeaponEngineer, IWeaponThief {
  /**
   * Creates a Bow
   *
   * @param name
   *      The Bow's name
   * @param damage
   *      The Bow's damage
   * @param weight
   *      The Bow's weight
   */
  public Bow(final String name,
             final int damage,
             final int weight){
    super(name,damage,weight,WeaponType.BOW);
  }

  /**
   * Get a copy of this weapon
   * */
  public Bow copy(){
    return new Bow(getName(),getDamage(),getWeight());
  }

  /**
   * Compare to another objects or itself
   * */
  @Override
  public boolean equals(Object o){
    if( o == this ){
      return true;
    }
    if(!(o instanceof Bow)){
      return false;
    }
    final Bow bow = (Bow) o;
    return getName().equals(bow.getName()) &&
            getDamage() == bow.getDamage() &&
            getWeight() == bow.getWeight();
  }

  @Override
  public void equippedByEngineer(Engineer engineer) {
    engineer.setEquippedWeapon(this);
  }

  @Override
  public void equippedByThief(Thief thief) {
    thief.setEquippedWeapon((IWeaponThief) this);
  }
}

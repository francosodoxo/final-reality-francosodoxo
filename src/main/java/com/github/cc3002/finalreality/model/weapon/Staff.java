package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.*;

/**
 * Class that manages the Staff behavior
 * */
public class Staff extends AbstractWeapon implements IWeaponThief,IWeaponWhite, IWeaponBlack{
  /**
   * Creates a Staff
   *
   * @param name
   *      The Staff's name
   * @param damage
   *      The Staff's damage
   * @param weight
   *      The Staff's weight
   */
  public Staff(final String name,
               final int damage,
               final int weight){
    super(name,damage,weight,WeaponType.STAFF);
  }
  /**
   * Creates a copy of this object
   * */
  public Staff copy(){
    return new Staff(getName(),getDamage(),getWeight());
  }

  /**
   * Compares to another objects or itself
   * */
  @Override
  public boolean equals(Object o){
    if(o == this){
      return true;
    }
    if(!(o instanceof Staff)){
      return false;
    }
    final Staff staff = (Staff) o;
    return getName().equals(staff.getName()) &&
            getDamage() == staff.getDamage() &&
            getWeight() == staff.getWeight();
  }

  /**
   * Tells the thief to equip this weapon
   * @param thief
   */
  @Override
  public void equippedByThief(Thief thief) {
    thief.setEquippedWeapon(this);
  }

  /**
   * Tells the white magician to equip this weapon
   * @param whiteMagician
   */
  @Override
  public void equippedByWhite(WhiteMagician whiteMagician) {
    whiteMagician.setEquippedWeapon(this);
  }

  /**
   * Tells the black magician to equip this weapon
   * @param blackMagician
   */
  @Override
  public void equippedByBlackMagician(BlackMagician blackMagician) {
    blackMagician.setEquippedWeapon(this);
  }
}

package com.github.cc3002.finalreality.model.weapon;

import java.util.Objects;

/**
 * A class that holds all the information of a weapon.
 *
 * @author Ignacio Slater Muñoz.
 * @author Franco Seguel
 */
public class AbstractWeapon implements IWeapon {

  private final String name;
  private final int damage;
  private final int weight;
  private final WeaponType type;

  /**
   * Creates a weapon with a name, a base damage, weight and its type.
   *
   * @see WeaponType
   *
   * @param name
   *    The weapon's name
   * @param damage
   *    The weapon's damage
   * @param weight
   *    The weapon's weight
   * @param type
   *    The weapon's type
   */
  public AbstractWeapon(final String name,
                        final int damage,
                        final int weight,
                        final WeaponType type) {
    this.name = name;
    this.damage = damage;
    this.weight = weight;
    this.type = type;
  }

  /**
   * Returns the weapon's name
   * */
  public String getName() {
    return name;
  }

  /**
   * Returns the weapon's damage
   * */
  @Override
  public int getDamage() {
    return damage;
  }

  /**
   * Returns the weapon's weight
   * */
  @Override
  public int getWeight() {
    return weight;
  }

  /**
   * Returns the weapon's type
   * */
  @Override
  public WeaponType getType() {
    return type;
  }

  /**
   * Compares to another object or itself
   * */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractWeapon)) {
      return false;
    }
    final IWeapon weapon = (IWeapon) o;
    return getDamage() == weapon.getDamage() &&
        getWeight() == weapon.getWeight() &&
        getName().equals(weapon.getName()) &&
        getType() == weapon.getType();
  }

  /**
   * Get the weapon's hashcode
   * */
  @Override
  public int hashCode() {
    return Objects.hash(getName(), getDamage(), getWeight(), getType());
  }
}

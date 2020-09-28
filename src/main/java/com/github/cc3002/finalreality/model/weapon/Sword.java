package com.github.cc3002.finalreality.model.weapon;

/**
 * Class that manages the Sword behavior
 * */
public class Sword extends AbstractWeapon{
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
}

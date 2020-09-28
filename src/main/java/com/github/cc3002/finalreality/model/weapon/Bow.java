package com.github.cc3002.finalreality.model.weapon;

/**
 * Class that manages the Bow's behavior
 * */
public class Bow extends AbstractWeapon {
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
}

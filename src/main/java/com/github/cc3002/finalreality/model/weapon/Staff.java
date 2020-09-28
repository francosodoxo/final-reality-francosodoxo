package com.github.cc3002.finalreality.model.weapon;

/**
 * Class that manages the Staff behavior
 * */
public class Staff extends AbstractWeapon {
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
}

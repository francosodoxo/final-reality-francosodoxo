package com.github.cc3002.finalreality.model.weapon;

/**
 * Class that manages the Axe's behavior
 * */
public class Axe extends AbstractWeapon {
    /**
     * Creates an Axe
     *
     * @param name
     *      The Axe's name
     * @param damage
     *      The Axe's damage
     * @param weight
     *      The Axe's weight
     */
    public Axe(final String name,
               final int damage,
               final int weight){
        super(name,damage,weight,WeaponType.AXE);
    }
}

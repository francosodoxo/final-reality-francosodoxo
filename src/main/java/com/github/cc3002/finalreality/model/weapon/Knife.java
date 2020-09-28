package com.github.cc3002.finalreality.model.weapon;

/**
 * Class that manages the Knife behavior
 * */
public class Knife extends AbstractWeapon{
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
}

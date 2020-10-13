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

    /**
     * Get a copy of this Weapon
     */
    public Axe copy(){
        return new Axe(getName(),getDamage(),getWeight());
    }

    /**
     * Compares to another objects or itself
     * */
    @Override
    public boolean equals(Object o){
        if( o == this ){
            return true;
        }
        if(!(o instanceof Axe)){
            return false;
        }
        final Axe axe = (Axe) o;
        return getName().equals(axe.getName()) &&
                getDamage() == axe.getDamage() &&
                getWeight() == axe.getWeight();
    }
}

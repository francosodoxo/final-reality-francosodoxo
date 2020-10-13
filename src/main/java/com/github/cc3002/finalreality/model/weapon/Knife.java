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
}

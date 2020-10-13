package com.github.cc3002.finalreality.model.weapon;

/**
 * Handle null weapons
 * */
public class NullWeapon extends AbstractWeapon implements IWeapon{
    private static NullWeapon nullWeapon;

    /**
     * Private constructor only called inside this class
     * */
    private NullWeapon() {
        super();
    }

    /**
     * Only one instace of this object
     * */
    @Override
    public IWeapon copy() {
        return nullWeapon;
    }

    /**
     * Returns the same weapon instance
     * */
    public static NullWeapon getNullWeapon(){
        if(nullWeapon == null) {
            nullWeapon = new NullWeapon();
        }
        return nullWeapon;
    }
}

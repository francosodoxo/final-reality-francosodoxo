package com.github.cc3002.finalreality.model.weapon;

public class Staff extends AbstractWeapon {
    public Staff(final String name,
                 final int damage,
                 final int weight){
        super(name,damage,weight,WeaponType.STAFF);
    }
}

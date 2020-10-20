package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.weapon.NullWeapon;
import com.github.cc3002.finalreality.model.weapon.WeaponType;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * Class that manages engineers
 * */
public class Engineer extends AbstractCharacter {
    /**
     * Creates a Engineer
     *
     * @param name
     *      This character's name
     * @param turnsQueue
     *      The turn this character will have to wait for
     * @param healthPoints
     *      The health points this Engineer will have
     * @param defense
     *      The defense this Engineer will have
     * */
    public Engineer(@NotNull String name,
                    @NotNull BlockingQueue<IUnit> turnsQueue,
                    int healthPoints,
                    int defense){
        super(name,UnitClass.ENGINEER,turnsQueue,healthPoints,defense);
        equip(NullWeapon.getNullWeapon());
        setAllowedWeapon(WeaponType.AXE);
        setAllowedWeapon(WeaponType.BOW);
    }

    /**
     * Get a copy of this character
     * */
    @Override
    public IUnit copy() {
        Engineer newEngineer = new Engineer(this.getName(),this.getTurnsQueue(),this.getHealthPoints(),this.getDefense());
        newEngineer.equip(getEquippedWeapon());
        return newEngineer;
    }

    /**
     * Compare this character with another objects or itself
     * */
    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if(!(o instanceof Engineer)){
            return false;
        }
        final Engineer e = (Engineer) o;
        if (!NullWeapon.getNullWeapon().equals(getEquippedWeapon())) {
            return getName().equals(e.getName()) &&
                    getHealthPoints() == e.getHealthPoints() &&
                    getDefense() == e.getDefense() &&
                    getEquippedWeapon().equals(e.getEquippedWeapon());
        }
        else{
            return getName().equals(e.getName()) &&
                    getHealthPoints() == e.getHealthPoints() &&
                    getDefense() == e.getDefense();
        }
    }
}

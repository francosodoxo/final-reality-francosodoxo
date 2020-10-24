package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.weapon.NullWeapon;
import com.github.cc3002.finalreality.model.weapon.WeaponType;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * Class that manages the White Magicians behavior
 */
public class WhiteMagician extends AbstractMagician {
    /**
     * Creates a white magician
     *
     * @param name
     *      This white magician's name
     * @param turnsQueue
     *      The turn the white magician will have to wait for
     * @param healthPoints
     *      The maximum health points this white magician will have
     * @param defense
     *      The defense points this white magician will have
     */
    public WhiteMagician(@NotNull String name,
                         @NotNull BlockingQueue<IUnit> turnsQueue,
                         int healthPoints,
                         int defense){
        super(name,
                UnitClass.WHITE_MAGICIAN,
                turnsQueue,
                healthPoints,
                defense);
        equip(NullWeapon.getNullWeapon());
        setAllowedWeapon(WeaponType.STAFF);
    }

    /**
     * Get a copy of this unit
     * */
    @Override
    public IUnit copy() {
        WhiteMagician newWhiteMagician = new WhiteMagician(this.getName(),this.getTurnsQueue(),this.getHealthPoints(),this.getDefense());
        newWhiteMagician.equip(getEquippedWeapon());
        return newWhiteMagician;
    }

    /**
     * Compare this unit with another one or itself
     * */
    @Override
    public boolean equals(Object o){
        if (o == this){
            return true;
        }
        if (!(o instanceof WhiteMagician)){
            return false;
        }
        final WhiteMagician w = (WhiteMagician) o;
        if (!NullWeapon.getNullWeapon().equals(getEquippedWeapon())) {
            return getName().equals(w.getName()) &&
                    getHealthPoints() == w.getHealthPoints() &&
                    getDefense() == w.getDefense() &&
                    getEquippedWeapon() == w.getEquippedWeapon();
        }
        else{
            return getName().equals(w.getName()) &&
                    getHealthPoints() == w.getHealthPoints() &&
                    getDefense() == w.getDefense();
        }
    }
}

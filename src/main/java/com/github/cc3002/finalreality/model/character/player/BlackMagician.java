package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.weapon.NullWeapon;
import com.github.cc3002.finalreality.model.weapon.WeaponType;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * Class to create Black Magicians
 * */
public class BlackMagician extends AbstractMagician {
    /**
     * Public constructor visible
     *
     * @param name
     *      This magician's name
     * @param turnsQueue
     *      The turn the magician will have to wait for
     * @param healthPoints
     *      The health points this magician will have
     * @param defense
     *      The defense points this magician will have
     */
    public BlackMagician(@NotNull String name,
                         @NotNull BlockingQueue<IUnit> turnsQueue,
                         int healthPoints,
                         int defense){
        super(name,
                UnitClass.BLACK_MAGICIAN,
                turnsQueue,
                healthPoints,
                defense);
        equip(NullWeapon.getNullWeapon());
        setAllowedWeapon(WeaponType.KNIFE);
        setAllowedWeapon(WeaponType.STAFF);
    }

    /**
     * This method copy this character
     * */
    @Override
    public IUnit copy() {
        BlackMagician newBlackMagician = new BlackMagician(this.getName(),this.getTurnsQueue(),this.getHealthPoints(), this.getDefense());
        newBlackMagician.equip(getEquippedWeapon());
        return newBlackMagician;
    }

    /**
     * Compare this object with another or itself
     * */
    @Override
    public boolean equals(Object o){
        if (o == this){
            return true;
        }
        if (!(o instanceof BlackMagician)){
            return false;
        }
        final BlackMagician b = (BlackMagician) o;
        if(!getEquippedWeapon().equals(NullWeapon.getNullWeapon())) {
            return b.getName().equals(this.getName()) &&
                    b.getHealthPoints() == this.getHealthPoints() &&
                    b.getDefense() == this.getDefense() &&
                    b.getEquippedWeapon().equals(this.getEquippedWeapon());
        }else{
            return b.getName().equals(this.getName()) &&
                    b.getHealthPoints() == this.getHealthPoints() &&
                    b.getDefense() == this.getDefense();
        }
    }
}

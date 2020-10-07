package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.weapon.NullWeapon;
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
    }

    @Override
    protected IUnit copy() {
        return new BlackMagician(this.getName(),this.getTurnsQueue(),this.getHealthPoints(), this.getDefense());
    }
    @Override
    public boolean equals(Object o){
        if (o == this){
            return true;
        }
        if (!(o instanceof BlackMagician)){
            return false;
        }
        final BlackMagician b = (BlackMagician) o;
        if(!NullWeapon.getNullWeapon().equals(getEquippedWeapon())) {
            return b.getName().equals(this.getName()) &&
                    b.getTurnsQueue().equals(this.getTurnsQueue()) &&
                    b.getHealthPoints() == this.getHealthPoints() &&
                    b.getDefense() == this.getDefense() &&
                    b.getEquippedWeapon() == this.getEquippedWeapon();
        }else{
            return b.getName().equals(this.getName()) &&
                    b.getTurnsQueue().equals(this.getTurnsQueue()) &&
                    b.getHealthPoints() == this.getHealthPoints() &&
                    b.getDefense() == this.getDefense();
        }
    }
}

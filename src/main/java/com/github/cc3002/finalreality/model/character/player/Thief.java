package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.weapon.NullWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;
/**
 * Class that manages Thiefs units
 * */
public class Thief extends AbstractCharacter {
    /**
     * Creates a Thief
     *
     * @param name
     *          The thief's name
     * @param turnsQueue
     *          The turns order
     * @param healthPoints
     *          The maximum health points this unit will have
     * @param defense
     *          This unit's defense
     * */
    public Thief(@NotNull String name,
                 @NotNull BlockingQueue<IUnit> turnsQueue,
                 int healthPoints,
                 int defense){
        super(name,UnitClass.THIEF,turnsQueue,healthPoints,defense);
        equip(NullWeapon.getNullWeapon());
    }

    @Override
    protected IUnit copy() {
        return new Thief(this.getName(),this.getTurnsQueue(),this.getHealthPoints(),this.getDefense());
    }
    @Override
    public boolean equals(Object o){
        if (o == this){
            return true;
        }
        if (!(o instanceof Thief)){
            return false;
        }
        final Thief t = (Thief) o;
        if (!NullWeapon.getNullWeapon().equals(getEquippedWeapon())) {
            return getName().equals(t.getName()) &&
                    getTurnsQueue().equals(t.getTurnsQueue()) &&
                    getHealthPoints() == t.getHealthPoints() &&
                    getDefense() == t.getDefense() &&
                    getEquippedWeapon().equals(t.getEquippedWeapon());
        }
        else{
            return getName().equals(t.getName()) &&
                    getTurnsQueue().equals(t.getTurnsQueue()) &&
                    getHealthPoints() == t.getHealthPoints() &&
                    getDefense() == t.getDefense();
        }
    }
}

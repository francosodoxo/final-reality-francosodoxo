package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.weapon.NullWeapon;
import com.github.cc3002.finalreality.model.weapon.WeaponType;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * Class that manages the Knights Units
 * */
public class Knight extends AbstractCharacter {
    /**
     * Creates a Knight
     *
     * @param name
     *      This character's name
     * @param turnsQueue
     *      The turn this character will have to wait for
     * @param healthPoints
     *      The maximum health points this knight will have
     * @param defense
     *      The defense points the knight will have
     * */
    public Knight(@NotNull String name,
                  @NotNull BlockingQueue<IUnit> turnsQueue,
                  int healthPoints,
                  int defense){
        super(name,UnitClass.KNIGHT,turnsQueue,healthPoints,defense);
        equip(NullWeapon.getNullWeapon());
        setAllowedWeapon(WeaponType.SWORD);
        setAllowedWeapon(WeaponType.AXE);
        setAllowedWeapon(WeaponType.KNIFE);
    }


    /**
     * Creates a copy of this knight
     * */
    @Override
    public IUnit copy() {
        Knight newKnight = new Knight(this.getName(), this.getTurnsQueue(),this.getHealthPoints(),this.getDefense());
        newKnight.equip(getEquippedWeapon());
        return newKnight;
    }

    /**
     * Compares itself or with another unit
     * */
    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(!(o instanceof Knight)){
            return false;
        }
        final Knight k = (Knight) o;
        if( !NullWeapon.getNullWeapon().equals(getEquippedWeapon()) ) {
            return getName().equals(k.getName()) &&
                    getHealthPoints() == k.getHealthPoints() &&
                    getDefense() == k.getDefense() &&
                    getEquippedWeapon().equals(k.getEquippedWeapon());
        }else{
            return getName().equals(k.getName()) &&
                    getHealthPoints() == k.getHealthPoints() &&
                    getDefense() == k.getDefense();
        }
    }
}

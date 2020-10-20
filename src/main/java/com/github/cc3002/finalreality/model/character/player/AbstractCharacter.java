package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractUnit;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.NullWeapon;
import com.github.cc3002.finalreality.model.weapon.WeaponType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * Class that manages the player's characters
 * */
public abstract class AbstractCharacter extends AbstractUnit implements ICharacter, IUnit {
    private int defense;
    private IWeapon equippedWeapon;
    private UnitClass unitClass;
    private ArrayList<WeaponType> allowedWeapons;

    /**
     * Abstract Constructor for this class
     *
     * @param name
     *      The character's name
     * @param unitClass
     *      The character's class
     * @param turnsQueue
     *      The queue the characters wait for
     * @param healthPoints
     *      The maximum health points the character will have
     * @param defense
     *      The defense points the character will have.
     * */
    protected AbstractCharacter(@NotNull String name,
                                @NotNull UnitClass unitClass,
                                @NotNull BlockingQueue<IUnit> turnsQueue,
                                int healthPoints,
                                int defense){
        super(turnsQueue,name,healthPoints,unitClass,defense);
        this.equippedWeapon = NullWeapon.getNullWeapon();
        allowedWeapons = new ArrayList<>();
    }

    /**
     * Get the Character defense points
     * */
    public int getDefense(){
        return defense;
    }

    /**
     * Set this character defense
     * */
    @Override
    public void setDefense(int newDefense){
        defense = newDefense;
    }

    /**
     * Set the equipped weapon for this character
     * */
    @Override
    public void equip(IWeapon weapon) {
        if(allowedWeapons.contains(weapon.getType())) {
            this.equippedWeapon = weapon;
        }else{
            this.equippedWeapon = NullWeapon.getNullWeapon();
        }
    }

    /**
     * Returns the equipped weapon this character has
     * */
    @Override
    public IWeapon getEquippedWeapon() {
        return this.equippedWeapon;
    }

    /**
     * Returns this unit class
     * */
    @Override
    public UnitClass getUnitClass() {
        return super.getUnitClass();
    }

    /**
     * Hashcode to work with
     * */
    @Override
    public int hashCode(){
        return Objects.hash(defense);
    }


    /**
     * Method to set the allowed weapons for this character
     * */
    protected void setAllowedWeapon(WeaponType weapon){
        allowedWeapons.add(weapon);
    }

}

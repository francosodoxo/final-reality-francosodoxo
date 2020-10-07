package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractUnit;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * Class that manages the player's characters
 * */
public abstract class AbstractCharacter extends AbstractUnit implements ICharacter, IUnit {
    private int defense;
    private IWeapon equippedWeapon;
    private UnitClass unitClass;
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
        super(turnsQueue,name,healthPoints,unitClass);
        this.defense = defense;
        this.equippedWeapon = null;
    }

    /**
     * This method is called to wait turn
     * */
    @Override
    public void waitTurn() {

    }

    /**
     * Returns the Character's name
     *
    @Override
    public String getName() {
        return super.getName();
    }*/

    /**
     * Get the Character defense points
     * */
    public int getDefense(){
        return defense;
    }

    /**
     * Set the equipped weapon for this character
     * */
    @Override
    public void equip(IWeapon weapon) {
        this.equippedWeapon = weapon;
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
}

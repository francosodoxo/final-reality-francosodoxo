package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractUnit;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public abstract class AbstractCharacter extends AbstractUnit implements ICharacter, IUnit {
    private int defense;
    private Weapon equippedWeapon;
    private CharacterClass unitClass;
    protected AbstractCharacter(@NotNull String name,
                                @NotNull CharacterClass unitClass,
                                @NotNull BlockingQueue<ICharacter> turnsQueue,
                                int healthPoints,
                                int defense){
        super(turnsQueue,name,healthPoints);
        this.defense = defense;
        this.equippedWeapon = null;
        this.unitClass = unitClass;
    }


    @Override
    public void waitTurn() {

    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void equip(Weapon weapon) {
        this.equippedWeapon = weapon;
    }

    @Override
    public Weapon getEquippedWeapon() {
        return this.equippedWeapon;
    }

    @Override
    public String getUnitClass() {
        return unitClass;
    }
}

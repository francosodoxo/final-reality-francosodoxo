package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
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
    }

    @Override
    protected IUnit copy() {
        return new Engineer(this.getName(),this.getTurnsQueue(),this.getHealthPoints(),this.getDefense());
    }
}

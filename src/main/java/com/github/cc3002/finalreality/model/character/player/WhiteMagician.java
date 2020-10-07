package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
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
    }

    @Override
    protected IUnit copy() {
        return new WhiteMagician(this.getName(),this.getTurnsQueue(),this.getHealthPoints(),this.getDefense());
    }
}

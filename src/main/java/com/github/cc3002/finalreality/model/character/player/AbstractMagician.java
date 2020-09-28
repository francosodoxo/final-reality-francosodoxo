package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * Class to group the Magicians
 * */
public class AbstractMagician extends AbstractCharacter{
    private int mana;

    /**
     * Constructor public visible
     *
     * @param name
     *      The Magician's name
     * @param unitClass
     *      The class the magician will have, black or white
     * @param turnsQueue
     *      The turn the magician will have to wait for
     * @param healthPoints
     *      The maximum health points this character will have
     * @param defense
     *      The defense points this character will have
     * */
    public AbstractMagician(@NotNull String name,
                            @NotNull UnitClass unitClass,
                            @NotNull BlockingQueue<ICharacter> turnsQueue,
                            int healthPoints,
                            int defense){
        super(name,
                unitClass,
                turnsQueue,
                healthPoints,
                defense);
        mana = 0;
    }

}

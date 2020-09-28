package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
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
                  @NotNull BlockingQueue<ICharacter> turnsQueue,
                  int healthPoints,
                  int defense){
        super(name,UnitClass.KNIGHT,turnsQueue,healthPoints,defense);
    }
}

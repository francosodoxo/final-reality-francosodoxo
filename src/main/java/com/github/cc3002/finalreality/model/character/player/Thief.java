package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
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
                 @NotNull BlockingQueue<ICharacter> turnsQueue,
                 int healthPoints,
                 int defense){
        super(name,UnitClass.THIEF,turnsQueue,healthPoints,defense);
    }
}

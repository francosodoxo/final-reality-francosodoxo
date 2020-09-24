package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class AbstractMagician extends AbstractCharacter{
    private int mana;
    public AbstractMagician(@NotNull String name,
                            @NotNull CharacterClass unitClass,
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

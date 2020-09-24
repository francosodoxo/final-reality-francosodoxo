package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class WhiteMage extends AbstractMagician {
    public WhiteMage(@NotNull String name,
                     @NotNull BlockingQueue<ICharacter> turnsQueue,
                     int healthPoints,
                     int defense){
        super(name,
                CharacterClass.WHITE_MAGE,
                turnsQueue,
                healthPoints,
                defense);
    }
}

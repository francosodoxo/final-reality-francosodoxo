package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Thief extends AbstractCharacter {
    public Thief(@NotNull String name,
                 @NotNull BlockingQueue<ICharacter> turnsQueue,
                 int healthPoints,
                 int defense){
        super(name,"Thief",turnsQueue,healthPoints,defense);
    }
}

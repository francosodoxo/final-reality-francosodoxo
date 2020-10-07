package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.BlackMagician;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlackMagicianTest extends AbstractCharacterTest {
    private BlackMagician blackMagician;
    private String NAME = "Ali";

    @BeforeEach
    public void setUp(){
        super.basicSetUp();
        blackMagician = new BlackMagician(NAME,
                super.getTurns(),
                super.getHealthPoints(),
                super.getDefense());
    }

    //check methods
    @Test
    public void testCopyNoWeapon(){
        assertEquals(blackMagician, blackMagician.copy());
    }

    @Test
    public void testCopyWithWeapon(){
        blackMagician.equip(super.getTestWeapon());
        assertEquals(blackMagician, blackMagician.copy());
    }
}

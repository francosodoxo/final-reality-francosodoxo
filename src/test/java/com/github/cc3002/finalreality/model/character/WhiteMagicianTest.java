package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.WhiteMagician;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhiteMagicianTest extends AbstractCharacterTest{
    private WhiteMagician whiteMagician;
    private String NAME = "w1";

    @BeforeEach
    public void setUp(){
        super.basicSetUp();
        whiteMagician = new WhiteMagician(NAME,
                super.getTurns(),
                super.getHealthPoints(),
                super.getDefense());
    }
    @Test
    public void testCopyNoWeapon(){
        assertEquals(whiteMagician,whiteMagician.copy());
    }

    @Test
    public void testCopyWithWeapon(){
        whiteMagician.equip(super.getTestWeapon());
        assertEquals(whiteMagician,whiteMagician.copy());
    }
}

package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Thief;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThiefTest extends AbstractCharacterTest{
    private Thief thief;
    private String NAME = "t1";

    @BeforeEach
    public void setUp(){
        super.basicSetUp();
        thief = new Thief( NAME,
                super.getTurns(),
                super.getHealthPoints(),
                super.getDefense());
    }

    @Test
    public void testCopyNoWeapon(){
        assertEquals(thief,thief.copy());
    }

    @Test
    public void testCopyWithWeapon(){
        thief.equip(super.getTestWeapon());
        assertEquals(thief,thief.copy());
    }

}

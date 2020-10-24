package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Thief;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
        testCharacters.add(thief);
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
    @Test
    public void testNameDiffNotEquals(){
        Thief thief1 = new Thief("thief1",turns,super.getHealthPoints(),super.getDefense());
        Thief thief2 = new Thief("thief2",turns,super.getHealthPoints(),super.getDefense());
        thief1.equip(super.getTestWeapon());
        thief2.equip(super.getTestWeapon());
        assertNotEquals(thief1,thief2);
    }

    @Test
    public void testHealthDiffNotEquals(){
        Thief thief1 = new Thief("thief1",turns,5,super.getDefense());
        Thief thief2 = new Thief("thief2",turns,6,super.getDefense());
        thief1.equip(super.getTestWeapon());
        thief2.equip(super.getTestWeapon());
        assertNotEquals(thief1,thief2);
    }

    @Test
    public void testDefenseNotEquals(){
        Thief thief1 = new Thief("thief1",turns,super.getHealthPoints(),2);
        Thief thief2 = new Thief("thief2",turns,super.getHealthPoints(),3);
        thief1.equip(super.getTestWeapon());
        thief2.equip(super.getTestWeapon());
        assertNotEquals(thief1,thief2);
    }

}

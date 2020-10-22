package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Engineer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EngineerTest extends AbstractCharacterTest {
    private Engineer engineer;
    private String NAME ="Kaku";

    @BeforeEach
    public void setUp(){
        super.basicSetUp();
        engineer = new Engineer(NAME,
                super.getTurns(),
                super.getHealthPoints(),
                super.getDefense());

        testCharacters.add(engineer);
    }

    @Test
    public void testCopyNoWeapon(){
        assertEquals(engineer,engineer.copy());
    }

    @Test
    public void testCopyWithWeapon(){
        engineer.equip(super.getTestWeapon());
        assertEquals(engineer,engineer.copy());
    }

    @Test
    public void testOnlyNameDiff(){
        Engineer engineer1 = new Engineer("engineer1",turns,super.getHealthPoints(),super.getDefense());
        engineer1.equip(super.getTestWeapon());
        Engineer engineer2 = new Engineer("engineer2",turns,super.getHealthPoints(),super.getDefense());
        engineer2.equip(super.getTestWeapon());
        assertNotEquals(engineer1,engineer2);
    }

}

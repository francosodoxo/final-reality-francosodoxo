package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.weapon.Knife;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class KnightTest extends AbstractCharacterTest {
    private Knight knight;
    private String NAME = "k1";

    @BeforeEach
    public void setUp(){
        super.basicSetUp();
        knight = new Knight(NAME,
                super.getTurns(),
                super.getHealthPoints(),
                super.getDefense());
        testCharacters.add(knight);
    }
    @Test
    public void testCopyNoWeapon(){
        assertEquals(knight, knight.copy());
    }

    @Test
    public void testCopyWithWeapon(){
        knight.equip(super.getTestWeapon());
        assertEquals(knight,knight.copy());
    }

    @Test
    public void testNameDiffNotEquals(){
        Knight knight1 = new Knight("knight1",turns,super.getHealthPoints(),super.getDefense());
        Knight knight2 = new Knight("knight2",turns,super.getHealthPoints(),super.getDefense());
        knight1.equip(super.getTestWeapon());
        knight2.equip(super.getTestWeapon());
        assertNotEquals(knight1,knight2);
    }
}

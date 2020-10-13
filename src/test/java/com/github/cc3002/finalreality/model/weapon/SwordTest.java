package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SwordTest extends AbstractWeaponTest {
    private Sword sword;
    @BeforeEach
    public void setUp(){
        super.basicSetUp();
        sword = new Sword(super.getName(), super.getDamage(),super.getWeight());
    }
    @Test
    public void testCopy(){
        assertEquals(sword,sword.copy());
    }

    @Test
    public void testSameObject(){
        assertEquals(sword,sword);
    }

    @Test
    public void SwordNotOtherSwordTest(){
        assertNotEquals(sword,super.getOtherSword());
    }

    @Test
    public void SwordNotAxeTest(){
        assertNotEquals(sword,super.getOtherAxe());
    }

    @Test
    public void SwordNotBowTest(){
        assertNotEquals(sword,super.getOtherBow());
    }

    @Test
    public void SwordNotKnifeTest(){
        assertNotEquals(sword,super.getOtherKnife());
    }

    @Test
    public void SwordNotNullTest(){
        assertNotEquals(sword,NullWeapon.getNullWeapon());
    }

    @Test
    public void SwordNotStaff(){
        assertNotEquals(sword,super.getOtherStaff());
    }

    @Test
    public void testSwordType(){
        assertEquals(sword.getType(),WeaponType.SWORD);
    }
}
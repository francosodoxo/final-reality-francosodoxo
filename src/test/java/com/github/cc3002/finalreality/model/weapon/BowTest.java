package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BowTest extends AbstractWeaponTest {
    private Bow bow;
    @BeforeEach
    public void setUp(){
        super.basicSetUp();
        bow = new Bow(super.getName(), super.getDamage(),super.getWeight());
    }
    @Test
    public void testCopy(){
        assertEquals(bow,bow.copy());
    }

    @Test
    public void testSameObject(){
        assertEquals(bow,bow);
    }

    @Test
    public void BowNotOtherBowTest(){
        assertNotEquals(bow,super.getOtherBow());
    }

    @Test
    public void BowNotAxeTest(){
        assertNotEquals(bow,super.getOtherAxe());
    }

    @Test
    public void BowNotKnifeTest(){
        assertNotEquals(bow,super.getOtherKnife());
    }

    @Test
    public void BowNotNullWeaponTest(){
        assertNotEquals(bow,NullWeapon.getNullWeapon());
    }
    @Test
    public void BowNotStaffTest(){
        assertNotEquals(bow,super.getOtherStaff());
    }
    @Test
    public void BowNotSwordTest(){
        assertNotEquals(bow,super.getOtherSword());
    }
    @Test
    public void testBowType(){
        assertEquals(bow.getType(),WeaponType.BOW);
    }
    @Test
    public void testBowName(){
        Bow bow1 = new Bow("bow1",10,8);
        Bow bow2 = new Bow("bow2",10,8);
        assertNotEquals(bow1,bow2);
    }

    @Test
    public void testBowDamage(){
        Bow bow1 = new Bow("bow1",10,8);
        Bow bow2 = new Bow("bow1",9,8);
        assertNotEquals(bow1,bow2);
    }

    @Test
    public void testBowWeight(){
        Bow bow1 = new Bow("bow1",10,8);
        Bow bow2 = new Bow("bow1",10,7);
        assertNotEquals(bow1,bow2);
    }

}
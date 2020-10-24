package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AxeTest extends AbstractWeaponTest {
    private Axe testAxe;

    @BeforeEach
    public void setUp(){
        super.basicSetUp();
        testAxe = new Axe(super.getName(), super.getDamage(),super.getWeight());
    }
    @Test
    public void testCopy(){
        assertEquals(testAxe, testAxe.copy());
    }

    @Test
    public void testSameObject(){
        assertEquals(testAxe,testAxe);
    }

    @Test
    public void AxeNotOtherAxeTest(){
        assertNotEquals(testAxe,super.getOtherAxe());
    }
    @Test
    public void AxeNotBow(){
        assertNotEquals(testAxe,super.getOtherBow());
    }
    @Test
    public void AxeNotKnife(){
        assertNotEquals(testAxe,super.getOtherKnife());
    }
    @Test
    public void AxeNotNullWeapon(){
        assertNotEquals(testAxe,NullWeapon.getNullWeapon());
    }
    @Test
    public void AxeNotStaff(){
        assertNotEquals(testAxe,super.getOtherStaff());
    }
    @Test
    public void AxeNotSword(){
        assertNotEquals(testAxe,super.getOtherSword());
    }

    @Test
    public void testAxeType(){
        assertEquals(testAxe.getType(),WeaponType.AXE);
    }

    @Test
    public void testAxeName(){
        Axe axe1 = new Axe("axe1",10,8);
        Axe axe2 = new Axe("axe2",10,8);
        assertNotEquals(axe1,axe2);
    }

    @Test
    public void testAxeDamage(){
        Axe axe1 = new Axe("axe1",10,8);
        Axe axe2 = new Axe("axe1",9,8);
        assertNotEquals(axe1,axe2);
    }

    @Test
    public void testAxeWeight(){
        Axe axe1 = new Axe("axe1",10,8);
        Axe axe2 = new Axe("axe1",10,7);
        assertNotEquals(axe1,axe2);
    }
}

package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class StaffTest extends AbstractWeaponTest {
    private Staff staff;
    @BeforeEach
    public void setUp(){
        super.basicSetUp();
        staff = new Staff(super.getName(), super.getDamage(),super.getWeight());
    }
    @Test
    public void testCopy(){
        assertEquals(staff,staff.copy());
    }

    @Test
    public void testSameObject(){
        assertEquals(staff,staff);
    }

    @Test
    public void StaffNotOtherStaff(){
        assertNotEquals(staff,super.getOtherStaff());
    }

    @Test
    public void StaffNotAxeTest(){
        assertNotEquals(staff,super.getOtherAxe());
    }

    @Test
    public void StaffNotBowTest(){
        assertNotEquals(staff,super.getOtherBow());
    }

    @Test
    public void StaffNotKnifeTest(){
        assertNotEquals(staff,super.getOtherKnife());
    }

    @Test
    public void StaffNotSwordTest(){
        assertNotEquals(staff,super.getOtherSword());
    }

    @Test
    public void testStaffTyep(){
        assertEquals(staff.getType(),WeaponType.STAFF);
    }

    @Test
    public void testStaffName(){
        Staff staff1 = new Staff("staff1",10,8);
        Staff staff2 = new Staff("staff2",10,8);
        assertNotEquals(staff1,staff2);
    }

    @Test
    public void testStaffDamage(){
        Staff staff1 = new Staff("staff1",10,8);
        Staff staff2 = new Staff("staff1",8,8);
        assertNotEquals(staff1,staff2);
    }

    @Test
    public void testStaffWeight(){
        Staff staff1 = new Staff("staff1",10,8);
        Staff staff2 = new Staff("staff1",10,5);
        assertNotEquals(staff1,staff2);
    }
}
package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
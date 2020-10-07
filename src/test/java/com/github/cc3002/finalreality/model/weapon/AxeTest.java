package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AxeTest extends AbstractWeaponTest {
    private Axe axe;
    @BeforeEach
    public void setUp(){
        super.basicSetUp();
        axe = new Axe(super.getName(), super.getDamage(),super.getWeight());
    }
    @Test
    public void testCopy(){
        assertEquals(axe,axe.copy());
    }
}

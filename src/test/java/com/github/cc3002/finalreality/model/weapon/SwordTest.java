package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
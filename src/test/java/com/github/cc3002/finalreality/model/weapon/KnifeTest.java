package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnifeTest extends AbstractWeaponTest {
    private Knife knife;
    @BeforeEach
    public void setUp(){
        super.basicSetUp();
        knife = new Knife(super.getName(), super.getDamage(),super.getWeight());
    }
    @Test
    public void testCopy(){
        assertEquals(knife,knife.copy());
    }
}
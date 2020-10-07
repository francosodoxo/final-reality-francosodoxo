package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
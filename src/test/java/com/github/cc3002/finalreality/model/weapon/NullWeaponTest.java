package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NullWeaponTest {
    @Test
    public void nullWeaponTest(){
        assertEquals(NullWeapon.getNullWeapon(), NullWeapon.getNullWeapon());
    }
    @Test
    public void nullWeaponCopyTest(){
        assertEquals(NullWeapon.getNullWeapon(),NullWeapon.getNullWeapon().copy());
    }
}

package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AbstractWeaponTest {
    private String name;
    private int damage;
    private int weight;
    private Axe otherAxe;
    private Bow otherBow;
    private Knife otherKnife;
    private Staff otherStaff;
    private Sword otherSword;

    public void basicSetUp(){
        name = "Weapon1";
        damage = 2;
        weight = 5;
        otherAxe = new Axe("otherAxe", 10,5);
        otherBow = new Bow("otherBow",10,5);
        otherKnife = new Knife("otherKnife", 10,5);
        otherStaff = new Staff("otherStaff",10,5);
        otherSword = new Sword("otherSword",10,5);
    }

    // Getters corner
    public String getName(){
        return name;
    }

    public int getDamage(){
        return damage;
    }

    public int getWeight(){
        return weight;
    }

    public Axe getOtherAxe(){
        return otherAxe;
    }
    public Bow getOtherBow(){
        return otherBow;
    }

    public Knife getOtherKnife(){
        return otherKnife;
    }
    public Staff getOtherStaff(){
        return otherStaff;
    }
    public Sword getOtherSword(){
        return otherSword;
    }

}

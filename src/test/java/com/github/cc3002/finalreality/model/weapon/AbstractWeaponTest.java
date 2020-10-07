package com.github.cc3002.finalreality.model.weapon;

public class AbstractWeaponTest {
    private String name;
    private int damage;
    private int weight;

    public void basicSetUp(){
        name = "Weapon1";
        damage = 2;
        weight = 5;
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
}

package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.weapon.*;

import java.util.ArrayList;

public class WeaponController {
  private ArrayList<Axe> axes;
  private ArrayList<Bow> bows;
  private ArrayList<Knife> knives;
  private ArrayList<Staff> staffes;
  private ArrayList<Sword> swords;

  public WeaponController(){
    axes = new ArrayList<Axe>();
    bows = new ArrayList<Bow>();
    knives = new ArrayList<Knife>();
    staffes = new ArrayList<Staff>();
    swords = new ArrayList<Sword>();
  }

  public Axe createAxe(String name, int attackWeapon, int weaponWeight) {
    Axe axe = new Axe(name,attackWeapon,weaponWeight);
    axes.add(axe);
    return axe;
  }

  public Bow createBow(String bowName, int attackWeapon, int weaponWeight) {
    Bow bow = new Bow(bowName,attackWeapon,weaponWeight);
    bows.add(bow);
    return bow;
  }

  public Knife createKnife(String knifeName, int attackWeapon, int weaponWeight) {
    Knife knife = new Knife(knifeName,attackWeapon,weaponWeight);
    knives.add(knife);
    return knife;
  }

  public Staff createStaff(String staffName, int attackWeapon, int weaponWeight) {
    Staff staff = new Staff(staffName,attackWeapon,weaponWeight);
    staffes.add(staff);
    return staff;
  }

  public Sword createSword(String swordName, int attackWeapon, int weaponWeight) {
    Sword sword = new Sword(swordName,attackWeapon,weaponWeight);
    swords.add(sword);
    return sword;
  }
}

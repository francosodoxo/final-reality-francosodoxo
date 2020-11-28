package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.weapon.*;

import java.util.ArrayList;

public class WeaponController {
  private ArrayList<Axe> axes;
  private ArrayList<Bow> bows;
  private ArrayList<Knife> knives;
  private ArrayList<Staff> staffes;
  private ArrayList<Sword> swords;

  /**
   * Class to manage the Weapons
   */
  public WeaponController(){
    axes = new ArrayList<Axe>();
    bows = new ArrayList<Bow>();
    knives = new ArrayList<Knife>();
    staffes = new ArrayList<Staff>();
    swords = new ArrayList<Sword>();
  }

  /**
   * Creates an axe and adds it an inventory that belongs to the game
   * @param name
   * @param attackWeapon
   * @param weaponWeight
   * @return
   */
  public Axe createAxe(String name, int attackWeapon, int weaponWeight) {
    Axe axe = new Axe(name,attackWeapon,weaponWeight);
    axes.add(axe);
    return axe;
  }

  /**
   * Creates a bow and adds it to an inventory belongs to the game
   * @param bowName
   * @param attackWeapon
   * @param weaponWeight
   * @return
   */
  public Bow createBow(String bowName, int attackWeapon, int weaponWeight) {
    Bow bow = new Bow(bowName,attackWeapon,weaponWeight);
    bows.add(bow);
    return bow;
  }

  /**
   * Creates a knife and adds it to an inventory that belongs to the game
   * @param knifeName
   * @param attackWeapon
   * @param weaponWeight
   * @return
   */
  public Knife createKnife(String knifeName, int attackWeapon, int weaponWeight) {
    Knife knife = new Knife(knifeName,attackWeapon,weaponWeight);
    knives.add(knife);
    return knife;
  }

  /**
   * Creates a staff and adds it to an inventory that belongs to the game
   * @param staffName
   * @param attackWeapon
   * @param weaponWeight
   * @return
   */
  public Staff createStaff(String staffName, int attackWeapon, int weaponWeight) {
    Staff staff = new Staff(staffName,attackWeapon,weaponWeight);
    staffes.add(staff);
    return staff;
  }

  /**
   * Creates a sword and adds it to an inventory that belongs to the game
   * @param swordName
   * @param attackWeapon
   * @param weaponWeight
   * @return
   */
  public Sword createSword(String swordName, int attackWeapon, int weaponWeight) {
    Sword sword = new Sword(swordName,attackWeapon,weaponWeight);
    swords.add(sword);
    return sword;
  }
}

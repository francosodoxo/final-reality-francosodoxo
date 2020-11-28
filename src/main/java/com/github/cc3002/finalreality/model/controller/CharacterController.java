package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

public class CharacterController {
  HashMap<String, ICharacter> characters;

  //Constructor
  public CharacterController(){
    characters = new HashMap<String,ICharacter>();
  }

  /**
   * Creates a Black Magician
   * @param name
   * @param turns
   * @param healthPoints
   * @param defense
   * @return
   */
  public BlackMagician createBlack(String name, BlockingQueue<IUnit> turns, int healthPoints, int defense) {
    BlackMagician blackMagician = new BlackMagician(name,turns,healthPoints,defense);
    characters.put(name,blackMagician);
    return blackMagician;
  }

  /**
   * Creates a Engineer
   * @param name
   * @param turns
   * @param healthPoints
   * @param defense
   * @return
   */
  public Engineer createEngineer(String name, BlockingQueue<IUnit> turns, int healthPoints, int defense) {
    Engineer engineer = new Engineer(name,turns,healthPoints,defense);
    characters.put(name,engineer);
    return engineer;
  }

  /**
   * Creates a Knight
   * @param name
   * @param turns
   * @param healthPoints
   * @param defense
   * @return
   */
  public Knight createKnight(String name, BlockingQueue<IUnit> turns, int healthPoints, int defense) {
    Knight knight = new Knight(name,turns,healthPoints,defense);
    characters.put(name,knight);
    return knight;
  }

  /**
   * Creates a Thief
   * @param name
   * @param turns
   * @param healthPoints
   * @param defense
   * @return
   */
  public Thief createThief(String name, BlockingQueue<IUnit> turns, int healthPoints, int defense) {
    Thief thief = new Thief(name,turns,healthPoints,defense);
    characters.put(name,thief);
    return thief;
  }

  /**
   * Creates a White Magician
   * @param name
   * @param turns
   * @param healthPoints
   * @param defense
   * @return
   */
  public WhiteMagician createWhite(String name, BlockingQueue<IUnit> turns, int healthPoints, int defense) {
    WhiteMagician whiteMagician = new WhiteMagician(name,turns,healthPoints,defense);
    characters.put(name,whiteMagician);
    return whiteMagician;
  }

  /**
   * Get the unit name through controller
   * @param unit
   * @return
   */
  public String getName(IUnit unit) {
    return unit.getName();
  }

  /**
   * Obtains the health points according to the character's name
   * @param name
   * @return
   */
  public int getHealthPoints(String name) {
    return ((IUnit) characters.get(name)).getHealthPoints();
  }

  /**
   * Obtains the defense of a character through its name
   * @param name
   * @return
   */
  public int getDefense(String name) {
    return characters.get(name).getDefense();
  }

  /**
   * Returns the Black Magician's weapon identified by their name.
   * @param name
   * @return
   */
  public IWeaponBlack getBlackWeapon(String name) {
    return ((IBlackAllowedWeapons) characters.get(name)).getEquippedWeapon();
  }

  /**
   * Returns the Engineer's weapon identified by their name
   * @param name
   * @return
   */
  public IWeaponEngineer getEngineerWeapon(String name) {
    return ((IEngineerAllowedWeapons) characters.get(name)).getEquippedWeapon();
  }

  /**
   * Returns the Thief's weapon identifies by their name
   * @param name
   * @return
   */
  public IWeaponThief getThiefWeapon(String name) {
    return ((IThiefAllowedWeapons) characters.get(name)).getEquippedWeapon();
  }

  /**
   * Returns the White Magician's weapon identified by their name
   * @param name
   * @return
   */
  public IWeaponWhite getWhiteWeapon(String name) {
    return ((IWhiteAllowedWeapons) characters.get(name)).getEquippedWeapon();
  }
}

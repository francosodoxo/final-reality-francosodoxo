package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.listeners.CharacterDeadHandler;
import com.github.cc3002.finalreality.model.weapon.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;

public class PlayerController {
  private HashMap<String, ICharacter> playerCharacters;
  private HashMap<String, IWeapon> weapons;
  private PropertyChangeSupport noPlayersOnGame = new PropertyChangeSupport(this);
  private CharacterDeadHandler characterDeadHandler = new CharacterDeadHandler(this);
  private int charactersAlive;

  /**
   * Class to manage the player's actions
   */
  public PlayerController(){
    playerCharacters = new HashMap<String,ICharacter>();
    weapons = new HashMap<String,IWeapon>();
    charactersAlive = 0;
  }

  /**
   * Add a listener to the property when all the characters are dead
   * @param listener
   */
  public void addNoPlayersOnGameListener(PropertyChangeListener listener){
    noPlayersOnGame.addPropertyChangeListener(listener);
  }

  /**
   * It is invoked when a character is dead
   */
  public void characterDead(){
    int oldCharactersAlive = charactersAlive;
    charactersAlive--;
    if(charactersAlive == 0){
      noPlayersOnGame.firePropertyChange("noCharactersOnGame",oldCharactersAlive,charactersAlive);
    }
  }

  /**
   * Add a created character to the player's ownership
   * @param character
   */
  public void add(ICharacter character) {
    playerCharacters.put(character.getName(),character);
    ((IUnit) character).addUnitDeadListener(characterDeadHandler);
    charactersAlive++;
  }

  /**
   * Check if a character, identified by their name, is in the player's ownership
   * @param name
   * @return
   */
  public boolean contains(String name) {
    return playerCharacters.containsKey(name);
  }

  /**
   * Get a character's name
   * @param character
   * @return
   */
  public String getName(ICharacter character) {
    return character.getName();
  }

  /**
   * Get a character's health points, identified by their name
   * @param name
   * @return
   */
  public int getHealthPoints(String name) {
    return ((IUnit) playerCharacters.get(name)).getHealthPoints();
  }

  /**
   * Get a character's defense identified by their name
   * @param name
   * @return
   */
  public int getDefense(String name) {
    return playerCharacters.get(name).getDefense();
  }

  /**
   * Equip a weapon to a black magician identified by their name
   * @param name
   * @param weapon
   */
  public void equipBlack(String name, IWeaponBlack weapon) {
    ((IBlackAllowedWeapons) playerCharacters.get(name)).equip(weapon);
  }

  /**
   * Get a black magician's weapon identified by their name
   * @param name
   * @return
   */
  public IWeaponBlack getBlackWeapon(String name) {
    return ((IBlackAllowedWeapons) playerCharacters.get(name)).getEquippedWeapon();
  }

  /**
   * Equip a weapon to an engineer identified by their name
   * @param engineerName
   * @param weapon
   */
  public void equipEngineer(String engineerName, IWeaponEngineer weapon) {
    ((IEngineerAllowedWeapons) playerCharacters.get(engineerName)).equip(weapon);
  }

  /**
   * Get a engineer's weapon identified by their name
   * @param engineerName
   * @return
   */
  public IWeaponEngineer getEngineerWeapon(String engineerName) {
    return ((IEngineerAllowedWeapons) playerCharacters.get(engineerName)).getEquippedWeapon();
  }

  /**
   * Equip a weapon to a knight identified by their name
   * @param knightName
   * @param weapon
   */
  public void equipKnight(String knightName, IWeaponKnight weapon) {
    ((IKnightAllowedWeapons) playerCharacters.get(knightName)).equip(weapon);
  }

  /**
   * Get a knight's weapon identified by their name
   * @param knightName
   * @return
   */
  public IWeaponKnight getKnightWeapon(String knightName) {
    return ((IKnightAllowedWeapons) playerCharacters.get(knightName)).getEquippedWeapon();
  }

  /**
   * Equip a weapon to a thief identified by their name
   * @param thiefName
   * @param weapon
   */
  public void equipThief(String thiefName, IWeaponThief weapon) {
    ((IThiefAllowedWeapons) playerCharacters.get(thiefName)).equip(weapon);
  }

  /**
   * Get a thief's weapon identified by their name
   * @param thiefName
   * @return
   */
  public IWeaponThief getThiefWeapon(String thiefName) {
    return ((IThiefAllowedWeapons) playerCharacters.get(thiefName)).getEquippedWeapon();
  }

  /**
   * Equip a weapon to a white magician identified by their name
   * @param whiteMagicianName
   * @param weapon
   */
  public void equipWhite(String whiteMagicianName, IWeaponWhite weapon) {
    ((IWhiteAllowedWeapons) playerCharacters.get(whiteMagicianName)).equip(weapon);
  }

  /**
   * Get a white magician's weapon identified by their name
   * @param whiteMagicianName
   * @return
   */
  public IWeaponWhite getWhiteWeapon(String whiteMagicianName) {
    return  ((IWhiteAllowedWeapons) playerCharacters.get(whiteMagicianName)).getEquippedWeapon();
  }

  /**
   * Add a weapon to the player's inventory
   * @param weapon
   */
  public void addToInventory(IWeapon weapon) {
    weapons.put(weapon.getName(),weapon);
  }

  /**
   * Get a weapon from the inventory
   * @param name
   * @return
   */
  public IWeapon getFromInventory(String name) {
    return weapons.get(name);
  }

  /**
   * Get the number of characters that the player has, no matter if they are alive or dead.
   * To get the number of alive characters, use getCharactersAlive() method written bellow
   * @return
   */
  public int getNumberOfCharacters() {
    return playerCharacters.size();
  }

  /**
   * Get the number of alive characters the player has.
   * @return
   */
  public int getCharactersAlive() {
    return charactersAlive;
  }
}

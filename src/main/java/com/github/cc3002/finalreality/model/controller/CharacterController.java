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

  public CharacterController(){
    characters = new HashMap<String,ICharacter>();

  }
  public BlackMagician createBlack(String name, BlockingQueue<IUnit> turns, int healthPoints, int defense) {
    BlackMagician blackMagician = new BlackMagician(name,turns,healthPoints,defense);
    characters.put(name,blackMagician);
    return blackMagician;
  }

  public Engineer createEngineer(String name, BlockingQueue<IUnit> turns, int healthPoints, int defense) {
    Engineer engineer = new Engineer(name,turns,healthPoints,defense);
    characters.put(name,engineer);
    return engineer;
  }

  public Knight createKnight(String name, BlockingQueue<IUnit> turns, int healthPoints, int defense) {
    Knight knight = new Knight(name,turns,healthPoints,defense);
    characters.put(name,knight);
    return knight;
  }

  public Thief createThief(String name, BlockingQueue<IUnit> turns, int healthPoints, int defense) {
    Thief thief = new Thief(name,turns,healthPoints,defense);
    characters.put(name,thief);
    return thief;
  }

  public WhiteMagician createWhite(String name, BlockingQueue<IUnit> turns, int healthPoints, int defense) {
    WhiteMagician whiteMagician = new WhiteMagician(name,turns,healthPoints,defense);
    characters.put(name,whiteMagician);
    return whiteMagician;
  }

  public String getName(IUnit unit) {
    return unit.getName();
  }

  public int getHealthPoints(String name) {
    return ((IUnit) characters.get(name)).getHealthPoints();
  }

  public int getDefense(String name) {
    return characters.get(name).getDefense();
  }

  public IWeaponBlack getBlackWeapon(String name) {
    return ((IBlackAllowedWeapons) characters.get(name)).getEquippedWeapon();
  }

  public IWeaponEngineer getEngineerWeapon(String name) {
    return ((IEngineerAllowedWeapons) characters.get(name)).getEquippedWeapon();
  }

  public IWeaponThief getThiefWeapon(String name) {
    return ((IThiefAllowedWeapons) characters.get(name)).getEquippedWeapon();
  }

  public IWeaponWhite getWhiteWeapon(String name) {
    return ((IWhiteAllowedWeapons) characters.get(name)).getEquippedWeapon();
  }
}

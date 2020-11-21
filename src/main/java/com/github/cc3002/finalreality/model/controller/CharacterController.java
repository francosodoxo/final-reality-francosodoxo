package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.character.player.*;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class CharacterController {
  ArrayList<BlackMagician> blackMagicians;
  ArrayList<Engineer> engineers;
  ArrayList<Knight> knights;
  ArrayList<Thief> thieves;
  ArrayList<WhiteMagician> whiteMagicians;
  public CharacterController(){
    blackMagicians = new ArrayList<BlackMagician>();
    engineers = new ArrayList<Engineer>();
    knights = new ArrayList<Knight>();
    thieves = new ArrayList<Thief>();
    whiteMagicians = new ArrayList<WhiteMagician>();
  }
  public BlackMagician createBlack(String name, BlockingQueue<IUnit> turns, int healthPoints, int defense) {
    BlackMagician blackMagician = new BlackMagician(name,turns,healthPoints,defense);
    blackMagicians.add(blackMagician);
    return blackMagician;
  }

  public Engineer createEngineer(String name, BlockingQueue<IUnit> turns, int healthPoints, int defense) {
    Engineer engineer = new Engineer(name,turns,healthPoints,defense);
    engineers.add(engineer);
    return engineer;
  }

  public Knight createKnight(String name, BlockingQueue<IUnit> turns, int healthPoints, int defense) {
    Knight knight = new Knight(name,turns,healthPoints,defense);
    knights.add(knight);
    return knight;
  }

  public Thief createThief(String name, BlockingQueue<IUnit> turns, int healthPoints, int defense) {
    Thief thief = new Thief(name,turns,healthPoints,defense);
    thieves.add(thief);
    return thief;
  }

  public WhiteMagician createWhite(String name, BlockingQueue<IUnit> turns, int healthPoints, int defense) {
    WhiteMagician whiteMagician = new WhiteMagician(name,turns,healthPoints,defense);
    whiteMagicians.add(whiteMagician);
    return whiteMagician;
  }
}

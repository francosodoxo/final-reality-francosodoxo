package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.character.player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterControllerTest {
  private BlackMagician blackMagician;
  private Engineer engineer;
  private Knight knight;
  private Thief thief;
  private WhiteMagician whiteMagician;

  private String BLACK_NAME;
  private String ENGINEER_NAME;
  private String KNIGHT_NAME;
  private String THIEF_NAME;
  private String WHITE_NAME;

  private BlockingQueue<IUnit> turns;



  private int HEALTH_POINTS;
  private int DEFENSE;

  private int ATTACK_ENEMY;

  private CharacterController characterController;

  @BeforeEach
  public void setUp(){
    turns = new LinkedBlockingQueue<>();
    HEALTH_POINTS = 10;
    DEFENSE = 5;

    ATTACK_ENEMY = 6;

    BLACK_NAME = "black1";
    ENGINEER_NAME = "engineer1";
    KNIGHT_NAME = "knight1";
    THIEF_NAME = "thief1";
    WHITE_NAME = "white1";
    blackMagician = new BlackMagician(BLACK_NAME,turns,HEALTH_POINTS,DEFENSE);
    engineer = new Engineer(ENGINEER_NAME,turns,HEALTH_POINTS,DEFENSE);
    knight = new Knight(KNIGHT_NAME,turns,HEALTH_POINTS,DEFENSE);
    thief = new Thief(THIEF_NAME, turns, HEALTH_POINTS,DEFENSE);
    whiteMagician = new WhiteMagician(WHITE_NAME, turns,HEALTH_POINTS,DEFENSE);

    characterController = new CharacterController();
  }

  @Test
  public void testCreateBlack(){
    BlackMagician newBlack = characterController.createBlack(BLACK_NAME,turns,HEALTH_POINTS,DEFENSE);
    assertEquals(blackMagician,newBlack);
  }

  @Test
  public void testCreateEngineer(){
    Engineer newEngineer = characterController.createEngineer(ENGINEER_NAME,turns,HEALTH_POINTS,DEFENSE);
    assertEquals(engineer,newEngineer);
  }

  @Test
  public void testCreateKnight(){
    Knight newKnight = characterController.createKnight(KNIGHT_NAME,turns,HEALTH_POINTS,DEFENSE);
    assertEquals(knight,newKnight);
  }

  @Test
  public void testCreateThief(){
    Thief newThief = characterController.createThief(THIEF_NAME,turns,HEALTH_POINTS,DEFENSE);
    assertEquals(thief,newThief);
  }

  @Test
  public void testCreateWhite(){
    WhiteMagician newWhite = characterController.createWhite(WHITE_NAME,turns,HEALTH_POINTS,DEFENSE);
    assertEquals(whiteMagician,newWhite);
  }

}

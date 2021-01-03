package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.AbstractSetUpTest;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.character.player.BlackMagician;
import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.character.player.WhiteMagician;
import com.github.cc3002.finalreality.model.states.FightState;
import com.github.cc3002.finalreality.model.states.PlayerLosesState;
import com.github.cc3002.finalreality.model.states.PlayerWinsState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FlowControllerTest extends AbstractSetUpTest {
  private FlowController flowController;
  private PlayerController playerController;
  private EnemyController enemyController;
  private TurnController turnController;
  private BlackMagician blackMagician;
  private WhiteMagician whiteMagician;
  private Thief thief;
  private Enemy enemy1;
  private Enemy enemy2;

  @BeforeEach
  public void setUp(){
    super.setUp();
    flowController = super.getFlowController();
    playerController = super.getPlayerController();
    enemyController = super.getEnemyController();
    turnController = super.getTurnController();

    blackMagician = super.getBlackMagician();
    whiteMagician = super.getWhiteMagician();
    thief = super.getThief();
    enemy1 = enemyController.createEnemy("enemy1",7,super.getTurnsQueue(),10,7,4);
    enemy2 = enemyController.createEnemy("enemy2",8,super.getTurnsQueue(),7,9,5);

    playerController.add(blackMagician);
    playerController.add(whiteMagician);
    playerController.add(thief);
    turnController.add(blackMagician);
    turnController.add(whiteMagician);
    turnController.add(thief);
  }

  @Test
  public void playerWins(){
    int totalEnemies = enemyController.getNumberOfEnemies();
    assertEquals(totalEnemies,enemyController.getEnemiesAlive());
    enemy1.setHealthPoints(0);
    assertEquals(totalEnemies-1,enemyController.getEnemiesAlive());
    enemy2.setHealthPoints(0);
    assertEquals(totalEnemies-2,enemyController.getEnemiesAlive());
    assertEquals(new PlayerWinsState(), flowController.getCurrentState());
  }

  @Test
  public void playerLoses(){
    int totalCharacters = playerController.getNumberOfCharacters();
    assertEquals(totalCharacters,playerController.getCharactersAlive());
    blackMagician.setHealthPoints(0);
    assertEquals(totalCharacters-1,playerController.getCharactersAlive());
    whiteMagician.setHealthPoints(0);
    assertEquals(totalCharacters-2,playerController.getCharactersAlive());
    thief.setHealthPoints(0);
    assertEquals(totalCharacters-3,playerController.getCharactersAlive());
    assertEquals(new PlayerLosesState(), flowController.getCurrentState());
  }

  @Test
  public void goToPlayerWinsWhenAlreadyWon() throws Exception {
    flowController.goToPlayerWins();
    flowController.goToPlayerWins();
    assertNull(flowController.getCurrentState());
  }

  @Test
  public void goToPlayerLoseWhenAlreadyLoses() throws Exception {
    flowController.goToPlayerLoses();
    flowController.goToPlayerLoses();
    assertNull(flowController.getCurrentState());
  }

  @Test
  public void goToPlayerWinsWhenPlayerLoses() throws Exception {
    flowController.goToPlayerLoses();
    flowController.goToPlayerWins();
    assertNull(flowController.getCurrentState());
  }

  @Test
  public void goToPlayerLosesWhenPlayerWins() throws Exception {
    flowController.goToPlayerWins();
    flowController.goToPlayerLoses();
    assertNull(flowController.getCurrentState());
  }
}

package com.github.cc3002.finalreality.model.fight;

import com.github.cc3002.finalreality.model.AbstractSetUpTest;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnemyAttackTest extends AbstractSetUpTest {
  @BeforeEach
  public void setUp(){
    super.setUp();
    super.setDamage(7);
    super.setDefensePoints(5);
    super.setHealthPoints(15);
    super.setWeight(4);
  }

  @Test
  public void enemyAtkAgainstLiveBlackMagician(){
    BlackMagician black = (BlackMagician) super.getBlackMagician().copy();
    Enemy enemy1 = getEnemy();
    int blackHealthPoints = black.getHealthPoints();
    getEnemy().attackTo(black);
    int damage = enemy1.getAtk() - black.getDefense();
    int expectedHealthPoints = blackHealthPoints-damage;
    assertEquals(expectedHealthPoints,black.getHealthPoints());
  }

  @Test
  public void enemyAtkAgainstDeadBlackMagician(){
    BlackMagician black = (BlackMagician) super.getBlackMagician().copy();
    Enemy enemy1 = getEnemy();
    black.setHealthPoints(0);
    enemy1.attackTo(black);
    assertEquals(0,black.getHealthPoints());
  }

  @Test
  public void enemyAtkAgainstLiveEngineer(){
    Engineer character = (Engineer) super.getEngineer().copy();
    Enemy enemy1 = getEnemy();
    int blackHealthPoints = character.getHealthPoints();
    getEnemy().attackTo(character);
    int damage = enemy1.getAtk() - character.getDefense();
    int expectedHealthPoints = blackHealthPoints-damage;
    assertEquals(expectedHealthPoints,character.getHealthPoints());
  }

  @Test
  public void enemyAtkAgainstDeadEngineer(){
    Engineer character = (Engineer) super.getEngineer().copy();
    Enemy enemy1 = getEnemy();
    character.setHealthPoints(0);
    enemy1.attackTo(character);
    assertEquals(0,character.getHealthPoints());
  }

  @Test
  public void enemyAtkAgainstLiveKnight(){
    Knight character = (Knight) super.getKnight().copy();
    Enemy enemy1 = getEnemy();
    int blackHealthPoints = character.getHealthPoints();
    getEnemy().attackTo(character);
    int damage = enemy1.getAtk() - character.getDefense();
    int expectedHealthPoints = blackHealthPoints-damage;
    assertEquals(expectedHealthPoints,character.getHealthPoints());
  }

  @Test
  public void enemyAtkAgainstDeadKnight(){
    Knight character = (Knight) super.getKnight().copy();
    Enemy enemy1 = getEnemy();
    character.setHealthPoints(0);
    enemy1.attackTo(character);
    assertEquals(0,character.getHealthPoints());
  }

  @Test
  public void enemyAtkAgainstLiveThief(){
    Thief character = (Thief) super.getThief().copy();
    Enemy enemy1 = getEnemy();
    int blackHealthPoints = character.getHealthPoints();
    getEnemy().attackTo(character);
    int damage = enemy1.getAtk() - character.getDefense();
    int expectedHealthPoints = blackHealthPoints-damage;
    assertEquals(expectedHealthPoints,character.getHealthPoints());
  }

  @Test
  public void enemyAtkAgainstDeadThief(){
    Thief character = (Thief) super.getThief().copy();
    Enemy enemy1 = getEnemy();
    character.setHealthPoints(0);
    enemy1.attackTo(character);
    assertEquals(0,character.getHealthPoints());
  }

  @Test
  public void enemyAtkAgainstLiveWhiteMag(){
    WhiteMagician character = (WhiteMagician) super.getWhiteMagician().copy();
    Enemy enemy1 = getEnemy();
    int blackHealthPoints = character.getHealthPoints();
    getEnemy().attackTo(character);
    int damage = enemy1.getAtk() - character.getDefense();
    int expectedHealthPoints = blackHealthPoints-damage;
    assertEquals(expectedHealthPoints,character.getHealthPoints());
  }

  @Test
  public void enemyAtkAgainstDeadWhiteMag(){
    WhiteMagician character = (WhiteMagician) super.getWhiteMagician().copy();
    Enemy enemy1 = getEnemy();
    character.setHealthPoints(0);
    enemy1.attackTo(character);
    assertEquals(0,character.getHealthPoints());
  }

  @Test
  public void enemyAttackItself(){
    Enemy enemy1 = (Enemy) getEnemy().copy();
    int enemyHp = enemy1.getHealthPoints();
    enemy1.attackTo(enemy1);
    assertEquals(enemyHp,enemy1.getHealthPoints());
  }
}

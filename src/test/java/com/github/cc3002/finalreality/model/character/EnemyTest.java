package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Thief;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class EnemyTest extends AbstractCharacterTest {

  private static final String ENEMY_NAME = "Goblin";
  private static final int ENEMY_HEALTH_POINTS = 10;
  private static final int ENEMY_ATK = 5;
  private static final int ENEMY_DEFENSE = 4;
  private static final int CHARACTER_HEALTH_POINTS = 10;
  private static final int CHARACTER_DEF = 5;
  private static Enemy fixEnemy;

  @BeforeEach
  void setUp() {
    basicSetUp();
    fixEnemy = new Enemy(ENEMY_NAME, 10, turns, ENEMY_HEALTH_POINTS,ENEMY_ATK, ENEMY_DEFENSE);
    testCharacters.add(fixEnemy);
  }

  @Test
  void constructorTest() {
    checkConstruction(new Enemy(ENEMY_NAME, 10, turns, ENEMY_HEALTH_POINTS,ENEMY_ATK, ENEMY_DEFENSE),
        testCharacters.get(0),
        new Enemy(ENEMY_NAME, 11, turns,ENEMY_HEALTH_POINTS,ENEMY_ATK,ENEMY_DEFENSE),
        new Thief(ENEMY_NAME,turns,ENEMY_HEALTH_POINTS,10));
  }
  @Test
  public void changeAtkTest(){
    Enemy copyOf = (Enemy) fixEnemy.copy();
    copyOf.setAtk(2);
    assertNotEquals(fixEnemy,copyOf);
  }
}
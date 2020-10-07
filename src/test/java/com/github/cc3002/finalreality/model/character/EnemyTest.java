package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.character.player.UnitClass;
import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnemyTest extends AbstractCharacterTest {

  private static final String ENEMY_NAME = "Goblin";
  private static int ENEMY_HEALTH_POINTS = 10;
  private static int ENEMY_ATK = 5;
  private static int CHARACTER_HEALTH_POINTS = 10;
  private static int CHARACTER_DEF = 5;

  @BeforeEach
  void setUp() {
    basicSetUp();
    testCharacters.add(new Enemy(ENEMY_NAME, 10, turns, ENEMY_HEALTH_POINTS,ENEMY_ATK));
  }

  @Test
  void constructorTest() {
    checkConstruction(new Enemy(ENEMY_NAME, 10, turns, ENEMY_HEALTH_POINTS,ENEMY_ATK),
        testCharacters.get(0),
        new Enemy(ENEMY_NAME, 11, turns,ENEMY_HEALTH_POINTS,ENEMY_ATK),
        new Thief(ENEMY_NAME,turns,ENEMY_HEALTH_POINTS,10));
  }
}
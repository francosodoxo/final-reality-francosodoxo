package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.github.cc3002.finalreality.model.character.player.UnitClass;
import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;
import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Set of tests for the {@code GameCharacter} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author Franco Seguel
 * @see PlayerCharacter
 */
class PlayerCharacterTest extends AbstractCharacterTest {

  private static final String BLACK_MAGICIAN_NAME = "Vivi";
  private static final String KNIGHT_NAME = "Adelbert";
  private static final String WHITE_MAGICIAN_NAME = "Eiko";
  private static final String ENGINEER_NAME = "Cid";
  private static final String THIEF_NAME = "Zidane";
  private static final int CHARACTER_HEALTH_POINTS = 10;
  private static final int CHARACTER_DEF = 5;
  private Map<UnitClass, String> characterNames;

  /**
   * Setup method.
   * Creates a new character named Vivi with 10 speed and links it to a turn queue.
   */
  @BeforeEach
  void setUp() {
    super.basicSetUp();

    characterNames = new EnumMap<>(UnitClass.class);
    characterNames.put(UnitClass.BLACK_MAGICIAN, BLACK_MAGICIAN_NAME);
    characterNames.put(UnitClass.KNIGHT, KNIGHT_NAME);
    characterNames.put(UnitClass.WHITE_MAGICIAN, WHITE_MAGICIAN_NAME);
    characterNames.put(UnitClass.ENGINEER, ENGINEER_NAME);
    characterNames.put(UnitClass.THIEF, THIEF_NAME);

    for (var characterClass :
        characterNames.keySet()) {
      testCharacters.add(
          new PlayerCharacter(characterNames.get(characterClass), turns, characterClass, CHARACTER_HEALTH_POINTS,CHARACTER_DEF));
    }
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    var enemy = new Enemy("Enemy", 10, turns, 10,5);
    for (var character :
        testCharacters) {
      var characterClass = character.getUnitClass();
      var characterName = characterNames.get(characterClass);
      checkConstruction(new PlayerCharacter(characterName, turns, characterClass, CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
          character,
          new PlayerCharacter("Test", turns, characterClass,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
          new PlayerCharacter(characterName, turns,
              characterClass == UnitClass.THIEF ? UnitClass.BLACK_MAGICIAN
                  : UnitClass.THIEF, CHARACTER_HEALTH_POINTS,CHARACTER_DEF));
      assertNotEquals(character, enemy);
    }

  }

  @Test
  void equipWeaponTest() {
    for (var character :
        testCharacters) {
      assertNull(character.getEquippedWeapon());
      character.equip(testWeapon);
      assertEquals(testWeapon, character.getEquippedWeapon());
    }
  }
}

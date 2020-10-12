package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.github.cc3002.finalreality.model.character.player.*;

import java.util.EnumMap;
import java.util.Map;

import com.github.cc3002.finalreality.model.weapon.NullWeapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Set of tests for the {@code GameCharacter} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author Franco Seguel
 * @see AbstractCharacter
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
      switch (characterClass){
        case BLACK_MAGICIAN:
          testCharacters.add(new BlackMagician(characterNames.get(characterClass),turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF));
          break;
        case ENGINEER:
          testCharacters.add(new Engineer(characterNames.get(characterClass), turns, CHARACTER_HEALTH_POINTS, CHARACTER_DEF));
          break;
        case KNIGHT:
          testCharacters.add(new Knight(characterNames.get(characterClass), turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF));
          break;
        case THIEF:
          testCharacters.add(new Thief(characterNames.get(characterClass), turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF));
          break;
        case WHITE_MAGICIAN:
          testCharacters.add(new WhiteMagician(characterNames.get(characterClass),turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF));
          break;
      }
    }
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    var enemy = new Enemy("Enemy", 10, turns, 10,5,4);
    for (var character :
        testCharacters) {
      var characterClass = character.getUnitClass();
      var characterName = characterNames.get(characterClass);
      switch(characterClass){
        case BLACK_MAGICIAN:
          checkConstruction(new BlackMagician(characterName,turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  character,
                  new BlackMagician("black1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  new Engineer(characterName,turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF)
                  );
          checkConstruction(new BlackMagician(characterName,turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  character,
                  new BlackMagician("black1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  new Knight("knight1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF));
          checkConstruction(new BlackMagician(characterName,turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  character,
                  new BlackMagician("black1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  new Thief("thief1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF));
          checkConstruction(new BlackMagician(characterName,turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  character,
                  new BlackMagician("black1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  new WhiteMagician("white1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF));
          break;
        case ENGINEER:
          checkConstruction(new Engineer(characterName,turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  character,
                  new Engineer("engineer1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  new BlackMagician("black1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF));
          checkConstruction(new Engineer(characterName,turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  character,
                  new Engineer("engineer1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  new Knight("knight1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF));
          checkConstruction(new Engineer(characterName,turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  character,
                  new Engineer("engineer1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  new Thief("thief1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF));
          checkConstruction(new Engineer(characterName,turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  character,
                  new Engineer("engineer1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  new WhiteMagician("white1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF));
          break;
        case KNIGHT:
          checkConstruction(new Knight(characterName,turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  character,
                  new Knight("knight1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  new BlackMagician("black1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF));
          checkConstruction(new Knight(characterName,turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  character,
                  new Knight("knight1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  new Engineer("engineer1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF));
          checkConstruction(new Knight(characterName,turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  character,
                  new Knight("knight1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  new Thief("thief1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF));
          checkConstruction(new Knight(characterName,turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  character,
                  new Knight("knight1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  new WhiteMagician("white1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF));
          break;
        case THIEF:
          checkConstruction(new Thief(characterName,turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  character,
                  new Thief("thief1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  new BlackMagician("black1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF));
          checkConstruction(new Thief(characterName,turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  character,
                  new Thief("thief1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  new Engineer("engineer1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF));
          checkConstruction(new Thief(characterName,turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  character,
                  new Thief("thief1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  new Knight("knight1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF));
          checkConstruction(new Thief(characterName,turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  character,
                  new Thief("thief1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  new WhiteMagician("white1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF));
          break;
        case WHITE_MAGICIAN:
          checkConstruction(new WhiteMagician(characterName,turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  character,
                  new WhiteMagician("white1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  new BlackMagician("black1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF));
          checkConstruction(new WhiteMagician(characterName,turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  character,
                  new WhiteMagician("white1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  new Engineer("engineer1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF));
          checkConstruction(new WhiteMagician(characterName,turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  character,
                  new WhiteMagician("white1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  new Knight("knight1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF));
          checkConstruction(new WhiteMagician(characterName,turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  character,
                  new WhiteMagician("white1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF),
                  new Thief("thief1",turns,CHARACTER_HEALTH_POINTS,CHARACTER_DEF));

      }
      assertNotEquals(character, enemy);
    }

  }

  @Test
  void equipWeaponTest() {
    for (var character :
        testCharacters) {
      if(!character.getUnitClass().equals(UnitClass.ENEMY)) {
        /* here is clear that character is not an enemy, so it is totally safe
           to equip a weapon
           */
        assertEquals(NullWeapon.getNullWeapon(),((ICharacter) character).getEquippedWeapon());
        ((ICharacter) character).equip(testWeapon);
        assertEquals(testWeapon, ( (ICharacter) character).getEquippedWeapon());
      }
    }
  }
}

package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.character.player.UnitClass;
import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.WeaponType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Abstract class containing the common tests for all the types of characters.
 *
 * @author Ignacio Slater Muñoz.
 * @author Franco Seguel Lucero
 * @see ICharacter
 */
public abstract class AbstractCharacterTest {

  protected BlockingQueue<IUnit> turns;
  protected List<IUnit> testCharacters;
  protected IWeapon testWeapon;
  private int HEALTH_POINTS;
  private int DEFENSE;

  /**
   * Checks that the character waits the appropriate amount of time for it's turn.
   */
  @Test
  void waitTurnTest() {
    Assertions.assertTrue(turns.isEmpty());
    tryToEquip(testCharacters.get(0));
    testCharacters.get(0).waitTurn();
    try {
      // Thread.sleep is not accurate so this values may be changed to adjust the
      // acceptable error margin.
      // We're testing that the character waits approximately 1 second.
      Thread.sleep(900);
      Assertions.assertEquals(0, turns.size());
      Thread.sleep(1100);
      Assertions.assertEquals(1, turns.size());
      Assertions.assertEquals(testCharacters.get(0), turns.peek());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void tryToEquip(IUnit character) {
    if(!character.getUnitClass().equals(UnitClass.ENEMY)){
      /* Here is sure that character is not an enemy, so is safe to cast the character */
      ( (ICharacter) character).equip(testWeapon);
    }
  }

  protected void checkConstruction(final IUnit expectedCharacter,
      final IUnit testEqualCharacter,
      final IUnit sameClassDifferentCharacter,
      final IUnit differentClassCharacter) {
    assertEquals(expectedCharacter, testEqualCharacter);
    assertNotEquals(sameClassDifferentCharacter, testEqualCharacter);
    assertNotEquals(testEqualCharacter, differentClassCharacter);
    assertEquals(expectedCharacter.hashCode(), testEqualCharacter.hashCode());
  }

  protected void basicSetUp() {
    turns = new LinkedBlockingQueue<>();
    testWeapon = new Axe("Test", 15, 10);
    testCharacters = new ArrayList<>();
    HEALTH_POINTS = 10;
    DEFENSE = 5;
  }

  public BlockingQueue<IUnit> getTurns(){
    return turns;
  }

  public int getHealthPoints(){
    return HEALTH_POINTS;
  }

  public int getDefense(){
    return DEFENSE;
  }

  public IWeapon getTestWeapon(){
    return testWeapon;
  }
}

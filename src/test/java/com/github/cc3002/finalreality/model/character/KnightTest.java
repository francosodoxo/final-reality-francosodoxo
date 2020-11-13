package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.UnitClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class KnightTest extends AbstractCharacterTest {
  private Knight knight;
  private String NAME = "k1";

  @BeforeEach
  public void setUp(){
    super.basicSetUp();
    knight = new Knight(NAME,
            super.getTurns(),
            super.getHealthPoints(),
            super.getDefense());
    testCharacters.add(knight);
  }
  @Test
  public void testCopyNoWeapon(){
    assertEquals(knight, knight.copy());
  }

  @Test
  public void testCopyWithWeapon(){
    knight.equip(super.getTestWeaponKnight());
    assertEquals(knight,knight.copy());
  }

  @Test
  public void testNameDiffNotEquals(){
    Knight knight1 = new Knight("knight1",turns,super.getHealthPoints(),super.getDefense());
    Knight knight2 = new Knight("knight2",turns,super.getHealthPoints(),super.getDefense());
    knight1.equip(super.getTestWeaponKnight());
    knight2.equip(super.getTestWeaponKnight());
    assertNotEquals(knight1,knight2);
  }

  @Test
  public void carryNullWeapon() {
      Knight otherCharacter = (Knight) knight.copy();
      otherCharacter.equip(getTestWeaponKnight());
      assertEquals( knight, otherCharacter);
  }
  @Test
  public void testChangeHealthPointsWithWeapon(){
    knight.equip(getTestWeaponKnight());
    IUnit otherCharacter = knight.copy();
    otherCharacter.setHealthPoints(otherCharacter.getHealthPoints()+1);
    assertNotEquals(otherCharacter, knight);
  }

  @Test
  public void testChangeDefenseWithWeapon(){
    knight.equip(getTestWeaponKnight());
    IUnit otherCharacter  = knight.copy();
    otherCharacter.setDefense(otherCharacter.getDefense()+1);
    assertNotEquals(otherCharacter, knight);
  }
}

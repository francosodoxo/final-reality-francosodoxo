package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.UnitClass;
import com.github.cc3002.finalreality.model.character.player.WhiteMagician;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class WhiteMagicianTest extends AbstractCharacterTest{
  private WhiteMagician whiteMagician;
  private String NAME = "w1";

  @BeforeEach
  public void setUp(){
    super.basicSetUp();
    whiteMagician = new WhiteMagician(NAME,
            super.getTurns(),
            super.getHealthPoints(),
            super.getDefense());
    testCharacters.add(whiteMagician);
  }
  @Test
  public void testCopyNoWeapon(){
    assertEquals(whiteMagician,whiteMagician.copy());
  }

  @Test
  public void testNameDiffNotEquals(){
    WhiteMagician w1 = new WhiteMagician("w2",super.getTurns(),super.getHealthPoints(),super.getDefense());
    WhiteMagician w2 = new WhiteMagician("w3",super.getTurns(),super.getHealthPoints(),super.getDefense());
    w1.equip(super.getTestWeaponWhite());
    w2.equip(super.getTestWeaponWhite());
    assertNotEquals(w1,w2);
  }
  @Test
  public void testCopyWithWeapon(){
    whiteMagician.equip(super.getTestWeaponWhite());
    assertEquals(whiteMagician,whiteMagician.copy());
  }
  @Test
  public void carryNullWeapon() {
    WhiteMagician otherCharacter = (WhiteMagician) whiteMagician.copy();
    otherCharacter.equip(getTestWeaponWhite());
    assertEquals( testCharacters.get(0), otherCharacter);
  }

  @Test
  public void testChangeHealthPointsWithWeapon(){
    whiteMagician.equip(getTestWeaponWhite());
    IUnit otherCharacter = whiteMagician.copy();
    otherCharacter.setHealthPoints(otherCharacter.getHealthPoints()+1);
    assertNotEquals(otherCharacter, whiteMagician);
  }

  @Test
  public void testChangeDefenseWithWeapon(){
    whiteMagician.equip(getTestWeaponWhite());
    IUnit otherCharacter  = whiteMagician.copy();
    otherCharacter.setDefense(otherCharacter.getDefense()+1);
    assertNotEquals(otherCharacter, whiteMagician);
  }
}

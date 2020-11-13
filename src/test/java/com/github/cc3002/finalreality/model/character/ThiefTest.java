package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.character.player.UnitClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ThiefTest extends AbstractCharacterTest{
  private Thief thief;
  private String NAME = "t1";

  @BeforeEach
  public void setUp(){
    super.basicSetUp();
    thief = new Thief( NAME,
            super.getTurns(),
            super.getHealthPoints(),
            super.getDefense());
    testCharacters.add(thief);
  }

  @Test
  public void testCopyNoWeapon(){
    assertEquals(thief,thief.copy());
  }

  @Test
  public void testCopyWithWeapon(){
    thief.equip(super.getTestWeaponThief());
    assertEquals(thief,thief.copy());
  }
  @Test
  public void testNameDiffNotEquals(){
    Thief thief1 = new Thief("thief1",turns,super.getHealthPoints(),super.getDefense());
    Thief thief2 = new Thief("thief2",turns,super.getHealthPoints(),super.getDefense());
    thief1.equip(super.getTestWeaponThief());
    thief2.equip(super.getTestWeaponThief());
    assertNotEquals(thief1,thief2);
  }

  @Test
  public void testHealthDiffNotEquals(){
    Thief thief1 = new Thief("thief1",turns,5,super.getDefense());
    Thief thief2 = new Thief("thief2",turns,6,super.getDefense());
    thief1.equip(super.getTestWeaponThief());
    thief2.equip(super.getTestWeaponThief());
    assertNotEquals(thief1,thief2);
  }

  @Test
  public void testDefenseNotEquals(){
    Thief thief1 = new Thief("thief1",turns,super.getHealthPoints(),2);
    Thief thief2 = new Thief("thief2",turns,super.getHealthPoints(),3);
    thief1.equip(super.getTestWeaponThief());
    thief2.equip(super.getTestWeaponThief());
    assertNotEquals(thief1,thief2);
  }

  @Test
  public void carryNullWeapon() {
    Thief otherCharacter = (Thief) thief.copy();
    otherCharacter.equip(getTestWeaponThief());
    assertEquals( testCharacters.get(0), otherCharacter);
  }

  @Test
  public void testChangeHealthPointsWithWeapon(){
    thief.equip(getTestWeaponThief());
    IUnit otherCharacter = thief.copy();
    otherCharacter.setHealthPoints(otherCharacter.getHealthPoints()+1);
    assertNotEquals(otherCharacter, thief);
  }
  @Test
  public void testChangeDefenseWithWeapon(){
    thief.equip(getTestWeaponThief());
    IUnit otherCharacter  = thief.copy();
    otherCharacter.setDefense(otherCharacter.getDefense()+1);
    assertNotEquals(otherCharacter, thief);
  }

}

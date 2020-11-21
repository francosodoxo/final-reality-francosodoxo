package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.BlackMagician;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BlackMagicianTest extends AbstractCharacterTest {
  private BlackMagician blackMagician;
  private String NAME = "Ali";

  @BeforeEach
  public void setUp(){
    super.basicSetUp();
    blackMagician = new BlackMagician(NAME,
            super.getTurns(),
            super.getHealthPoints(),
            super.getDefense());
    testCharacters.add(blackMagician);
  }

  //check methods
  @Test
  public void testCopyNoWeapon(){
    assertEquals(blackMagician, blackMagician.copy());
  }

  @Test
  public void testCopyWithWeapon(){
    blackMagician.equip(super.getTestWeaponBlack());
    assertEquals(blackMagician, blackMagician.copy());
  }

  @Test
  public void testBlackNameNotEquals(){
    BlackMagician blackMagician1 = new BlackMagician("black1",turns,super.getHealthPoints(),super.getDefense());
    blackMagician1.equip(super.getTestWeaponBlack());
    BlackMagician blackMagician2 = new BlackMagician("black2",turns,super.getHealthPoints(),super.getDefense());
    blackMagician2.equip(super.getTestWeaponBlack());
    assertNotEquals(blackMagician1,blackMagician2);
  }

  @Test
  public void testBlackHealthPointsNotEquals(){
    BlackMagician blackMagician1 = new BlackMagician("black1",turns,super.getHealthPoints(),super.getDefense());
    blackMagician1.equip(super.getTestWeaponBlack());
    BlackMagician blackMagician2 = new BlackMagician("black1",turns,super.getHealthPoints()+1,super.getDefense());
    blackMagician2.equip(super.getTestWeaponBlack());
    assertNotEquals(blackMagician1,blackMagician2);
  }

  @Test
  public void testBlackDefenseEquals(){
    BlackMagician blackMagician1 = new BlackMagician("black1",turns,super.getHealthPoints(),3);
    blackMagician1.equip(super.getTestWeaponBlack());
    BlackMagician blackMagician2 = new BlackMagician("black1",turns,super.getHealthPoints(),2);
    blackMagician2.equip(super.getTestWeaponBlack());
    assertNotEquals(blackMagician1,blackMagician2);
  }
  @Test
  public void carryWeapon() {
    blackMagician.equip(getTestWeaponBlack());
    assertEquals( blackMagician,blackMagician);
  }

  @Test
  public void testChangeHealthPointsWithWeapon(){

    blackMagician.equip(getTestWeaponBlack());
    IUnit otherCharacter = blackMagician.copy();
    otherCharacter.setHealthPoints(otherCharacter.getHealthPoints()+1);
    assertNotEquals(otherCharacter,blackMagician);
  }

  @Test
  public void testChangeDefenseWithWeapon(){
    blackMagician.equip(getTestWeaponBlack());
    IUnit otherCharacter  = blackMagician.copy();
    otherCharacter.setDefense(otherCharacter.getDefense()+1);
    assertNotEquals(otherCharacter,blackMagician);
  }
}

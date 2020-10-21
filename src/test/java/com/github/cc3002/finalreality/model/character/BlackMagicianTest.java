package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.BlackMagician;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;

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
    blackMagician.equip(super.getTestWeapon());
    assertEquals(blackMagician, blackMagician.copy());
  }

  @Test
  public void testBlackNameNotEquals(){
    BlackMagician blackMagician1 = new BlackMagician("black1",turns,super.getHealthPoints(),super.getDefense());
    blackMagician1.equip(super.getTestWeapon());
    BlackMagician blackMagician2 = new BlackMagician("black2",turns,super.getHealthPoints(),super.getDefense());
    blackMagician2.equip(super.getTestWeapon());
    assertNotEquals(blackMagician1,blackMagician2);
  }

  @Test
  public void testBlackHealthPointsNotEquals(){
    BlackMagician blackMagician1 = new BlackMagician("black1",turns,super.getHealthPoints(),super.getDefense());
    blackMagician1.equip(super.getTestWeapon());
    BlackMagician blackMagician2 = new BlackMagician("black1",turns,super.getHealthPoints()+1,super.getDefense());
    blackMagician2.equip(super.getTestWeapon());
    assertNotEquals(blackMagician1,blackMagician2);
  }

  @Test
  public void testBlackDefenseNotEquals(){
    BlackMagician blackMagician1 = new BlackMagician("black1",turns,super.getHealthPoints(),3);
    blackMagician1.equip(super.getTestWeapon());
    BlackMagician blackMagician2 = new BlackMagician("black1",turns,super.getHealthPoints(),2);
    blackMagician2.equip(super.getTestWeapon());
    assertNotEquals(blackMagician1,blackMagician2);
  }
}

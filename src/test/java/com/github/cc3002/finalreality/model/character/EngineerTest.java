package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Engineer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EngineerTest extends AbstractCharacterTest {
  private Engineer engineer;
  private String NAME ="Kaku";

  @BeforeEach
  public void setUp(){
    super.basicSetUp();
    engineer = new Engineer(NAME,
            super.getTurns(),
            super.getHealthPoints(),
            super.getDefense());

    testCharacters.add(engineer);
  }

  @Test
  public void testCopyNoWeapon(){
    assertEquals(engineer,engineer.copy());
  }

  @Test
  public void testCopyWithWeapon(){
    engineer.equip(super.getTestWeaponEngineer());
    assertEquals(engineer,engineer.copy());
  }

  @Test
  public void testOnlyNameDiff(){
    Engineer engineer1 = new Engineer("engineer1",turns,super.getHealthPoints(),super.getDefense());
    engineer1.equip(super.getTestWeaponEngineer());
    Engineer engineer2 = new Engineer("engineer2",turns,super.getHealthPoints(),super.getDefense());
    engineer2.equip(super.getTestWeaponEngineer());
    assertNotEquals(engineer1,engineer2);
  }

  @Test
  public void carryWeapon() {
    IUnit otherCharacter = engineer.copy();
    ((Engineer) otherCharacter).equip(getTestWeaponEngineer());
    assertEquals( engineer, otherCharacter);
  }

  @Test
  public void testChangeHealthPointsWithWeapon(){
    engineer.equip(getTestWeaponEngineer());
    IUnit otherCharacter = engineer.copy();
    otherCharacter.setHealthPoints(otherCharacter.getHealthPoints()+1);
    assertNotEquals(otherCharacter,engineer);
  }

  @Test
  public void testChangeDefenseWithWeapon(){
    engineer.equip(getTestWeaponEngineer());
    IUnit otherCharacter  = engineer.copy();
    otherCharacter.setDefense(otherCharacter.getDefense()+1);
    assertNotEquals(otherCharacter, engineer);
    
  }
}

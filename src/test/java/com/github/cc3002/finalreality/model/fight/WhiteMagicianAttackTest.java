package com.github.cc3002.finalreality.model.fight;

import com.github.cc3002.finalreality.model.AbstractSetUpTest;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.WhiteMagician;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhiteMagicianAttackTest extends AbstractSetUpTest {
  @BeforeEach
  public void setUp(){
    super.setUp();
    super.setDamage(7);
    super.setDefensePoints(5);
    super.setHealthPoints(15);
    super.setWeight(4);
  }


  @Test
  public void whiteMagAttackWithStaff(){
    WhiteMagician character = (WhiteMagician) super.getWhiteMagician().copy();
    character.equip(getStaff());
    Enemy enemy1 = getEnemy();
    int enemyHealthPoints = enemy1.getHealthPoints();
    character.attackTo(enemy1);
    int damage = character.getEquippedWeapon().getDamage() - enemy1.getDefense();
    int expectedHealthPoints = enemyHealthPoints-damage;
    assertEquals(expectedHealthPoints,enemy1.getHealthPoints());
  }

  @Test
  public void whiteMagAtkWithStaffToDeadEnemy(){
    WhiteMagician character = (WhiteMagician) super.getWhiteMagician().copy();
    character.equip(getStaff());
    Enemy enemy1 = getEnemy();
    enemy1.setHealthPoints(0);
    character.attackTo(enemy1);
    assertEquals(0,enemy1.getHealthPoints());
  }

  @Test
  public void whiteMagAttackItselfWithStaff(){
    WhiteMagician character = (WhiteMagician) super.getWhiteMagician().copy();
    character.equip(getStaff());
    int characterHp = character.getHealthPoints();
    character.attackTo(character);
    assertEquals(characterHp,character.getHealthPoints());
  }
}

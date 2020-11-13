package com.github.cc3002.finalreality.model.fight;

import com.github.cc3002.finalreality.model.AbstractSetUpTest;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.Thief;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThiefAttackTest extends AbstractSetUpTest {
  @BeforeEach
  public void setUp(){
    super.setUp();
    super.setDamage(7);
    super.setDefensePoints(5);
    super.setHealthPoints(15);
    super.setWeight(4);
  }

  @Test
  public void thiefAttackWithBow(){
    Thief character = (Thief) super.getThief().copy();
    character.equip(getBowThief());
    Enemy enemy1 = getEnemy();
    int enemyHealthPoints = enemy1.getHealthPoints();
    character.attackTo(enemy1);
    int damage = character.getEquippedWeapon().getDamage() - enemy1.getDefense();
    int expectedHealthPoints = enemyHealthPoints-damage;
    assertEquals(expectedHealthPoints,enemy1.getHealthPoints());
  }

  @Test
  public void thiefAtkWithBowToDeadEnemy(){
    Thief character = (Thief) super.getThief().copy();
    character.equip(getBowThief());
    Enemy enemy1 = getEnemy();
    enemy1.setHealthPoints(0);
    character.attackTo(enemy1);
    assertEquals(0,enemy1.getHealthPoints());
  }

  @Test
  public void thiefAttackItselfWithBow(){
    Thief character = (Thief) super.getThief().copy();
    character.equip(getBowThief());
    int characterHp = character.getHealthPoints();
    character.attackTo(character);
    assertEquals(characterHp,character.getHealthPoints());
  }

  @Test
  public void thiefAttackWithStaff(){
    Thief character = (Thief) super.getThief().copy();
    character.equip(getStaffThief());
    Enemy enemy1 = getEnemy();
    int enemyHealthPoints = enemy1.getHealthPoints();
    character.attackTo(enemy1);
    int damage = character.getEquippedWeapon().getDamage() - enemy1.getDefense();
    int expectedHealthPoints = enemyHealthPoints-damage;
    assertEquals(expectedHealthPoints,enemy1.getHealthPoints());
  }

  @Test
  public void thiefAtkWithStaffToDeadEnemy(){
    Thief character = (Thief) super.getThief().copy();
    character.equip(getStaffThief());
    Enemy enemy1 = getEnemy();
    enemy1.setHealthPoints(0);
    character.attackTo(enemy1);
    assertEquals(0,enemy1.getHealthPoints());
  }

  @Test
  public void thiefAttackItselfWithStaff(){
    Thief character = (Thief) super.getThief().copy();
    character.equip(getStaffThief());
    int characterHp = character.getHealthPoints();
    character.attackTo(character);
    assertEquals(characterHp,character.getHealthPoints());
  }

  @Test
  public void thiefAttackWithSword(){
    Thief character = (Thief) super.getThief().copy();
    character.equip(getSwordThief());
    Enemy enemy1 = getEnemy();
    int enemyHealthPoints = enemy1.getHealthPoints();
    character.attackTo(enemy1);
    int damage = character.getEquippedWeapon().getDamage() - enemy1.getDefense();
    int expectedHealthPoints = enemyHealthPoints-damage;
    assertEquals(expectedHealthPoints,enemy1.getHealthPoints());
  }

  @Test
  public void thiefAtkWithSwordToDeadEnemy(){
    Thief character = (Thief) super.getThief().copy();
    character.equip(getSwordThief());
    Enemy enemy1 = getEnemy();
    enemy1.setHealthPoints(0);
    character.attackTo(enemy1);
    assertEquals(0,enemy1.getHealthPoints());
  }

  @Test
  public void thiefAttackItselfWithSword(){
    Thief character = (Thief) super.getThief().copy();
    character.equip(getSwordThief());
    int characterHp = character.getHealthPoints();
    character.attackTo(character);
    assertEquals(characterHp,character.getHealthPoints());
  }
}

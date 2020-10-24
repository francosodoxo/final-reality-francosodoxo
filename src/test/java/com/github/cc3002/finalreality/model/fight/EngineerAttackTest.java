package com.github.cc3002.finalreality.model.fight;

import com.github.cc3002.finalreality.model.AbstractSetUpTest;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.Engineer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EngineerAttackTest extends AbstractSetUpTest {

  @BeforeEach
  public void setUp(){
    super.setUp();
    super.setDamage(7);
    super.setDefensePoints(5);
    super.setHealthPoints(15);
    super.setWeight(4);
  }

  @Test
  public void engineerAttackWithAxe(){
    Engineer character = (Engineer) super.getEngineer().copy();
    character.equip(getAxe());
    Enemy enemy1 = getEnemy();
    int enemyHealthPoints = enemy1.getHealthPoints();
    character.attackTo(enemy1);
    int damage = character.getEquippedWeapon().getDamage() - enemy1.getDefense();
    int expectedHealthPoints = enemyHealthPoints-damage;
    assertEquals(expectedHealthPoints,enemy1.getHealthPoints());
  }

  @Test
  public void engineerAtkWithAxeToDeadEnemy(){
    Engineer character = (Engineer) super.getEngineer().copy();
    character.equip(getAxe());
    Enemy enemy1 = getEnemy();
    enemy1.setHealthPoints(0);
    character.attackTo(enemy1);
    assertEquals(0,enemy1.getHealthPoints());
  }

  @Test
  public void engineerAttackItselfWithAxe(){
    Engineer character = (Engineer) getEngineer().copy();
    character.equip(getAxe());
    int characterHp = character.getHealthPoints();
    character.attackTo(character);
    assertEquals(characterHp,character.getHealthPoints());
  }

  @Test
  public void engineerAttackWithBow(){
    Engineer character = (Engineer) super.getEngineer().copy();
    character.equip(getBow());
    Enemy enemy1 = getEnemy();
    int enemyHealthPoints = enemy1.getHealthPoints();
    character.attackTo(enemy1);
    int damage = character.getEquippedWeapon().getDamage() - enemy1.getDefense();
    int expectedHealthPoints = enemyHealthPoints-damage;
    assertEquals(expectedHealthPoints,enemy1.getHealthPoints());
  }

  @Test
  public void engineerAtkWithBowToDeadEnemy(){
    Engineer character = (Engineer) super.getEngineer().copy();
    character.equip(getBow());
    Enemy enemy1 = getEnemy();
    enemy1.setHealthPoints(0);
    character.attackTo(enemy1);
    assertEquals(0,enemy1.getHealthPoints());
  }

  @Test
  public void engineerAttackItselfWithBow(){
    Engineer character = (Engineer) getEngineer().copy();
    character.equip(getBow());
    int characterHp = character.getHealthPoints();
    character.attackTo(character);
    assertEquals(characterHp,character.getHealthPoints());
  }
}


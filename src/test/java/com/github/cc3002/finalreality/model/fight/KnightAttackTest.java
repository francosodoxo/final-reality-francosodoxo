package com.github.cc3002.finalreality.model.fight;

import com.github.cc3002.finalreality.model.AbstractSetUpTest;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnightAttackTest extends AbstractSetUpTest {
  @BeforeEach
  public void setUp(){
    super.setUp();
    super.setDamage(7);
    super.setDefensePoints(5);
    super.setHealthPoints(15);
    super.setWeight(4);
  }

  @Test
  public void knightAttackWithAxe(){
    Knight character = (Knight) super.getKnight().copy();
    character.tryToEquip(getAxeKnight());
    Enemy enemy1 = getEnemy();
    int enemyHealthPoints = enemy1.getHealthPoints();
    character.attackTo(enemy1);
    int damage = character.getEquippedWeapon().getDamage() - enemy1.getDefense();
    int expectedHealthPoints = enemyHealthPoints-damage;
    assertEquals(expectedHealthPoints,enemy1.getHealthPoints());
  }

  @Test
  public void knightAtkWithAxeToDeadEnemy(){
    Knight character = (Knight) super.getKnight().copy();
    character.tryToEquip(getAxeKnight());
    Enemy enemy1 = getEnemy();
    enemy1.setHealthPoints(0);
    character.attackTo(enemy1);
    assertEquals(0,enemy1.getHealthPoints());
  }

  @Test
  public void knightAttackItselfWithAxe(){
    Knight character = (Knight) super.getKnight().copy();
    character.tryToEquip(getAxeKnight());
    int characterHp = character.getHealthPoints();
    character.attackTo(character);
    assertEquals(characterHp,character.getHealthPoints());
  }

  @Test
  public void knightAttackWithKnife(){
    Knight character = (Knight) super.getKnight().copy();
    character.tryToEquip(getKnifeKnight());
    Enemy enemy1 = getEnemy();
    int enemyHealthPoints = enemy1.getHealthPoints();
    character.attackTo(enemy1);
    int damage = character.getEquippedWeapon().getDamage() - enemy1.getDefense();
    int expectedHealthPoints = enemyHealthPoints-damage;
    assertEquals(expectedHealthPoints,enemy1.getHealthPoints());
  }

  @Test
  public void knightAtkWithKnifeToDeadEnemy(){
    Knight character = (Knight) super.getKnight().copy();
    character.tryToEquip(getKnifeKnight());
    Enemy enemy1 = getEnemy();
    enemy1.setHealthPoints(0);
    character.attackTo(enemy1);
    assertEquals(0,enemy1.getHealthPoints());
  }

  @Test
  public void knightAttackItselfWithKnife(){
    Knight character = (Knight) super.getKnight().copy();
    character.tryToEquip(getKnifeKnight());
    int characterHp = character.getHealthPoints();
    character.attackTo(character);
    assertEquals(characterHp,character.getHealthPoints());
  }

  @Test
  public void knightAttackWithSword(){
    Knight character = (Knight) super.getKnight().copy();
    character.tryToEquip(getSwordKnight());
    Enemy enemy1 = getEnemy();
    int enemyHealthPoints = enemy1.getHealthPoints();
    character.attackTo(enemy1);
    int damage = character.getEquippedWeapon().getDamage() - enemy1.getDefense();
    int expectedHealthPoints = enemyHealthPoints-damage;
    assertEquals(expectedHealthPoints,enemy1.getHealthPoints());
  }

  @Test
  public void knightAtkWithSwordToDeadEnemy(){
    Knight character = (Knight) super.getKnight().copy();
    character.tryToEquip(getSwordKnight());
    Enemy enemy1 = getEnemy();
    enemy1.setHealthPoints(0);
    character.attackTo(enemy1);
    assertEquals(0,enemy1.getHealthPoints());
  }

  @Test
  public void knightAttackItselfWithSword(){
    Knight character = (Knight) super.getKnight().copy();
    character.tryToEquip(getSwordKnight());
    int characterHp = character.getHealthPoints();
    character.attackTo(character);
    assertEquals(characterHp,character.getHealthPoints());
  }
}

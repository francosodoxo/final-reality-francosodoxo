package com.github.cc3002.finalreality.model.fight;

import com.github.cc3002.finalreality.model.AbstractSetUpTest;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.BlackMagician;
import com.github.cc3002.finalreality.model.character.player.WhiteMagician;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlackMagicianAttackTest extends AbstractSetUpTest {

  @BeforeEach
  public void setUp(){
    super.setUp();
    super.setDamage(7);
    super.setDefensePoints(5);
    super.setHealthPoints(15);
    super.setWeight(4);
  }

  @Test
  public void blackMagAttackWithKnife(){
    BlackMagician character = (BlackMagician) super.getBlackMagician().copy();
    character.tryToEquip(getKnifeBlack());
    Enemy enemy1 = getEnemy();
    int enemyHealthPoints = enemy1.getHealthPoints();
    character.attackTo(enemy1);
    int damage = character.getEquippedWeapon().getDamage() - enemy1.getDefense();
    int expectedHealthPoints = enemyHealthPoints-damage;
    assertEquals(expectedHealthPoints,enemy1.getHealthPoints());
  }

  @Test
  public void blackMagAtkWithKnifeToDeadEnemy(){
    BlackMagician character = (BlackMagician) super.getBlackMagician().copy();
    character.tryToEquip(getKnifeBlack());
    Enemy enemy1 = getEnemy();
    enemy1.setHealthPoints(0);
    character.attackTo(enemy1);
    assertEquals(0,enemy1.getHealthPoints());
  }

  @Test
  public void blackMagAttackItselfWithKnife(){
    BlackMagician character = (BlackMagician) getBlackMagician().copy();
    character.tryToEquip(getKnifeBlack());
    int characterHp = character.getHealthPoints();
    character.attackTo(character);
    assertEquals(characterHp,character.getHealthPoints());
  }


  @Test
  public void blackMagAttackWithStaff(){
    BlackMagician character = (BlackMagician) super.getBlackMagician().copy();
    character.tryToEquip(getStaffBlack());
    Enemy enemy1 = getEnemy();
    int enemyHealthPoints = enemy1.getHealthPoints();
    character.attackTo(enemy1);
    int damage = character.getEquippedWeapon().getDamage() - enemy1.getDefense();
    int expectedHealthPoints = enemyHealthPoints-damage;
    assertEquals(expectedHealthPoints,enemy1.getHealthPoints());
  }

  @Test
  public void blackMagAtkWithBowToDeadEnemy(){
    BlackMagician character = (BlackMagician) super.getBlackMagician().copy();
    character.tryToEquip(getStaffBlack());
    Enemy enemy1 = getEnemy();
    enemy1.setHealthPoints(0);
    character.attackTo(enemy1);
    assertEquals(0,enemy1.getHealthPoints());
  }

  @Test
  public void blackMagAttackItselfWithStaff(){
    BlackMagician character = (BlackMagician) getBlackMagician().copy();
    character.tryToEquip(getStaffBlack());
    int characterHp = character.getHealthPoints();
    character.attackTo(character);
    assertEquals(characterHp,character.getHealthPoints());
  }
}

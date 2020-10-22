package com.github.cc3002.finalreality.model.fight;

import com.github.cc3002.finalreality.model.AbstractSetUpTest;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.equipweapon.TestEquipWeapon;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.AbstractSet;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FightAttackTest extends AbstractSetUpTest {

  private Enemy enemy;

  @BeforeEach
  public void setUp(){
    super.setUp();
    super.setDamage(7);
    super.setDefensePoints(5);
    super.setHealthPoints(15);
    super.setWeight(4);
    enemy = new Enemy("enemy1",10,super.getTurnsQueue(),10,7,6);
  }
  public Enemy getEnemy(){
    return enemy;
  }

  @Test
  public void enemyAtkAgainstLiveBlackMagician(){
    BlackMagician black = (BlackMagician) super.getBlackMagician().copy();
    Enemy enemy1 = getEnemy();
    int blackHealthPoints = black.getHealthPoints();
    getEnemy().attackTo(black);
    int damage = enemy1.getAtk() - black.getDefense();
    int expectedHealthPoints = blackHealthPoints-damage;
    assertEquals(expectedHealthPoints,black.getHealthPoints());
  }

  @Test
  public void enemyAtkAgainstDeadBlackMagician(){
    BlackMagician black = (BlackMagician) super.getBlackMagician().copy();
    Enemy enemy1 = getEnemy();
    black.setHealthPoints(0);
    enemy1.attackTo(black);
    assertEquals(0,black.getHealthPoints());
  }

  @Test
  public void enemyAtkAgainstLiveEngineer(){
    Engineer character = (Engineer) super.getEngineer().copy();
    Enemy enemy1 = getEnemy();
    int blackHealthPoints = character.getHealthPoints();
    getEnemy().attackTo(character);
    int damage = enemy1.getAtk() - character.getDefense();
    int expectedHealthPoints = blackHealthPoints-damage;
    assertEquals(expectedHealthPoints,character.getHealthPoints());
  }

  @Test
  public void enemyAtkAgainstDeadEngineer(){
    Engineer character = (Engineer) super.getEngineer().copy();
    Enemy enemy1 = getEnemy();
    character.setHealthPoints(0);
    enemy1.attackTo(character);
    assertEquals(0,character.getHealthPoints());
  }

  @Test
  public void enemyAtkAgainstLiveKnight(){
    Knight character = (Knight) super.getKnight().copy();
    Enemy enemy1 = getEnemy();
    int blackHealthPoints = character.getHealthPoints();
    getEnemy().attackTo(character);
    int damage = enemy1.getAtk() - character.getDefense();
    int expectedHealthPoints = blackHealthPoints-damage;
    assertEquals(expectedHealthPoints,character.getHealthPoints());
  }

  @Test
  public void enemyAtkAgainstDeadKnight(){
    Knight character = (Knight) super.getKnight().copy();
    Enemy enemy1 = getEnemy();
    character.setHealthPoints(0);
    enemy1.attackTo(character);
    assertEquals(0,character.getHealthPoints());
  }

  @Test
  public void enemyAtkAgainstLiveThief(){
    Thief character = (Thief) super.getThief().copy();
    Enemy enemy1 = getEnemy();
    int blackHealthPoints = character.getHealthPoints();
    getEnemy().attackTo(character);
    int damage = enemy1.getAtk() - character.getDefense();
    int expectedHealthPoints = blackHealthPoints-damage;
    assertEquals(expectedHealthPoints,character.getHealthPoints());
  }

  @Test
  public void enemyAtkAgainstDeadThief(){
    Thief character = (Thief) super.getThief().copy();
    Enemy enemy1 = getEnemy();
    character.setHealthPoints(0);
    enemy1.attackTo(character);
    assertEquals(0,character.getHealthPoints());
  }

  @Test
  public void enemyAtkAgainstLiveWhiteMag(){
    WhiteMagician character = (WhiteMagician) super.getWhiteMagician().copy();
    Enemy enemy1 = getEnemy();
    int blackHealthPoints = character.getHealthPoints();
    getEnemy().attackTo(character);
    int damage = enemy1.getAtk() - character.getDefense();
    int expectedHealthPoints = blackHealthPoints-damage;
    assertEquals(expectedHealthPoints,character.getHealthPoints());
  }

  @Test
  public void enemyAtkAgainstDeadWhiteMag(){
    WhiteMagician character = (WhiteMagician) super.getWhiteMagician().copy();
    Enemy enemy1 = getEnemy();
    character.setHealthPoints(0);
    enemy1.attackTo(character);
    assertEquals(0,character.getHealthPoints());
  }

  @Test
  public void enemyAttackItself(){
    Enemy enemy1 = (Enemy) getEnemy().copy();
    int enemyHp = enemy1.getHealthPoints();
    enemy1.attackTo(enemy1);
    assertEquals(enemyHp,enemy1.getHealthPoints());
  }


  @Test
  public void blackMagAttackWithKnife(){
    BlackMagician character = (BlackMagician) super.getBlackMagician().copy();
    character.equip(getKnife());
    Enemy enemy1 = getEnemy();
    int enemyHealthPoints = enemy1.getHealthPoints();
    character.attackTo(enemy1);
    int damage = character.getEquippedWeapon().getDamage() - enemy1.getDefense();
    int expectedHealthPoints = enemyHealthPoints-damage;
    assertEquals(expectedHealthPoints,enemy1.getHealthPoints());
  }

  @Test
  public void blackMagAtkWithKnifeToDeadEnemy(){
    WhiteMagician character = (WhiteMagician) super.getWhiteMagician().copy();
    character.equip(getKnife());
    Enemy enemy1 = getEnemy();
    enemy1.setHealthPoints(0);
    character.attackTo(enemy);
    assertEquals(0,enemy1.getHealthPoints());
  }

  @Test
  public void blackMagAttackItselfWithKnife(){
    BlackMagician character = (BlackMagician) getBlackMagician().copy();
    character.equip(getKnife());
    int characterHp = character.getHealthPoints();
    character.attackTo(character);
    assertEquals(characterHp,character.getHealthPoints());
  }


  @Test
  public void blackMagAttackWithStaff(){
    BlackMagician character = (BlackMagician) super.getBlackMagician().copy();
    character.equip(getStaff());
    Enemy enemy1 = getEnemy();
    int enemyHealthPoints = enemy1.getHealthPoints();
    character.attackTo(enemy1);
    int damage = character.getEquippedWeapon().getDamage() - enemy1.getDefense();
    int expectedHealthPoints = enemyHealthPoints-damage;
    assertEquals(expectedHealthPoints,enemy1.getHealthPoints());
  }

  @Test
  public void blackMagAtkWithBowToDeadEnemy(){
    WhiteMagician character = (WhiteMagician) super.getWhiteMagician().copy();
    character.equip(getStaff());
    Enemy enemy1 = getEnemy();
    enemy1.setHealthPoints(0);
    character.attackTo(enemy);
    assertEquals(0,enemy1.getHealthPoints());
  }

  @Test
  public void blackMagAttackItselfWithStaff(){
    BlackMagician character = (BlackMagician) getBlackMagician().copy();
    character.equip(getStaff());
    int characterHp = character.getHealthPoints();
    character.attackTo(character);
    assertEquals(characterHp,character.getHealthPoints());
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
    character.attackTo(enemy);
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
    character.attackTo(enemy);
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

  @Test
  public void knightAttackWithAxe(){
    Knight character = (Knight) super.getKnight().copy();
    character.equip(getAxe());
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
    character.equip(getAxe());
    Enemy enemy1 = getEnemy();
    enemy1.setHealthPoints(0);
    character.attackTo(enemy);
    assertEquals(0,enemy1.getHealthPoints());
  }

  @Test
  public void knightAttackItselfWithAxe(){
    Knight character = (Knight) super.getKnight().copy();
    character.equip(getAxe());
    int characterHp = character.getHealthPoints();
    character.attackTo(character);
    assertEquals(characterHp,character.getHealthPoints());
  }

  @Test
  public void knightAttackWithKnife(){
    Knight character = (Knight) super.getKnight().copy();
    character.equip(getKnife());
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
    character.equip(getKnife());
    Enemy enemy1 = getEnemy();
    enemy1.setHealthPoints(0);
    character.attackTo(enemy);
    assertEquals(0,enemy1.getHealthPoints());
  }

  @Test
  public void knightAttackItselfWithKnife(){
    Knight character = (Knight) super.getKnight().copy();
    character.equip(getKnife());
    int characterHp = character.getHealthPoints();
    character.attackTo(character);
    assertEquals(characterHp,character.getHealthPoints());
  }

  @Test
  public void knightAttackWithSword(){
    Knight character = (Knight) super.getKnight().copy();
    character.equip(getSword());
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
    character.equip(getSword());
    Enemy enemy1 = getEnemy();
    enemy1.setHealthPoints(0);
    character.attackTo(enemy);
    assertEquals(0,enemy1.getHealthPoints());
  }

  @Test
  public void knightAttackItselfWithSword(){
    Knight character = (Knight) super.getKnight().copy();
    character.equip(getSword());
    int characterHp = character.getHealthPoints();
    character.attackTo(character);
    assertEquals(characterHp,character.getHealthPoints());
  }
  @Test
  public void thiefAttackWithBow(){
    Thief character = (Thief) super.getThief().copy();
    character.equip(getBow());
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
    character.equip(getBow());
    Enemy enemy1 = getEnemy();
    enemy1.setHealthPoints(0);
    character.attackTo(enemy);
    assertEquals(0,enemy1.getHealthPoints());
  }

  @Test
  public void thiefAttackItselfWithBow(){
    Thief character = (Thief) super.getThief().copy();
    character.equip(getBow());
    int characterHp = character.getHealthPoints();
    character.attackTo(character);
    assertEquals(characterHp,character.getHealthPoints());
  }

  @Test
  public void thiefAttackWithStaff(){
    Thief character = (Thief) super.getThief().copy();
    character.equip(getStaff());
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
    character.equip(getStaff());
    Enemy enemy1 = getEnemy();
    enemy1.setHealthPoints(0);
    character.attackTo(enemy);
    assertEquals(0,enemy1.getHealthPoints());
  }

  @Test
  public void thiefAttackItselfWithStaff(){
    Thief character = (Thief) super.getThief().copy();
    character.equip(getStaff());
    int characterHp = character.getHealthPoints();
    character.attackTo(character);
    assertEquals(characterHp,character.getHealthPoints());
  }

  @Test
  public void thiefAttackWithSword(){
    Thief character = (Thief) super.getThief().copy();
    character.equip(getSword());
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
    character.equip(getSword());
    Enemy enemy1 = getEnemy();
    enemy1.setHealthPoints(0);
    character.attackTo(enemy);
    assertEquals(0,enemy1.getHealthPoints());
  }

  @Test
  public void thiefAttackItselfWithSword(){
    Thief character = (Thief) super.getThief().copy();
    character.equip(getSword());
    int characterHp = character.getHealthPoints();
    character.attackTo(character);
    assertEquals(characterHp,character.getHealthPoints());
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
    character.attackTo(enemy);
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

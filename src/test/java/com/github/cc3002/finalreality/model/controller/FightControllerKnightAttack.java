package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.AbstractSetUpTest;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FightControllerKnightAttack extends AbstractSetUpTest {
  private FightController fightController;
  private Knight knight;
  private Enemy enemy;
  @BeforeEach
  public void setUp(){
    super.setUp();
    fightController = super.getFightController();
    knight = super.getKnight();
    enemy = super.getEnemy();
  }

  @Test
  public void knightAttacksWithAxe(){
    knight.tryToEquip(super.getAxeKnight());
    int expectedHp = enemy.getHealthPoints() +
            enemy.getDefense() -
            knight.getEquippedWeapon().getDamage();
    fightController.knightAttacksTo(knight,enemy);
    assertEquals(expectedHp,enemy.getHealthPoints());
  }

  @Test
  public void knightAttacksWithKnife(){
    knight.tryToEquip(super.getKnifeKnight());
    int expectedHp = enemy.getHealthPoints() +
            enemy.getDefense() -
            knight.getEquippedWeapon().getDamage();
    fightController.knightAttacksTo(knight,enemy);
    assertEquals(expectedHp,enemy.getHealthPoints());
  }

  @Test
  public void knightAttacksWithSword(){
    knight.tryToEquip(super.getSwordKnight());
    int expectedHp = enemy.getHealthPoints() +
            enemy.getDefense() -
            knight.getEquippedWeapon().getDamage();
    fightController.knightAttacksTo(knight,enemy);
    assertEquals(expectedHp,enemy.getHealthPoints());
  }
}

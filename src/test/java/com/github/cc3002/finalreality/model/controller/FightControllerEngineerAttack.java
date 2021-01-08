package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.AbstractSetUpTest;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.Engineer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FightControllerEngineerAttack extends AbstractSetUpTest {
  private FightController fightController;
  private Engineer engineer;
  private Enemy enemy;

  @BeforeEach
  public void setUp(){
    super.setUp();
    fightController = super.getFightController();
    engineer = super.getEngineer();
    enemy = super.getEnemy();
  }
  @Test
  public void EngineerAttacksWithAxe(){
    engineer.tryToEquip(super.getAxeEngineer());
    int expectedHp = enemy.getHealthPoints() +
            enemy.getDefense() -
            engineer.getEquippedWeapon().getDamage();
    fightController.engineerAttacksTo(engineer,enemy);
    assertEquals(expectedHp,enemy.getHealthPoints());
  }

  @Test
  public void EngineerAttacksWithBow(){
    engineer.tryToEquip(super.getBowEngineer());
    int expectedHp = enemy.getHealthPoints() +
            enemy.getDefense() -
            engineer.getEquippedWeapon().getDamage();
    fightController.engineerAttacksTo(engineer,enemy);
    assertEquals(expectedHp,enemy.getHealthPoints());
  }
}

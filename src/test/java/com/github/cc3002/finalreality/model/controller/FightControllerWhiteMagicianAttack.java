package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.AbstractSetUpTest;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.WhiteMagician;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FightControllerWhiteMagicianAttack extends AbstractSetUpTest {
  private  FightController fightController;
  private WhiteMagician whiteMagician;
  private Enemy enemy;

  @BeforeEach
  public void setUp(){
    super.setUp();
    fightController = super.getFightController();
    whiteMagician = super.getWhiteMagician();
    enemy = super.getEnemy();
  }

  @Test
  public void whiteAttacksWithStaff(){
    whiteMagician.tryToEquip(super.getStaffWhite());
    int expectedHp = enemy.getHealthPoints() +
            enemy.getDefense() -
            whiteMagician.getEquippedWeapon().getDamage();
    fightController.whiteMagicianAttacksTo(whiteMagician,enemy);
    assertEquals(expectedHp,enemy.getHealthPoints());
  }
}

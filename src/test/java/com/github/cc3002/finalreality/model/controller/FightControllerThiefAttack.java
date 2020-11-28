package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.AbstractSetUpTest;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.Thief;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FightControllerThiefAttack extends AbstractSetUpTest {
  private FightController fightController;
  private Thief thief;
  private Enemy enemy;
  @BeforeEach
  public void setUp(){
    super.setUp();
    fightController = super.getFightController();
    thief = super.getThief();
    enemy = super.getEnemy();
  }

  @Test
  public void thiefAttacksWithBow(){
    thief.equip(super.getBowThief());
    int expectedHp = enemy.getHealthPoints() +
            enemy.getDefense() -
            thief.getEquippedWeapon().getDamage();
    fightController.thiefAttacksTo(thief,enemy);
    assertEquals(expectedHp,enemy.getHealthPoints());
  }

  @Test
  public void thiefAttacksWithStaff(){
    thief.equip(super.getStaffThief());
    int expectedHp = enemy.getHealthPoints() +
            enemy.getDefense() -
            thief.getEquippedWeapon().getDamage();
    fightController.thiefAttacksTo(thief,enemy);
    assertEquals(expectedHp,enemy.getHealthPoints());
  }

  @Test
  public void thiefAttacksWithSword(){
    thief.equip(super.getSwordThief());
    int expectedHp = enemy.getHealthPoints() +
            enemy.getDefense() -
            thief.getEquippedWeapon().getDamage();
    fightController.thiefAttacksTo(thief,enemy);
    assertEquals(expectedHp,enemy.getHealthPoints());
  }
}

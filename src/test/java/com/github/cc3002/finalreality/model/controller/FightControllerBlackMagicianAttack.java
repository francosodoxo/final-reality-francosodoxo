package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.AbstractSetUpTest;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.BlackMagician;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FightControllerBlackMagicianAttack extends AbstractSetUpTest {
  private FightController fightController;
  private BlackMagician blackMagician;
  private Enemy enemy;
  @BeforeEach
  public void setUp(){
    super.setUp();
    fightController = super.getFightController();
    blackMagician = super.getBlackMagician();
    enemy = super.getEnemy();
  }

  @Test
  public void BlackMagicianAttackWithKnife(){
    blackMagician.equip(super.getKnifeBlack());
    int expectedHp = enemy.getHealthPoints()-blackMagician.getEquippedWeapon().getDamage()+enemy.getDefense();
    fightController.blackMagicianAttacksTo(blackMagician,enemy);
    assertEquals(expectedHp,enemy.getHealthPoints());
  }

  @Test
  public void BlackMagicianAttackWithStaff(){
    blackMagician.equip(super.getStaffBlack());
    int expectedHp = enemy.getHealthPoints() + enemy.getDefense() - blackMagician.getEquippedWeapon().getDamage();
    fightController.blackMagicianAttacksTo(blackMagician,enemy);
    assertEquals(expectedHp,enemy.getHealthPoints());
  }

}

package com.github.cc3002.finalreality.model.equipweapon;

import com.github.cc3002.finalreality.model.AbstractSetUpTest;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestEquipWeapon extends AbstractSetUpTest {
  

  @BeforeEach
  public void setUp() {
    super.setUp();
  }

  /**
   * The following tests test the two "identical" instances of a character
   * but they differ in the weapon equipped. When the two instances has the same weapon,
   * they test the same. But when the weapon equipped change, the two instances are different
   */
  @Test
  public void testBlackMagicianCopiesInstancesWhenChangedWeapon() {
    assertEquals(NullWeapon.getNullWeapon(), super.getBlackMagician().getEquippedWeapon());
    BlackMagician otherBlackMagician = (BlackMagician) super.getBlackMagician().copy();
    otherBlackMagician.tryToEquip(super.getKnifeBlack());
    assertNotEquals(otherBlackMagician, super.getBlackMagician());
    super.getBlackMagician().tryToEquip(super.getKnifeBlack());
    assertEquals(otherBlackMagician, super.getBlackMagician());
    otherBlackMagician.tryToEquip(super.getStaffBlack());
    assertNotEquals(otherBlackMagician, super.getBlackMagician());
  }

  @Test
  public void testEngineerCopiesInstancesWhenChangedWeapon() {
    assertEquals(NullWeapon.getNullWeapon(), super.getEngineer().getEquippedWeapon());
    Engineer otherEngineer = (Engineer) super.getEngineer().copy();
    otherEngineer.tryToEquip(super.getAxeEngineer());
    assertNotEquals(otherEngineer, super.getEngineer());
    super.getEngineer().tryToEquip(super.getAxeEngineer());
    assertEquals(otherEngineer, super.getEngineer());
    otherEngineer.tryToEquip(super.getBowEngineer());
    assertNotEquals(otherEngineer, super.getEngineer());
  }

  @Test
  public void testKnightCopiesInstancesWhenChangedWeapon() {
    assertEquals(NullWeapon.getNullWeapon(), super.getKnight().getEquippedWeapon());
    Knight otherKnight = (Knight) super.getKnight().copy();
    otherKnight.tryToEquip(super.getSwordKnight());
    assertNotEquals(otherKnight, super.getKnight());
    super.getKnight().tryToEquip(super.getSwordKnight());
    assertEquals(otherKnight, super.getKnight());
    otherKnight.tryToEquip(super.getAxeKnight());
    assertNotEquals(otherKnight, super.getKnight());
    super.getKnight().tryToEquip(super.getAxeKnight());
    assertEquals(otherKnight, super.getKnight());
    otherKnight.tryToEquip(super.getKnifeKnight());
    assertNotEquals(otherKnight, super.getKnight());
    super.getKnight().tryToEquip(super.getKnifeKnight());
    assertEquals(otherKnight, super.getKnight());
  }

  @Test
  public void testThiefCopiesInstancesWhenChangedWeapon() {
    assertEquals(NullWeapon.getNullWeapon(), super.getThief().getEquippedWeapon());
    Thief otherThief = (Thief) super.getThief().copy();
    otherThief.tryToEquip(super.getSwordThief());
    assertNotEquals(otherThief, super.getThief());
    super.getThief().tryToEquip(super.getSwordThief());
    assertEquals(otherThief, super.getThief());
    otherThief.tryToEquip(super.getStaffThief());
    assertNotEquals(otherThief, super.getThief());
    super.getThief().tryToEquip(super.getStaffThief());
    assertEquals(otherThief, super.getThief());
    otherThief.tryToEquip(super.getBowThief());
    assertNotEquals(otherThief, super.getThief());
    super.getThief().tryToEquip(super.getBowThief());
    assertEquals(otherThief, super.getThief());
  }

  @Test
  public void testWhiteMagCopiesInstancesWhenChangedWeapon() {
    assertEquals(NullWeapon.getNullWeapon(), super.getWhiteMagician().getEquippedWeapon());
    WhiteMagician otherWhite = (WhiteMagician) super.getWhiteMagician().copy();
    otherWhite.tryToEquip(super.getStaffWhite());
    assertNotEquals(otherWhite, super.getWhiteMagician());
    Staff otherStaff = new Staff("otherNewStaff", 30, 25);
    super.getWhiteMagician().tryToEquip(super.getStaffWhite());
    assertEquals(otherWhite, super.getWhiteMagician());
    otherWhite.equip(otherStaff);
    assertNotEquals(otherWhite, super.getWhiteMagician());
    super.getWhiteMagician().equip(otherStaff);
    assertEquals(otherWhite, super.getWhiteMagician());
  }

  @Test
  public void axeToEngineer() {
    assertEquals(NullWeapon.getNullWeapon(), super.getEngineer().getEquippedWeapon());
    super.getEngineer().tryToEquip(super.getAxeEngineer());
    assertEquals(super.getAxeEngineer(), super.getEngineer().getEquippedWeapon());
  }

  @Test
  public void axeToKnight() {
    assertEquals(NullWeapon.getNullWeapon(), super.getKnight().getEquippedWeapon());
    super.getKnight().tryToEquip(super.getAxeKnight());
    assertEquals(super.getAxeKnight(), super.getKnight().getEquippedWeapon());
  }

  @Test
  public void bowToEngineer() {
    assertEquals(NullWeapon.getNullWeapon(), super.getEngineer().getEquippedWeapon());
    super.getEngineer().tryToEquip(super.getBowEngineer());
    assertEquals(super.getBowEngineer(), super.getEngineer().getEquippedWeapon());
  }

  @Test
  public void bowToThief() {
    assertEquals(NullWeapon.getNullWeapon(), super.getThief().getEquippedWeapon());
    super.getThief().tryToEquip(super.getBowThief());
    assertEquals(super.getBowThief(), super.getThief().getEquippedWeapon());
  }

  @Test
  public void knifeToBlackMag() {
    assertEquals(NullWeapon.getNullWeapon(), super.getBlackMagician().getEquippedWeapon());
    super.getBlackMagician().tryToEquip(super.getKnifeBlack());
    assertEquals(super.getKnifeBlack(), super.getBlackMagician().getEquippedWeapon());
  }

  @Test
  public void knifeToKnight() {
    assertEquals(NullWeapon.getNullWeapon(), super.getKnight().getEquippedWeapon());
    super.getKnight().tryToEquip(super.getKnifeKnight());
    assertEquals(super.getKnifeKnight(), super.getKnight().getEquippedWeapon());
  }


  @Test
  public void staffToBlackMag() {
    assertEquals(NullWeapon.getNullWeapon(), super.getBlackMagician().getEquippedWeapon());
    super.getBlackMagician().tryToEquip(super.getStaffBlack());
    assertEquals(super.getStaffBlack(), super.getBlackMagician().getEquippedWeapon());
  }

  @Test
  public void staffToThief() {
    assertEquals(NullWeapon.getNullWeapon(), super.getThief().getEquippedWeapon());
    super.getThief().tryToEquip(super.getStaffThief());
    assertEquals(super.getStaffThief(), super.getThief().getEquippedWeapon());
  }

  @Test
  public void staffToWhiteMag(){
    assertEquals(NullWeapon.getNullWeapon(),super.getWhiteMagician().getEquippedWeapon());
    super.getWhiteMagician().tryToEquip(super.getStaffWhite());
    assertEquals(super.getStaffWhite(),super.getWhiteMagician().getEquippedWeapon());
  }


  @Test
  public void swordToKnight(){
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    super.getKnight().tryToEquip(super.getSwordKnight());
    assertEquals(super.getSwordKnight(),super.getKnight().getEquippedWeapon());
  }

  @Test
  public void swordToThief(){
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    super.getThief().tryToEquip(super.getSwordThief());
    assertEquals(super.getSwordThief(),super.getThief().getEquippedWeapon());
  }

  @Test
  public void equipKnifeAfterDeadBlackMagHavingStaff(){
    super.getBlackMagician().tryToEquip(super.getStaffBlack());
    super.getBlackMagician().setHealthPoints(0);
    super.getBlackMagician().tryToEquip(super.getKnifeBlack());
    assertNotEquals(super.getKnifeBlack(),super.getBlackMagician().getEquippedWeapon());
    assertEquals(super.getStaffBlack(),super.getBlackMagician().getEquippedWeapon());
  }

  @Test
  public void equipStaffAfterDeadBlackMagHavingStaff(){
    super.getBlackMagician().tryToEquip(super.getStaffBlack());
    super.getBlackMagician().setHealthPoints(0);
    Staff otherStaff = new Staff("otherStaff",10,8);
    super.getBlackMagician().equip(otherStaff);
    assertNotEquals(otherStaff,super.getBlackMagician().getEquippedWeapon());
    assertEquals(super.getStaffBlack(),super.getBlackMagician().getEquippedWeapon());
  }

  @Test
  public void equipStaffAfterDeadBlackMagHavingKnife(){
    super.getBlackMagician().tryToEquip(super.getKnifeBlack());
    super.getBlackMagician().setHealthPoints(0);
    super.getBlackMagician().tryToEquip(super.getStaffBlack());
    assertNotEquals(super.getStaffBlack(),super.getBlackMagician().getEquippedWeapon());
    assertEquals(super.getKnifeBlack(),super.getBlackMagician().getEquippedWeapon());
  }

  @Test
  public void equipKnifeAfterDeadBlackMagHavingKnife(){
    super.getBlackMagician().tryToEquip(super.getKnifeBlack());
    super.getBlackMagician().setHealthPoints(0);
    Knife otherKnife = new Knife("otherKnife",10,8);
    super.getBlackMagician().equip(otherKnife);
    assertNotEquals(otherKnife,super.getBlackMagician().getEquippedWeapon());
    assertEquals(super.getKnifeBlack(),super.getBlackMagician().getEquippedWeapon());
  }

  @Test
  public void equipKnifeAfterDeadBlackMagNoInitialWeapon(){
    super.getBlackMagician().setHealthPoints(0);
    super.getBlackMagician().tryToEquip(super.getKnifeBlack());
    assertNotEquals(super.getKnifeBlack(),super.getBlackMagician().getEquippedWeapon());
    assertEquals(NullWeapon.getNullWeapon(),super.getBlackMagician().getEquippedWeapon());
  }

  @Test
  public void equipStaffAfterDeadBlackMagNoInitialWeapon(){
    super.getBlackMagician().setHealthPoints(0);
    super.getBlackMagician().tryToEquip(super.getStaffBlack());
    assertNotEquals(super.getStaffBlack(),super.getBlackMagician().getEquippedWeapon());
    assertEquals(NullWeapon.getNullWeapon(),super.getBlackMagician().getEquippedWeapon());
  }

  @Test
  public void equipAxeAfterDeadEngineerHavingBow(){
    assertEquals(NullWeapon.getNullWeapon(),super.getEngineer().getEquippedWeapon());
    super.getEngineer().tryToEquip(super.getBowEngineer());
    assertEquals(super.getBowEngineer(),super.getEngineer().getEquippedWeapon());
    super.getEngineer().setHealthPoints(0);
    super.getEngineer().tryToEquip(super.getAxeEngineer());
    assertEquals(super.getBowEngineer(),super.getEngineer().getEquippedWeapon());
    assertNotEquals(super.getAxeEngineer(),super.getEngineer().getEquippedWeapon());
  }

  @Test
  public void equipBowAfterDeadEngineerHavingBow(){
    assertEquals(NullWeapon.getNullWeapon(),super.getEngineer().getEquippedWeapon());
    super.getEngineer().tryToEquip(super.getBowEngineer());
    assertEquals(super.getBowEngineer(),super.getEngineer().getEquippedWeapon());
    super.getEngineer().setHealthPoints(0);
    Bow otherBow = new Bow("otherBow",10,8);
    super.getEngineer().equip(otherBow);
    assertEquals(super.getBowEngineer(),super.getEngineer().getEquippedWeapon());
    assertNotEquals(otherBow,super.getEngineer().getEquippedWeapon());
  }

  @Test
  public void equipBowAfterDeadEngineerHavingAxe(){
    assertEquals(NullWeapon.getNullWeapon(),super.getEngineer().getEquippedWeapon());
    super.getEngineer().tryToEquip(super.getAxeEngineer());
    assertEquals(super.getAxeEngineer(),super.getEngineer().getEquippedWeapon());
    super.getEngineer().setHealthPoints(0);
    super.getEngineer().tryToEquip(super.getBowEngineer());
    assertEquals(super.getAxeEngineer(),super.getEngineer().getEquippedWeapon());
    assertNotEquals(super.getBowEngineer(),super.getEngineer().getEquippedWeapon());
  }

  @Test
  public void equipAxeAfterDeadEngineerHavingAxe(){
    assertEquals(NullWeapon.getNullWeapon(),super.getEngineer().getEquippedWeapon());
    super.getEngineer().tryToEquip(super.getAxeEngineer());
    assertEquals(super.getAxeEngineer(),super.getEngineer().getEquippedWeapon());
    super.getEngineer().setHealthPoints(0);
    Axe otherAxe = new Axe("otherAxe",10,9);
    super.getEngineer().equip(otherAxe);
    assertEquals(super.getAxeEngineer(),super.getEngineer().getEquippedWeapon());
    assertNotEquals(otherAxe,super.getEngineer().getEquippedWeapon());
  }

  @Test
  public void equipAxeAfterDeadEngineerNoInitialWeapon(){
    assertEquals(NullWeapon.getNullWeapon(),super.getEngineer().getEquippedWeapon());
    super.getEngineer().setHealthPoints(0);
    super.getEngineer().tryToEquip(super.getAxeEngineer());
    assertEquals(NullWeapon.getNullWeapon(),super.getEngineer().getEquippedWeapon());
    assertNotEquals(super.getAxeEngineer(),super.getEngineer().getEquippedWeapon());
  }

  @Test
  public void equipBowAfterDeadEngineerNoInitialWeapon(){
    assertEquals(NullWeapon.getNullWeapon(),super.getEngineer().getEquippedWeapon());
    super.getEngineer().setHealthPoints(0);
    super.getEngineer().tryToEquip(super.getBowEngineer());
    assertEquals(NullWeapon.getNullWeapon(),super.getEngineer().getEquippedWeapon());
    assertNotEquals(super.getBowEngineer(),super.getEngineer().getEquippedWeapon());
  }

  @Test
  public void equipAxeToDeadKnightHavingSwordEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    super.getKnight().tryToEquip(super.getSwordKnight());
    assertEquals(super.getSwordKnight(),super.getKnight().getEquippedWeapon());
    super.getKnight().setHealthPoints(0);
    super.getKnight().tryToEquip(super.getAxeKnight());
    assertEquals(super.getSwordKnight(),super.getKnight().getEquippedWeapon());
    assertNotEquals(super.getAxeKnight(),super.getKnight().getEquippedWeapon());
  }

  @Test
  public void equipKnifeToDeadKnightHavingSwordEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    super.getKnight().tryToEquip(super.getSwordKnight());
    assertEquals(super.getSwordKnight(),super.getKnight().getEquippedWeapon());
    super.getKnight().setHealthPoints(0);
    super.getKnight().tryToEquip(super.getKnifeKnight());
    assertEquals(super.getSwordKnight(),super.getKnight().getEquippedWeapon());
    assertNotEquals(super.getKnifeKnight(),super.getKnight().getEquippedWeapon());
  }

  @Test
  public void equipSwordToDeadKnightHavingSwordEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    super.getKnight().tryToEquip(super.getSwordKnight());
    assertEquals(super.getSwordKnight(),super.getKnight().getEquippedWeapon());
    super.getKnight().setHealthPoints(0);
    Sword otherSword = new Sword("otherNewSword",10,5);
    super.getKnight().equip(otherSword);
    assertEquals(super.getSwordKnight(),super.getKnight().getEquippedWeapon());
    assertNotEquals(otherSword,super.getKnight().getEquippedWeapon());
  }

  @Test
  public void equipSwordToDeadKnightHavingAxeEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    super.getKnight().tryToEquip(super.getAxeKnight());
    assertEquals(super.getAxeKnight(),super.getKnight().getEquippedWeapon());
    super.getKnight().setHealthPoints(0);
    super.getKnight().tryToEquip(super.getSwordKnight());
    assertEquals(super.getAxeKnight(),super.getKnight().getEquippedWeapon());
    assertNotEquals(super.getSwordKnight(),super.getKnight().getEquippedWeapon());
  }

  @Test
  public void equipKnifeToDeadKnightHavingAxeEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    super.getKnight().tryToEquip(super.getAxeKnight());
    assertEquals(super.getAxeKnight(),super.getKnight().getEquippedWeapon());
    super.getKnight().setHealthPoints(0);
    super.getKnight().tryToEquip(super.getKnifeKnight());
    assertEquals(super.getAxeKnight(),super.getKnight().getEquippedWeapon());
    assertNotEquals(super.getKnifeKnight(),super.getKnight().getEquippedWeapon());
  }

  @Test
  public void equipAxeToDeadKnightHavingAxeEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    super.getKnight().tryToEquip(super.getAxeKnight());
    assertEquals(super.getAxeKnight(),super.getKnight().getEquippedWeapon());
    super.getKnight().setHealthPoints(0);
    Axe otherAxe = new Axe("otherNewAxe",10,5);
    super.getKnight().equip(otherAxe);
    assertEquals(super.getAxeKnight(),super.getKnight().getEquippedWeapon());
    assertNotEquals(otherAxe,super.getKnight().getEquippedWeapon());
  }

  @Test
  public void equipAxeToDeadKnightHavingKnifeEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    super.getKnight().tryToEquip(super.getKnifeKnight());
    assertEquals(super.getKnifeKnight(),super.getKnight().getEquippedWeapon());
    super.getKnight().setHealthPoints(0);
    super.getKnight().tryToEquip(super.getAxeKnight());
    assertEquals(super.getKnifeKnight(),super.getKnight().getEquippedWeapon());
    assertNotEquals(super.getAxeKnight(),super.getKnight().getEquippedWeapon());
  }

  @Test
  public void equipSwordToDeadKnightHavingKnifeEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    super.getKnight().tryToEquip(super.getKnifeKnight());
    assertEquals(super.getKnifeKnight(),super.getKnight().getEquippedWeapon());
    super.getKnight().setHealthPoints(0);
    super.getKnight().tryToEquip(super.getSwordKnight());
    assertEquals(super.getKnifeKnight(),super.getKnight().getEquippedWeapon());
    assertNotEquals(super.getSwordKnight(),super.getKnight().getEquippedWeapon());
  }

  @Test
  public void equipKnifeToDeadKnightHavingKnifeEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    super.getKnight().tryToEquip(super.getKnifeKnight());
    assertEquals(super.getKnifeKnight(),super.getKnight().getEquippedWeapon());
    super.getKnight().setHealthPoints(0);
    Knife otherKnife = new Knife("otherNewKnife",10,8);
    super.getKnight().equip(otherKnife);
    assertEquals(super.getKnifeKnight(),super.getKnight().getEquippedWeapon());
    assertNotEquals(otherKnife,super.getKnight().getEquippedWeapon());
  }

  @Test
  public void equipAxeToDeadKnightNoWeaponEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    super.getKnight().setHealthPoints(0);
    super.getKnight().tryToEquip(super.getAxeKnight());
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    assertNotEquals(super.getAxeKnight(),super.getKnight().getEquippedWeapon());
  }

  @Test
  public void equipKnifeToDeadKnightNoWeaponEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    super.getKnight().setHealthPoints(0);
    super.getKnight().tryToEquip(super.getKnifeKnight());
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    assertNotEquals(super.getKnifeKnight(),super.getKnight().getEquippedWeapon());
  }

  @Test
  public void equipSwordToDeadKnightNoWeaponEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    super.getKnight().setHealthPoints(0);
    super.getKnight().tryToEquip(super.getSwordKnight());
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    assertNotEquals(super.getSwordKnight(),super.getKnight().getEquippedWeapon());
  }

  @Test
  public void equipBowToDeadThiefHavingSwordEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    super.getThief().tryToEquip(super.getSwordThief());
    assertEquals(super.getSwordThief(),super.getThief().getEquippedWeapon());
    super.getThief().setHealthPoints(0);
    super.getThief().tryToEquip(super.getBowThief());
    assertEquals(super.getSwordThief(),super.getThief().getEquippedWeapon());
    assertNotEquals(super.getBowThief(),super.getThief().getEquippedWeapon());
  }

  @Test
  public void equipStaffToDeadThiefHavingSwordEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    super.getThief().tryToEquip(super.getSwordThief());
    assertEquals(super.getSwordThief(),super.getThief().getEquippedWeapon());
    super.getThief().setHealthPoints(0);
    super.getThief().tryToEquip(super.getStaffThief());
    assertEquals(super.getSwordThief(),super.getThief().getEquippedWeapon());
    assertNotEquals(super.getStaffThief(),super.getThief().getEquippedWeapon());
  }

  @Test
  public void equipSwordToDeadThiefHavingSwordEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    super.getThief().tryToEquip(super.getSwordThief());
    assertEquals(super.getSwordThief(),super.getThief().getEquippedWeapon());
    super.getThief().setHealthPoints(0);
    Sword otherSword = new Sword("otherNewSword",10,8);
    super.getThief().equip(otherSword);
    assertEquals(super.getSwordThief(),super.getThief().getEquippedWeapon());
    assertNotEquals(otherSword,super.getThief().getEquippedWeapon());
  }

  @Test
  public void equipStaffToDeadThiefHavingBowEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    super.getThief().tryToEquip(super.getBowThief());
    assertEquals(super.getBowThief(),super.getThief().getEquippedWeapon());
    super.getThief().setHealthPoints(0);
    super.getThief().tryToEquip(super.getStaffThief());
    assertEquals(super.getBowThief(),super.getThief().getEquippedWeapon());
    assertNotEquals(super.getStaffThief(),super.getThief().getEquippedWeapon());
  }

  @Test
  public void equipSwordToDeadThiefHavingBowEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    super.getThief().tryToEquip(super.getBowThief());
    assertEquals(super.getBowThief(),super.getThief().getEquippedWeapon());
    super.getThief().setHealthPoints(0);
    super.getThief().tryToEquip(super.getSwordThief());
    assertEquals(super.getBowThief(),super.getThief().getEquippedWeapon());
    assertNotEquals(super.getSwordThief(),super.getThief().getEquippedWeapon());
  }

  @Test
  public void equipBowToDeadThiefHavingBowEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    super.getThief().tryToEquip(super.getBowThief());
    assertEquals(super.getBowThief(),super.getThief().getEquippedWeapon());
    super.getThief().setHealthPoints(0);
    Bow otherBow = new Bow("newOtherBow",10,5);
    super.getThief().equip(otherBow);
    assertEquals(super.getBowThief(),super.getThief().getEquippedWeapon());
    assertNotEquals(otherBow,super.getThief().getEquippedWeapon());
  }

  @Test
  public void equipBowToDeadThiefHavingStaffEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    super.getThief().tryToEquip(super.getStaffThief());
    assertEquals(super.getStaffThief(),super.getThief().getEquippedWeapon());
    super.getThief().setHealthPoints(0);
    super.getThief().tryToEquip(super.getBowThief());
    assertEquals(super.getStaffThief(),super.getThief().getEquippedWeapon());
    assertNotEquals(super.getBowThief(),super.getThief().getEquippedWeapon());
  }

  @Test
  public void equipSwordToDeadThiefHavingStaffEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    super.getThief().tryToEquip(super.getStaffThief());
    assertEquals(super.getStaffThief(),super.getThief().getEquippedWeapon());
    super.getThief().setHealthPoints(0);
    super.getThief().tryToEquip(super.getSwordThief());
    assertEquals(super.getStaffThief(),super.getThief().getEquippedWeapon());
    assertNotEquals(super.getSwordThief(),super.getThief().getEquippedWeapon());
  }

  @Test
  public void equipStaffToDeadThiefHavingStaffEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    super.getThief().tryToEquip(super.getStaffThief());
    assertEquals(super.getStaffThief(),super.getThief().getEquippedWeapon());
    super.getThief().setHealthPoints(0);
    Staff otherStaff = new Staff("otherNewStaff", 10,8);
    super.getThief().equip(otherStaff);
    assertEquals(super.getStaffThief(),super.getThief().getEquippedWeapon());
    assertNotEquals(otherStaff,super.getThief().getEquippedWeapon());
  }

  @Test
  public void equipBowToDeadThiefNoInitialWeapon(){
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    super.getThief().setHealthPoints(0);
    super.getThief().tryToEquip(super.getBowThief());
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    assertNotEquals(super.getBowThief(),super.getThief().getEquippedWeapon());
  }

  @Test
  public void equipStaffToDeadThiefNoInitialWeapon(){
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    super.getThief().setHealthPoints(0);
    super.getThief().tryToEquip(super.getStaffThief());
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    assertNotEquals(super.getStaffThief(),super.getThief().getEquippedWeapon());
  }

  @Test
  public void equipSwordToDeadThiefNoInitialWeapon(){
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    super.getThief().setHealthPoints(0);
    super.getThief().tryToEquip(super.getSwordThief());
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    assertNotEquals(super.getSwordThief(),super.getThief().getEquippedWeapon());
  }

  @Test
  public void equipStaffToDeadWhiteMagHavingStaff(){
    super.getWhiteMagician().tryToEquip(super.getStaffWhite());
    Staff otherStaff = new Staff("otherStaff",10,3);
    super.getWhiteMagician().setHealthPoints(0);
    super.getWhiteMagician().equip(otherStaff);
    assertEquals(super.getStaffWhite(),super.getWhiteMagician().getEquippedWeapon());
    assertNotEquals(otherStaff,super.getWhiteMagician().getEquippedWeapon());
  }

  @Test
  public void equipStaffToDeadWhiteMagicianNoInitialWeapon(){
    assertEquals(NullWeapon.getNullWeapon(),super.getWhiteMagician().getEquippedWeapon());
    super.getWhiteMagician().setHealthPoints(0);
    super.getWhiteMagician().tryToEquip(super.getStaffWhite());
    assertNotEquals(super.getStaffWhite(),super.getWhiteMagician().getEquippedWeapon());
    assertEquals(NullWeapon.getNullWeapon(),super.getWhiteMagician().getEquippedWeapon());
  }
}


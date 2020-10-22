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
    otherBlackMagician.equip(super.getKnife());
    assertNotEquals(otherBlackMagician, super.getBlackMagician());
    super.getBlackMagician().equip(super.getKnife());
    assertEquals(otherBlackMagician, super.getBlackMagician());
    otherBlackMagician.equip(super.getStaff());
    assertNotEquals(otherBlackMagician, super.getBlackMagician());
  }

  @Test
  public void testEngineerCopiesInstancesWhenChangedWeapon() {
    assertEquals(NullWeapon.getNullWeapon(), super.getEngineer().getEquippedWeapon());
    Engineer otherEngineer = (Engineer) super.getEngineer().copy();
    otherEngineer.equip(super.getAxe());
    assertNotEquals(otherEngineer, super.getEngineer());
    super.getEngineer().equip(super.getAxe());
    assertEquals(otherEngineer, super.getEngineer());
    otherEngineer.equip(super.getBow());
    assertNotEquals(otherEngineer, super.getEngineer());
  }

  @Test
  public void testKnightCopiesInstancesWhenChangedWeapon() {
    assertEquals(NullWeapon.getNullWeapon(), super.getKnight().getEquippedWeapon());
    Knight otherKnight = (Knight) super.getKnight().copy();
    otherKnight.equip(super.getSword());
    assertNotEquals(otherKnight, super.getKnight());
    super.getKnight().equip(super.getSword());
    assertEquals(otherKnight, super.getKnight());
    otherKnight.equip(super.getAxe());
    assertNotEquals(otherKnight, super.getKnight());
    super.getKnight().equip(super.getAxe());
    assertEquals(otherKnight, super.getKnight());
    otherKnight.equip(super.getKnife());
    assertNotEquals(otherKnight, super.getKnight());
    super.getKnight().equip(super.getKnife());
    assertEquals(otherKnight, super.getKnight());
  }

  @Test
  public void testThiefCopiesInstancesWhenChangedWeapon() {
    assertEquals(NullWeapon.getNullWeapon(), super.getThief().getEquippedWeapon());
    Thief otherThief = (Thief) super.getThief().copy();
    otherThief.equip(super.getSword());
    assertNotEquals(otherThief, super.getThief());
    super.getThief().equip(super.getSword());
    assertEquals(otherThief, super.getThief());
    otherThief.equip(super.getStaff());
    assertNotEquals(otherThief, super.getThief());
    super.getThief().equip(super.getStaff());
    assertEquals(otherThief, super.getThief());
    otherThief.equip(super.getBow());
    assertNotEquals(otherThief, super.getThief());
    super.getThief().equip(super.getBow());
    assertEquals(otherThief, super.getThief());
  }

  @Test
  public void testWhiteMagCopiesInstancesWhenChangedWeapon() {
    assertEquals(NullWeapon.getNullWeapon(), super.getWhiteMagician().getEquippedWeapon());
    WhiteMagician otherWhite = (WhiteMagician) super.getWhiteMagician().copy();
    otherWhite.equip(super.getStaff());
    assertNotEquals(otherWhite, super.getWhiteMagician());
    Staff otherStaff = new Staff("otherNewStaff", 30, 25);
    super.getWhiteMagician().equip(super.getStaff());
    assertEquals(otherWhite, super.getWhiteMagician());
    otherWhite.equip(otherStaff);
    assertNotEquals(otherWhite, super.getWhiteMagician());
    super.getWhiteMagician().equip(otherStaff);
    assertEquals(otherWhite, super.getWhiteMagician());
  }

  @Test
  public void axeToBlackMag() {
    assertEquals(NullWeapon.getNullWeapon(), super.getBlackMagician().getEquippedWeapon());
    super.getBlackMagician().equip(super.getAxe());
    assertEquals(NullWeapon.getNullWeapon(), super.getBlackMagician().getEquippedWeapon());
  }

  @Test
  public void axeToWhiteMag() {
    assertEquals(NullWeapon.getNullWeapon(), super.getWhiteMagician().getEquippedWeapon());
    super.getWhiteMagician().equip(super.getAxe());
    assertEquals(NullWeapon.getNullWeapon(), super.getWhiteMagician().getEquippedWeapon());
  }

  @Test
  public void axeToEngineer() {
    assertEquals(NullWeapon.getNullWeapon(), super.getEngineer().getEquippedWeapon());
    super.getEngineer().equip(super.getAxe());
    assertEquals(super.getAxe(), super.getEngineer().getEquippedWeapon());
  }

  @Test
  public void axeToKnight() {
    assertEquals(NullWeapon.getNullWeapon(), super.getKnight().getEquippedWeapon());
    super.getKnight().equip(super.getAxe());
    assertEquals(super.getAxe(), super.getKnight().getEquippedWeapon());
  }

  @Test
  public void axeToThief() {
    assertEquals(NullWeapon.getNullWeapon(), super.getThief().getEquippedWeapon());
    super.getThief().equip(super.getAxe());
    assertEquals(NullWeapon.getNullWeapon(), super.getThief().getEquippedWeapon());
  }

  @Test
  public void bowToBlackMag() {
    assertEquals(NullWeapon.getNullWeapon(), super.getBlackMagician().getEquippedWeapon());
    super.getBlackMagician().equip(super.getBow());
    assertEquals(NullWeapon.getNullWeapon(), super.getBlackMagician().getEquippedWeapon());
  }

  @Test
  public void bowToWhiteMag() {
    assertEquals(NullWeapon.getNullWeapon(), super.getWhiteMagician().getEquippedWeapon());
    super.getWhiteMagician().equip(super.getBow());
    assertEquals(NullWeapon.getNullWeapon(), super.getWhiteMagician().getEquippedWeapon());
  }

  @Test
  public void bowToEngineer() {
    assertEquals(NullWeapon.getNullWeapon(), super.getEngineer().getEquippedWeapon());
    super.getEngineer().equip(super.getBow());
    assertEquals(super.getBow(), super.getEngineer().getEquippedWeapon());
  }

  @Test
  public void bowToKnight() {
    assertEquals(NullWeapon.getNullWeapon(), super.getKnight().getEquippedWeapon());
    super.getKnight().equip(super.getBow());
    assertEquals(NullWeapon.getNullWeapon(), super.getKnight().getEquippedWeapon());
  }

  @Test
  public void bowToThief() {
    assertEquals(NullWeapon.getNullWeapon(), super.getThief().getEquippedWeapon());
    super.getThief().equip(super.getBow());
    assertEquals(super.getBow(), super.getThief().getEquippedWeapon());
  }

  @Test
  public void knifeToBlackMag() {
    assertEquals(NullWeapon.getNullWeapon(), super.getBlackMagician().getEquippedWeapon());
    super.getBlackMagician().equip(super.getKnife());
    assertEquals(super.getKnife(), super.getBlackMagician().getEquippedWeapon());
  }

  @Test
  public void knifeToEngineer() {
    assertEquals(NullWeapon.getNullWeapon(), super.getEngineer().getEquippedWeapon());
    super.getEngineer().equip(super.getKnife());
    assertEquals(NullWeapon.getNullWeapon(), super.getEngineer().getEquippedWeapon());
  }

  @Test
  public void knifeToKnight() {
    assertEquals(NullWeapon.getNullWeapon(), super.getKnight().getEquippedWeapon());
    super.getKnight().equip(super.getKnife());
    assertEquals(super.getKnife(), super.getKnight().getEquippedWeapon());
  }

  @Test
  public void knifeToThief() {
    assertEquals(NullWeapon.getNullWeapon(), super.getThief().getEquippedWeapon());
    super.getThief().equip(super.getKnife());
    assertEquals(NullWeapon.getNullWeapon(), super.getThief().getEquippedWeapon());
  }

  @Test
  public void knifeToWhiteMag() {
    assertEquals(NullWeapon.getNullWeapon(), super.getWhiteMagician().getEquippedWeapon());
    super.getWhiteMagician().equip(super.getKnife());
    assertEquals(NullWeapon.getNullWeapon(), super.getWhiteMagician().getEquippedWeapon());
  }

  @Test
  public void staffToBlackMag() {
    assertEquals(NullWeapon.getNullWeapon(), super.getBlackMagician().getEquippedWeapon());
    super.getBlackMagician().equip(super.getStaff());
    assertEquals(super.getStaff(), super.getBlackMagician().getEquippedWeapon());
  }

  @Test
  public void staffToEngineer() {
    assertEquals(NullWeapon.getNullWeapon(), super.getEngineer().getEquippedWeapon());
    super.getEngineer().equip(super.getStaff());
    assertEquals(NullWeapon.getNullWeapon(), super.getEngineer().getEquippedWeapon());
  }

  @Test
  public void staffToKnight() {
    assertEquals(NullWeapon.getNullWeapon(), super.getKnight().getEquippedWeapon());
    super.getKnight().equip(super.getStaff());
    assertEquals(NullWeapon.getNullWeapon(), super.getKnight().getEquippedWeapon());
  }

  @Test
  public void staffToThief() {
    assertEquals(NullWeapon.getNullWeapon(), super.getThief().getEquippedWeapon());
    super.getThief().equip(super.getStaff());
    assertEquals(super.getStaff(), super.getThief().getEquippedWeapon());
  }

  @Test
  public void staffToWhiteMag(){
    assertEquals(NullWeapon.getNullWeapon(),super.getWhiteMagician().getEquippedWeapon());
    super.getWhiteMagician().equip(super.getStaff());
    assertEquals(super.getStaff(),super.getWhiteMagician().getEquippedWeapon());
  }

  @Test
  public void swordToBlackMag(){
    assertEquals(NullWeapon.getNullWeapon(),super.getBlackMagician().getEquippedWeapon());
    super.getBlackMagician().equip(super.getSword());
    assertEquals(NullWeapon.getNullWeapon(),super.getBlackMagician().getEquippedWeapon());
  }
  @Test
  public void swordToEngineer(){
    assertEquals(NullWeapon.getNullWeapon(),super.getEngineer().getEquippedWeapon());
    super.getEngineer().equip(super.getSword());
    assertEquals(NullWeapon.getNullWeapon(),super.getEngineer().getEquippedWeapon());
  }

  @Test
  public void swordToKnight(){
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    super.getKnight().equip(super.getSword());
    assertEquals(super.getSword(),super.getKnight().getEquippedWeapon());
  }

  @Test
  public void swordToThief(){
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    super.getThief().equip(super.getSword());
    assertEquals(super.getSword(),super.getThief().getEquippedWeapon());
  }

  @Test
  public void swordToWhiteMag(){
    assertEquals(NullWeapon.getNullWeapon(),super.getWhiteMagician().getEquippedWeapon());
    super.getWhiteMagician().equip(super.getSword());
    assertEquals(NullWeapon.getNullWeapon(),super.getWhiteMagician().getEquippedWeapon());
  }

  @Test
  public void equipKnifeAfterDeadBlackMagHavingStaff(){
    super.getBlackMagician().equip(super.getStaff());
    super.getBlackMagician().setHealthPoints(0);
    super.getBlackMagician().equip(super.getKnife());
    assertNotEquals(super.getKnife(),super.getBlackMagician().getEquippedWeapon());
    assertEquals(super.getStaff(),super.getBlackMagician().getEquippedWeapon());
  }

  @Test
  public void equipStaffAfterDeadBlackMagHavingStaff(){
    super.getBlackMagician().equip(super.getStaff());
    super.getBlackMagician().setHealthPoints(0);
    Staff otherStaff = new Staff("otherStaff",10,8);
    super.getBlackMagician().equip(otherStaff);
    assertNotEquals(otherStaff,super.getBlackMagician().getEquippedWeapon());
    assertEquals(super.getStaff(),super.getBlackMagician().getEquippedWeapon());
  }

  @Test
  public void equipStaffAfterDeadBlackMagHavingKnife(){
    super.getBlackMagician().equip(super.getKnife());
    super.getBlackMagician().setHealthPoints(0);
    super.getBlackMagician().equip(super.getStaff());
    assertNotEquals(super.getStaff(),super.getBlackMagician().getEquippedWeapon());
    assertEquals(super.getKnife(),super.getBlackMagician().getEquippedWeapon());
  }

  @Test
  public void equipKnifeAfterDeadBlackMagHavingKnife(){
    super.getBlackMagician().equip(super.getKnife());
    super.getBlackMagician().setHealthPoints(0);
    Knife otherKnife = new Knife("otherKnife",10,8);
    super.getBlackMagician().equip(otherKnife);
    assertNotEquals(otherKnife,super.getBlackMagician().getEquippedWeapon());
    assertEquals(super.getKnife(),super.getBlackMagician().getEquippedWeapon());
  }

  @Test
  public void equipKnifeAfterDeadBlackMagNoInitialWeapon(){
    super.getBlackMagician().setHealthPoints(0);
    super.getBlackMagician().equip(super.getKnife());
    assertNotEquals(super.getKnife(),super.getBlackMagician().getEquippedWeapon());
    assertEquals(NullWeapon.getNullWeapon(),super.getBlackMagician().getEquippedWeapon());
  }

  @Test
  public void equipStaffAfterDeadBlackMagNoInitialWeapon(){
    super.getBlackMagician().setHealthPoints(0);
    super.getBlackMagician().equip(super.getStaff());
    assertNotEquals(super.getStaff(),super.getBlackMagician().getEquippedWeapon());
    assertEquals(NullWeapon.getNullWeapon(),super.getBlackMagician().getEquippedWeapon());
  }

  @Test
  public void equipAxeAfterDeadEngineerHavingBow(){
    assertEquals(NullWeapon.getNullWeapon(),super.getEngineer().getEquippedWeapon());
    super.getEngineer().equip(super.getBow());
    assertEquals(super.getBow(),super.getEngineer().getEquippedWeapon());
    super.getEngineer().setHealthPoints(0);
    super.getEngineer().equip(super.getAxe());
    assertEquals(super.getBow(),super.getEngineer().getEquippedWeapon());
    assertNotEquals(super.getAxe(),super.getEngineer().getEquippedWeapon());
  }

  @Test
  public void equipBowAfterDeadEngineerHavingBow(){
    assertEquals(NullWeapon.getNullWeapon(),super.getEngineer().getEquippedWeapon());
    super.getEngineer().equip(super.getBow());
    assertEquals(super.getBow(),super.getEngineer().getEquippedWeapon());
    super.getEngineer().setHealthPoints(0);
    Bow otherBow = new Bow("otherBow",10,8);
    super.getEngineer().equip(otherBow);
    assertEquals(super.getBow(),super.getEngineer().getEquippedWeapon());
    assertNotEquals(otherBow,super.getEngineer().getEquippedWeapon());
  }

  @Test
  public void equipBowAfterDeadEngineerHavingAxe(){
    assertEquals(NullWeapon.getNullWeapon(),super.getEngineer().getEquippedWeapon());
    super.getEngineer().equip(super.getAxe());
    assertEquals(super.getAxe(),super.getEngineer().getEquippedWeapon());
    super.getEngineer().setHealthPoints(0);
    super.getEngineer().equip(super.getBow());
    assertEquals(super.getAxe(),super.getEngineer().getEquippedWeapon());
    assertNotEquals(super.getBow(),super.getEngineer().getEquippedWeapon());
  }

  @Test
  public void equipAxeAfterDeadEngineerHavingAxe(){
    assertEquals(NullWeapon.getNullWeapon(),super.getEngineer().getEquippedWeapon());
    super.getEngineer().equip(super.getAxe());
    assertEquals(super.getAxe(),super.getEngineer().getEquippedWeapon());
    super.getEngineer().setHealthPoints(0);
    Axe otherAxe = new Axe("otherAxe",10,9);
    super.getEngineer().equip(otherAxe);
    assertEquals(super.getAxe(),super.getEngineer().getEquippedWeapon());
    assertNotEquals(otherAxe,super.getEngineer().getEquippedWeapon());
  }

  @Test
  public void equipAxeAfterDeadEngineerNoInitialWeapon(){
    assertEquals(NullWeapon.getNullWeapon(),super.getEngineer().getEquippedWeapon());
    super.getEngineer().setHealthPoints(0);
    super.getEngineer().equip(super.getAxe());
    assertEquals(NullWeapon.getNullWeapon(),super.getEngineer().getEquippedWeapon());
    assertNotEquals(super.getAxe(),super.getEngineer().getEquippedWeapon());
  }

  @Test
  public void equipBowAfterDeadEngineerNoInitialWeapon(){
    assertEquals(NullWeapon.getNullWeapon(),super.getEngineer().getEquippedWeapon());
    super.getEngineer().setHealthPoints(0);
    super.getEngineer().equip(super.getBow());
    assertEquals(NullWeapon.getNullWeapon(),super.getEngineer().getEquippedWeapon());
    assertNotEquals(super.getBow(),super.getEngineer().getEquippedWeapon());
  }

  @Test
  public void equipAxeToDeadKnightHavingSwordEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    super.getKnight().equip(super.getSword());
    assertEquals(super.getSword(),super.getKnight().getEquippedWeapon());
    super.getKnight().setHealthPoints(0);
    super.getKnight().equip(super.getAxe());
    assertEquals(super.getSword(),super.getKnight().getEquippedWeapon());
    assertNotEquals(super.getAxe(),super.getKnight().getEquippedWeapon());
  }

  @Test
  public void equipKnifeToDeadKnightHavingSwordEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    super.getKnight().equip(super.getSword());
    assertEquals(super.getSword(),super.getKnight().getEquippedWeapon());
    super.getKnight().setHealthPoints(0);
    super.getKnight().equip(super.getKnife());
    assertEquals(super.getSword(),super.getKnight().getEquippedWeapon());
    assertNotEquals(super.getKnife(),super.getKnight().getEquippedWeapon());
  }

  @Test
  public void equipSwordToDeadKnightHavingSwordEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    super.getKnight().equip(super.getSword());
    assertEquals(super.getSword(),super.getKnight().getEquippedWeapon());
    super.getKnight().setHealthPoints(0);
    Sword otherSword = new Sword("otherNewSword",10,5);
    super.getKnight().equip(otherSword);
    assertEquals(super.getSword(),super.getKnight().getEquippedWeapon());
    assertNotEquals(otherSword,super.getKnight().getEquippedWeapon());
  }

  @Test
  public void equipSwordToDeadKnightHavingAxeEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    super.getKnight().equip(super.getAxe());
    assertEquals(super.getAxe(),super.getKnight().getEquippedWeapon());
    super.getKnight().setHealthPoints(0);
    super.getKnight().equip(super.getSword());
    assertEquals(super.getAxe(),super.getKnight().getEquippedWeapon());
    assertNotEquals(super.getSword(),super.getKnight().getEquippedWeapon());
  }

  @Test
  public void equipKnifeToDeadKnightHavingAxeEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    super.getKnight().equip(super.getAxe());
    assertEquals(super.getAxe(),super.getKnight().getEquippedWeapon());
    super.getKnight().setHealthPoints(0);
    super.getKnight().equip(super.getKnife());
    assertEquals(super.getAxe(),super.getKnight().getEquippedWeapon());
    assertNotEquals(super.getKnife(),super.getKnight().getEquippedWeapon());
  }

  @Test
  public void equipAxeToDeadKnightHavingAxeEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    super.getKnight().equip(super.getAxe());
    assertEquals(super.getAxe(),super.getKnight().getEquippedWeapon());
    super.getKnight().setHealthPoints(0);
    Axe otherAxe = new Axe("otherNewAxe",10,5);
    super.getKnight().equip(otherAxe);
    assertEquals(super.getAxe(),super.getKnight().getEquippedWeapon());
    assertNotEquals(otherAxe,super.getKnight().getEquippedWeapon());
  }

  @Test
  public void equipAxeToDeadKnightHavingKnifeEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    super.getKnight().equip(super.getKnife());
    assertEquals(super.getKnife(),super.getKnight().getEquippedWeapon());
    super.getKnight().setHealthPoints(0);
    super.getKnight().equip(super.getAxe());
    assertEquals(super.getKnife(),super.getKnight().getEquippedWeapon());
    assertNotEquals(super.getAxe(),super.getKnight().getEquippedWeapon());
  }

  @Test
  public void equipSwordToDeadKnightHavingKnifeEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    super.getKnight().equip(super.getKnife());
    assertEquals(super.getKnife(),super.getKnight().getEquippedWeapon());
    super.getKnight().setHealthPoints(0);
    super.getKnight().equip(super.getSword());
    assertEquals(super.getKnife(),super.getKnight().getEquippedWeapon());
    assertNotEquals(super.getSword(),super.getKnight().getEquippedWeapon());
  }

  @Test
  public void equipKnifeToDeadKnightHavingKnifeEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    super.getKnight().equip(super.getKnife());
    assertEquals(super.getKnife(),super.getKnight().getEquippedWeapon());
    super.getKnight().setHealthPoints(0);
    Knife otherKnife = new Knife("otherNewKnife",10,8);
    super.getKnight().equip(otherKnife);
    assertEquals(super.getKnife(),super.getKnight().getEquippedWeapon());
    assertNotEquals(otherKnife,super.getKnight().getEquippedWeapon());
  }

  @Test
  public void equipAxeToDeadKnightNoWeaponEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    super.getKnight().setHealthPoints(0);
    super.getKnight().equip(super.getAxe());
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    assertNotEquals(super.getAxe(),super.getKnight().getEquippedWeapon());
  }

  @Test
  public void equipKnifeToDeadKnightNoWeaponEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    super.getKnight().setHealthPoints(0);
    super.getKnight().equip(super.getKnife());
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    assertNotEquals(super.getKnife(),super.getKnight().getEquippedWeapon());
  }

  @Test
  public void equipSwordToDeadKnightNoWeaponEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    super.getKnight().setHealthPoints(0);
    super.getKnight().equip(super.getSword());
    assertEquals(NullWeapon.getNullWeapon(),super.getKnight().getEquippedWeapon());
    assertNotEquals(super.getSword(),super.getKnight().getEquippedWeapon());
  }

  @Test
  public void equipBowToDeadThiefHavingSwordEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    super.getThief().equip(super.getSword());
    assertEquals(super.getSword(),super.getThief().getEquippedWeapon());
    super.getThief().setHealthPoints(0);
    super.getThief().equip(super.getBow());
    assertEquals(super.getSword(),super.getThief().getEquippedWeapon());
    assertNotEquals(super.getBow(),super.getThief().getEquippedWeapon());
  }

  @Test
  public void equipStaffToDeadThiefHavingSwordEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    super.getThief().equip(super.getSword());
    assertEquals(super.getSword(),super.getThief().getEquippedWeapon());
    super.getThief().setHealthPoints(0);
    super.getThief().equip(super.getStaff());
    assertEquals(super.getSword(),super.getThief().getEquippedWeapon());
    assertNotEquals(super.getStaff(),super.getThief().getEquippedWeapon());
  }

  @Test
  public void equipSwordToDeadThiefHavingSwordEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    super.getThief().equip(super.getSword());
    assertEquals(super.getSword(),super.getThief().getEquippedWeapon());
    super.getThief().setHealthPoints(0);
    Sword otherSword = new Sword("otherNewSword",10,8);
    super.getThief().equip(otherSword);
    assertEquals(super.getSword(),super.getThief().getEquippedWeapon());
    assertNotEquals(otherSword,super.getThief().getEquippedWeapon());
  }

  @Test
  public void equipStaffToDeadThiefHavingBowEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    super.getThief().equip(super.getBow());
    assertEquals(super.getBow(),super.getThief().getEquippedWeapon());
    super.getThief().setHealthPoints(0);
    super.getThief().equip(super.getStaff());
    assertEquals(super.getBow(),super.getThief().getEquippedWeapon());
    assertNotEquals(super.getStaff(),super.getThief().getEquippedWeapon());
  }

  @Test
  public void equipSwordToDeadThiefHavingBowEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    super.getThief().equip(super.getBow());
    assertEquals(super.getBow(),super.getThief().getEquippedWeapon());
    super.getThief().setHealthPoints(0);
    super.getThief().equip(super.getSword());
    assertEquals(super.getBow(),super.getThief().getEquippedWeapon());
    assertNotEquals(super.getSword(),super.getThief().getEquippedWeapon());
  }

  @Test
  public void equipBowToDeadThiefHavingBowEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    super.getThief().equip(super.getBow());
    assertEquals(super.getBow(),super.getThief().getEquippedWeapon());
    super.getThief().setHealthPoints(0);
    Bow otherBow = new Bow("newOtherBow",10,5);
    super.getThief().equip(otherBow);
    assertEquals(super.getBow(),super.getThief().getEquippedWeapon());
    assertNotEquals(otherBow,super.getThief().getEquippedWeapon());
  }

  @Test
  public void equipBowToDeadThiefHavingStaffEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    super.getThief().equip(super.getStaff());
    assertEquals(super.getStaff(),super.getThief().getEquippedWeapon());
    super.getThief().setHealthPoints(0);
    super.getThief().equip(super.getBow());
    assertEquals(super.getStaff(),super.getThief().getEquippedWeapon());
    assertNotEquals(super.getBow(),super.getThief().getEquippedWeapon());
  }

  @Test
  public void equipSwordToDeadThiefHavingStaffEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    super.getThief().equip(super.getStaff());
    assertEquals(super.getStaff(),super.getThief().getEquippedWeapon());
    super.getThief().setHealthPoints(0);
    super.getThief().equip(super.getSword());
    assertEquals(super.getStaff(),super.getThief().getEquippedWeapon());
    assertNotEquals(super.getSword(),super.getThief().getEquippedWeapon());
  }

  @Test
  public void equipStaffToDeadThiefHavingStaffEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    super.getThief().equip(super.getStaff());
    assertEquals(super.getStaff(),super.getThief().getEquippedWeapon());
    super.getThief().setHealthPoints(0);
    Staff otherStaff = new Staff("otherNewStaff", 10,8);
    super.getThief().equip(otherStaff);
    assertEquals(super.getStaff(),super.getThief().getEquippedWeapon());
    assertNotEquals(otherStaff,super.getThief().getEquippedWeapon());
  }

  @Test
  public void equipBowToDeadThiefNoInitialWeapon(){
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    super.getThief().setHealthPoints(0);
    super.getThief().equip(super.getBow());
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    assertNotEquals(super.getBow(),super.getThief().getEquippedWeapon());
  }

  @Test
  public void equipStaffToDeadThiefNoInitialWeapon(){
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    super.getThief().setHealthPoints(0);
    super.getThief().equip(super.getStaff());
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    assertNotEquals(super.getStaff(),super.getThief().getEquippedWeapon());
  }

  @Test
  public void equipSwordToDeadThiefNoInitialWeapon(){
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    super.getThief().setHealthPoints(0);
    super.getThief().equip(super.getSword());
    assertEquals(NullWeapon.getNullWeapon(),super.getThief().getEquippedWeapon());
    assertNotEquals(super.getSword(),super.getThief().getEquippedWeapon());
  }

  @Test
  public void equipStaffToDeadWhiteMagHavingStaff(){
    super.getWhiteMagician().equip(super.getStaff());
    Staff otherStaff = new Staff("otherStaff",10,3);
    super.getWhiteMagician().setHealthPoints(0);
    super.getWhiteMagician().equip(otherStaff);
    assertEquals(super.getStaff(),super.getWhiteMagician().getEquippedWeapon());
    assertNotEquals(otherStaff,super.getWhiteMagician().getEquippedWeapon());
  }

  @Test
  public void equipStaffToDeadWhiteMagicianNoInitialWeapon(){
    assertEquals(NullWeapon.getNullWeapon(),super.getWhiteMagician().getEquippedWeapon());
    super.getWhiteMagician().setHealthPoints(0);
    super.getWhiteMagician().equip(super.getStaff());
    assertNotEquals(super.getStaff(),super.getWhiteMagician().getEquippedWeapon());
    assertEquals(NullWeapon.getNullWeapon(),super.getWhiteMagician().getEquippedWeapon());
  }
}


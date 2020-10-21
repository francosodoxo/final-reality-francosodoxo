package com.github.cc3002.finalreality.model.equipweapon;

import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestEquipWeapon {
  private BlackMagician blackMagician;
  private WhiteMagician whiteMagician;
  private Engineer engineer;
  private Knight knight;
  private Thief thief;

  private IWeapon axe;
  private IWeapon bow;
  private IWeapon knife;
  private IWeapon staff;
  private IWeapon sword;

  private String BLACK_MAGICIAN_NAME;
  private String WHITE_MAGICIAN_NAME;
  private String ENGINEER_NAME;
  private String KNIGHT_NAME;
  private String THIEF_NAME;

  private String AXE_NAME;
  private String BOW_NAME;
  private String KNIFE_NAME;
  private String STAFF_NAME;
  private String SWORD_NAME;

  private int HEALTH_POINTS;
  private int DEFENSE_POINTS;
  private int DAMAGE;
  private int WEIGHT;

  private BlockingQueue<IUnit> turnsQueue;

  @BeforeEach
  public void setUp() {
    BLACK_MAGICIAN_NAME = "Javier";
    WHITE_MAGICIAN_NAME = "Rodrigo";
    ENGINEER_NAME = "Malu";
    KNIGHT_NAME = "Quijote";
    THIEF_NAME = "Andrea";

    AXE_NAME = "Basic Axe";
    BOW_NAME = "Basic Bow";
    KNIFE_NAME = "Basic knife";
    STAFF_NAME = "Basic Staff";
    SWORD_NAME = "Basic Sword";

    HEALTH_POINTS = 10;
    DEFENSE_POINTS = 5;
    DAMAGE = 3;
    WEIGHT = 2;

    blackMagician = new BlackMagician(BLACK_MAGICIAN_NAME, turnsQueue, HEALTH_POINTS, DEFENSE_POINTS);
    whiteMagician = new WhiteMagician(WHITE_MAGICIAN_NAME, turnsQueue, HEALTH_POINTS, DEFENSE_POINTS);
    engineer = new Engineer(ENGINEER_NAME, turnsQueue, HEALTH_POINTS, DEFENSE_POINTS);
    knight = new Knight(KNIGHT_NAME, turnsQueue, HEALTH_POINTS, DEFENSE_POINTS);
    thief = new Thief(THIEF_NAME, turnsQueue, HEALTH_POINTS, DEFENSE_POINTS);

    axe = new Axe(AXE_NAME, DAMAGE, WEIGHT);
    bow = new Bow(BOW_NAME, DAMAGE, WEIGHT);
    knife = new Knife(KNIFE_NAME, DAMAGE, WEIGHT);
    staff = new Staff(STAFF_NAME, DAMAGE, WEIGHT);
    sword = new Sword(SWORD_NAME, DAMAGE, WEIGHT);
  }

  /**
   * The following tests test the two "identical" instances of a character
   * but they differ in the weapon equipped. When the two instances has the same weapon,
   * they test the same. But when the weapon equipped change, the two instances are different
   */
  @Test
  public void testBlackMagicianCopiesInstancesWhenChangedWeapon() {
    assertEquals(NullWeapon.getNullWeapon(), blackMagician.getEquippedWeapon());
    BlackMagician otherBlackMagician = (BlackMagician) blackMagician.copy();
    otherBlackMagician.equip(knife);
    assertNotEquals(otherBlackMagician, blackMagician);
    blackMagician.equip(knife);
    assertEquals(otherBlackMagician, blackMagician);
    otherBlackMagician.equip(staff);
    assertNotEquals(otherBlackMagician, blackMagician);
  }

  @Test
  public void testEngineerCopiesInstancesWhenChangedWeapon() {
    assertEquals(NullWeapon.getNullWeapon(), engineer.getEquippedWeapon());
    Engineer otherEngineer = (Engineer) engineer.copy();
    otherEngineer.equip(axe);
    assertNotEquals(otherEngineer, engineer);
    engineer.equip(axe);
    assertEquals(otherEngineer, engineer);
    otherEngineer.equip(bow);
    assertNotEquals(otherEngineer, engineer);
  }

  @Test
  public void testKnightCopiesInstancesWhenChangedWeapon() {
    assertEquals(NullWeapon.getNullWeapon(), knight.getEquippedWeapon());
    Knight otherKnight = (Knight) knight.copy();
    otherKnight.equip(sword);
    assertNotEquals(otherKnight, knight);
    knight.equip(sword);
    assertEquals(otherKnight, knight);
    otherKnight.equip(axe);
    assertNotEquals(otherKnight, knight);
    knight.equip(axe);
    assertEquals(otherKnight, knight);
    otherKnight.equip(knife);
    assertNotEquals(otherKnight, knight);
    knight.equip(knife);
    assertEquals(otherKnight, knight);
  }

  @Test
  public void testThiefCopiesInstancesWhenChangedWeapon() {
    assertEquals(NullWeapon.getNullWeapon(), thief.getEquippedWeapon());
    Thief otherThief = (Thief) thief.copy();
    otherThief.equip(sword);
    assertNotEquals(otherThief, thief);
    thief.equip(sword);
    assertEquals(otherThief, thief);
    otherThief.equip(staff);
    assertNotEquals(otherThief, thief);
    thief.equip(staff);
    assertEquals(otherThief, thief);
    otherThief.equip(bow);
    assertNotEquals(otherThief, thief);
    thief.equip(bow);
    assertEquals(otherThief, thief);
  }

  @Test
  public void testWhiteMagCopiesInstancesWhenChangedWeapon() {
    assertEquals(NullWeapon.getNullWeapon(), whiteMagician.getEquippedWeapon());
    WhiteMagician otherWhite = (WhiteMagician) whiteMagician.copy();
    otherWhite.equip(staff);
    assertNotEquals(otherWhite, whiteMagician);
    Staff otherStaff = new Staff("otherNewStaff", 30, 25);
    whiteMagician.equip(staff);
    assertEquals(otherWhite, whiteMagician);
    otherWhite.equip(otherStaff);
    assertNotEquals(otherWhite, whiteMagician);
    whiteMagician.equip(otherStaff);
    assertEquals(otherWhite, whiteMagician);
  }

  @Test
  public void axeToBlackMag() {
    assertEquals(NullWeapon.getNullWeapon(), blackMagician.getEquippedWeapon());
    blackMagician.equip(axe);
    assertEquals(NullWeapon.getNullWeapon(), blackMagician.getEquippedWeapon());
  }

  @Test
  public void axeToWhiteMag() {
    assertEquals(NullWeapon.getNullWeapon(), whiteMagician.getEquippedWeapon());
    whiteMagician.equip(axe);
    assertEquals(NullWeapon.getNullWeapon(), whiteMagician.getEquippedWeapon());
  }

  @Test
  public void axeToEngineer() {
    assertEquals(NullWeapon.getNullWeapon(), engineer.getEquippedWeapon());
    engineer.equip(axe);
    assertEquals(axe, engineer.getEquippedWeapon());
  }

  @Test
  public void axeToKnight() {
    assertEquals(NullWeapon.getNullWeapon(), knight.getEquippedWeapon());
    knight.equip(axe);
    assertEquals(axe, knight.getEquippedWeapon());
  }

  @Test
  public void axeToThief() {
    assertEquals(NullWeapon.getNullWeapon(), thief.getEquippedWeapon());
    thief.equip(axe);
    assertEquals(NullWeapon.getNullWeapon(), thief.getEquippedWeapon());
  }

  @Test
  public void bowToBlackMag() {
    assertEquals(NullWeapon.getNullWeapon(), blackMagician.getEquippedWeapon());
    blackMagician.equip(bow);
    assertEquals(NullWeapon.getNullWeapon(), blackMagician.getEquippedWeapon());
  }

  @Test
  public void bowToWhiteMag() {
    assertEquals(NullWeapon.getNullWeapon(), whiteMagician.getEquippedWeapon());
    whiteMagician.equip(bow);
    assertEquals(NullWeapon.getNullWeapon(), whiteMagician.getEquippedWeapon());
  }

  @Test
  public void bowToEngineer() {
    assertEquals(NullWeapon.getNullWeapon(), engineer.getEquippedWeapon());
    engineer.equip(bow);
    assertEquals(bow, engineer.getEquippedWeapon());
  }

  @Test
  public void bowToKnight() {
    assertEquals(NullWeapon.getNullWeapon(), knight.getEquippedWeapon());
    knight.equip(bow);
    assertEquals(NullWeapon.getNullWeapon(), knight.getEquippedWeapon());
  }

  @Test
  public void bowToThief() {
    assertEquals(NullWeapon.getNullWeapon(), thief.getEquippedWeapon());
    thief.equip(bow);
    assertEquals(bow, thief.getEquippedWeapon());
  }

  @Test
  public void knifeToBlackMag() {
    assertEquals(NullWeapon.getNullWeapon(), blackMagician.getEquippedWeapon());
    blackMagician.equip(knife);
    assertEquals(knife, blackMagician.getEquippedWeapon());
  }

  @Test
  public void knifeToEngineer() {
    assertEquals(NullWeapon.getNullWeapon(), engineer.getEquippedWeapon());
    engineer.equip(knife);
    assertEquals(NullWeapon.getNullWeapon(), engineer.getEquippedWeapon());
  }

  @Test
  public void knifeToKnight() {
    assertEquals(NullWeapon.getNullWeapon(), knight.getEquippedWeapon());
    knight.equip(knife);
    assertEquals(knife, knight.getEquippedWeapon());
  }

  @Test
  public void knifeToThief() {
    assertEquals(NullWeapon.getNullWeapon(), thief.getEquippedWeapon());
    thief.equip(knife);
    assertEquals(NullWeapon.getNullWeapon(), thief.getEquippedWeapon());
  }

  @Test
  public void knifeToWhiteMag() {
    assertEquals(NullWeapon.getNullWeapon(), whiteMagician.getEquippedWeapon());
    whiteMagician.equip(knife);
    assertEquals(NullWeapon.getNullWeapon(), whiteMagician.getEquippedWeapon());
  }

  @Test
  public void staffToBlackMag() {
    assertEquals(NullWeapon.getNullWeapon(), whiteMagician.getEquippedWeapon());
    blackMagician.equip(staff);
    assertEquals(staff, blackMagician.getEquippedWeapon());
  }

  @Test
  public void staffToEngineer() {
    assertEquals(NullWeapon.getNullWeapon(), engineer.getEquippedWeapon());
    engineer.equip(staff);
    assertEquals(NullWeapon.getNullWeapon(), engineer.getEquippedWeapon());
  }

  @Test
  public void staffToKnight() {
    assertEquals(NullWeapon.getNullWeapon(), knight.getEquippedWeapon());
    knight.equip(staff);
    assertEquals(NullWeapon.getNullWeapon(), engineer.getEquippedWeapon());
  }

  @Test
  public void staffToThief() {
    assertEquals(NullWeapon.getNullWeapon(), thief.getEquippedWeapon());
    thief.equip(staff);
    assertEquals(staff, thief.getEquippedWeapon());
  }

  @Test
  public void staffToWhiteMag(){
    assertEquals(NullWeapon.getNullWeapon(),whiteMagician.getEquippedWeapon());
    whiteMagician.equip(staff);
    assertEquals(staff,whiteMagician.getEquippedWeapon());
  }

  @Test
  public void swordToBlackMag(){
    assertEquals(NullWeapon.getNullWeapon(),blackMagician.getEquippedWeapon());
    blackMagician.equip(sword);
    assertEquals(NullWeapon.getNullWeapon(),blackMagician.getEquippedWeapon());
  }
  @Test
  public void swordToEngineer(){
    assertEquals(NullWeapon.getNullWeapon(),engineer.getEquippedWeapon());
    engineer.equip(sword);
    assertEquals(NullWeapon.getNullWeapon(),engineer.getEquippedWeapon());
  }

  @Test
  public void swordToKnight(){
    assertEquals(NullWeapon.getNullWeapon(),knight.getEquippedWeapon());
    knight.equip(sword);
    assertEquals(sword,knight.getEquippedWeapon());
  }

  @Test
  public void swordToThief(){
    assertEquals(NullWeapon.getNullWeapon(),thief.getEquippedWeapon());
    thief.equip(sword);
    assertEquals(sword,thief.getEquippedWeapon());
  }

  @Test
  public void swordToWhiteMag(){
    assertEquals(NullWeapon.getNullWeapon(),whiteMagician.getEquippedWeapon());
    whiteMagician.equip(sword);
    assertEquals(NullWeapon.getNullWeapon(),whiteMagician.getEquippedWeapon());
  }

  @Test
  public void equipKnifeAfterDeadBlackMagHavingStaff(){
    blackMagician.equip(staff);
    blackMagician.setHealthPoints(0);
    blackMagician.equip(knife);
    assertNotEquals(knife,blackMagician.getEquippedWeapon());
    assertEquals(staff,blackMagician.getEquippedWeapon());
  }

  @Test
  public void equipStaffAfterDeadBlackMagHavingStaff(){
    blackMagician.equip(staff);
    blackMagician.setHealthPoints(0);
    Staff otherStaff = new Staff("otherStaff",10,8);
    blackMagician.equip(otherStaff);
    assertNotEquals(otherStaff,blackMagician.getEquippedWeapon());
    assertEquals(staff,blackMagician.getEquippedWeapon());
  }

  @Test
  public void equipStaffAfterDeadBlackMagHavingKnife(){
    blackMagician.equip(knife);
    blackMagician.setHealthPoints(0);
    blackMagician.equip(staff);
    assertNotEquals(staff,blackMagician.getEquippedWeapon());
    assertEquals(knife,blackMagician.getEquippedWeapon());
  }

  @Test
  public void equipKnifeAfterDeadBlackMagHavingKnife(){
    blackMagician.equip(knife);
    blackMagician.setHealthPoints(0);
    Knife otherKnife = new Knife("otherKnife",10,8);
    blackMagician.equip(otherKnife);
    assertNotEquals(otherKnife,blackMagician.getEquippedWeapon());
    assertEquals(knife,blackMagician.getEquippedWeapon());
  }

  @Test
  public void equipKnifeAfterDeadBlackMagNoInitialWeapon(){
    blackMagician.setHealthPoints(0);
    blackMagician.equip(knife);
    assertNotEquals(knife,blackMagician.getEquippedWeapon());
    assertEquals(NullWeapon.getNullWeapon(),blackMagician.getEquippedWeapon());
  }

  @Test
  public void equipStaffAfterDeadBlackMagNoInitialWeapon(){
    blackMagician.setHealthPoints(0);
    blackMagician.equip(staff);
    assertNotEquals(staff,blackMagician.getEquippedWeapon());
    assertEquals(NullWeapon.getNullWeapon(),blackMagician.getEquippedWeapon());
  }

  @Test
  public void equipAxeAfterDeadEngineerHavingBow(){
    assertEquals(NullWeapon.getNullWeapon(),engineer.getEquippedWeapon());
    engineer.equip(bow);
    assertEquals(bow,engineer.getEquippedWeapon());
    engineer.setHealthPoints(0);
    engineer.equip(axe);
    assertEquals(bow,engineer.getEquippedWeapon());
    assertNotEquals(axe,engineer.getEquippedWeapon());
  }

  @Test
  public void equipBowAfterDeadEngineerHavingBow(){
    assertEquals(NullWeapon.getNullWeapon(),engineer.getEquippedWeapon());
    engineer.equip(bow);
    assertEquals(bow,engineer.getEquippedWeapon());
    engineer.setHealthPoints(0);
    Bow otherBow = new Bow("otherBow",10,8);
    engineer.equip(otherBow);
    assertEquals(bow,engineer.getEquippedWeapon());
    assertNotEquals(otherBow,engineer.getEquippedWeapon());
  }

  @Test
  public void equipBowAfterDeadEngineerHavingAxe(){
    assertEquals(NullWeapon.getNullWeapon(),engineer.getEquippedWeapon());
    engineer.equip(axe);
    assertEquals(axe,engineer.getEquippedWeapon());
    engineer.setHealthPoints(0);
    engineer.equip(bow);
    assertEquals(axe,engineer.getEquippedWeapon());
    assertNotEquals(bow,engineer.getEquippedWeapon());
  }

  @Test
  public void equipAxeAfterDeadEngineerHavingAxe(){
    assertEquals(NullWeapon.getNullWeapon(),engineer.getEquippedWeapon());
    engineer.equip(axe);
    assertEquals(axe,engineer.getEquippedWeapon());
    engineer.setHealthPoints(0);
    Axe otherAxe = new Axe("otherAxe",10,9);
    engineer.equip(otherAxe);
    assertEquals(axe,engineer.getEquippedWeapon());
    assertNotEquals(otherAxe,engineer.getEquippedWeapon());
  }

  @Test
  public void equipAxeAfterDeadEngineerNoInitialWeapon(){
    assertEquals(NullWeapon.getNullWeapon(),engineer.getEquippedWeapon());
    engineer.setHealthPoints(0);
    engineer.equip(axe);
    assertEquals(NullWeapon.getNullWeapon(),engineer.getEquippedWeapon());
    assertNotEquals(axe,engineer.getEquippedWeapon());
  }

  @Test
  public void equipBowAfterDeadEngineerNoInitialWeapon(){
    assertEquals(NullWeapon.getNullWeapon(),engineer.getEquippedWeapon());
    engineer.setHealthPoints(0);
    engineer.equip(bow);
    assertEquals(NullWeapon.getNullWeapon(),engineer.getEquippedWeapon());
    assertNotEquals(bow,engineer.getEquippedWeapon());
  }

  @Test
  public void equipAxeToDeadKnightHavingSwordEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),knight.getEquippedWeapon());
    knight.equip(sword);
    assertEquals(sword,knight.getEquippedWeapon());
    knight.setHealthPoints(0);
    knight.equip(axe);
    assertEquals(sword,knight.getEquippedWeapon());
    assertNotEquals(axe,knight.getEquippedWeapon());
  }

  @Test
  public void equipKnifeToDeadKnightHavingSwordEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),knight.getEquippedWeapon());
    knight.equip(sword);
    assertEquals(sword,knight.getEquippedWeapon());
    knight.setHealthPoints(0);
    knight.equip(knife);
    assertEquals(sword,knight.getEquippedWeapon());
    assertNotEquals(knife,knight.getEquippedWeapon());
  }

  @Test
  public void equipSwordToDeadKnightHavingSwordEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),knight.getEquippedWeapon());
    knight.equip(sword);
    assertEquals(sword,knight.getEquippedWeapon());
    knight.setHealthPoints(0);
    Sword otherSword = new Sword("otherNewSword",10,5);
    knight.equip(otherSword);
    assertEquals(sword,knight.getEquippedWeapon());
    assertNotEquals(otherSword,knight.getEquippedWeapon());
  }

  @Test
  public void equipSwordToDeadKnightHavingAxeEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),knight.getEquippedWeapon());
    knight.equip(axe);
    assertEquals(axe,knight.getEquippedWeapon());
    knight.setHealthPoints(0);
    knight.equip(sword);
    assertEquals(axe,knight.getEquippedWeapon());
    assertNotEquals(sword,knight.getEquippedWeapon());
  }

  @Test
  public void equipKnifeToDeadKnightHavingAxeEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),knight.getEquippedWeapon());
    knight.equip(axe);
    assertEquals(axe,knight.getEquippedWeapon());
    knight.setHealthPoints(0);
    knight.equip(knife);
    assertEquals(axe,knight.getEquippedWeapon());
    assertNotEquals(knife,knight.getEquippedWeapon());
  }

  @Test
  public void equipAxeToDeadKnightHavingAxeEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),knight.getEquippedWeapon());
    knight.equip(axe);
    assertEquals(axe,knight.getEquippedWeapon());
    knight.setHealthPoints(0);
    Axe otherAxe = new Axe("otherNewAxe",10,5);
    knight.equip(otherAxe);
    assertEquals(axe,knight.getEquippedWeapon());
    assertNotEquals(otherAxe,knight.getEquippedWeapon());
  }

  @Test
  public void equipAxeToDeadKnightHavingKnifeEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),knight.getEquippedWeapon());
    knight.equip(knife);
    assertEquals(knife,knight.getEquippedWeapon());
    knight.setHealthPoints(0);
    knight.equip(axe);
    assertEquals(knife,knight.getEquippedWeapon());
    assertNotEquals(axe,knight.getEquippedWeapon());
  }

  @Test
  public void equipSwordToDeadKnightHavingKnifeEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),knight.getEquippedWeapon());
    knight.equip(knife);
    assertEquals(knife,knight.getEquippedWeapon());
    knight.setHealthPoints(0);
    knight.equip(sword);
    assertEquals(knife,knight.getEquippedWeapon());
    assertNotEquals(sword,knight.getEquippedWeapon());
  }

  @Test
  public void equipKnifeToDeadKnightHavingKnifeEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),knight.getEquippedWeapon());
    knight.equip(knife);
    assertEquals(knife,knight.getEquippedWeapon());
    knight.setHealthPoints(0);
    Knife otherKnife = new Knife("otherNewKnife",10,8);
    knight.equip(otherKnife);
    assertEquals(knife,knight.getEquippedWeapon());
    assertNotEquals(otherKnife,knight.getEquippedWeapon());
  }

  @Test
  public void equipAxeToDeadKnightNoWeaponEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),knight.getEquippedWeapon());
    knight.setHealthPoints(0);
    knight.equip(axe);
    assertEquals(NullWeapon.getNullWeapon(),knight.getEquippedWeapon());
    assertNotEquals(axe,knight.getEquippedWeapon());
  }

  @Test
  public void equipKnifeToDeadKnightNoWeaponEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),knight.getEquippedWeapon());
    knight.setHealthPoints(0);
    knight.equip(knife);
    assertEquals(NullWeapon.getNullWeapon(),knight.getEquippedWeapon());
    assertNotEquals(knife,knight.getEquippedWeapon());
  }

  @Test
  public void equipSwordToDeadKnightNoWeaponEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),knight.getEquippedWeapon());
    knight.setHealthPoints(0);
    knight.equip(sword);
    assertEquals(NullWeapon.getNullWeapon(),knight.getEquippedWeapon());
    assertNotEquals(sword,knight.getEquippedWeapon());
  }

  @Test
  public void equipBowToDeadThiefHavingSwordEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),thief.getEquippedWeapon());
    thief.equip(sword);
    assertEquals(sword,thief.getEquippedWeapon());
    thief.setHealthPoints(0);
    thief.equip(bow);
    assertEquals(sword,thief.getEquippedWeapon());
    assertNotEquals(bow,thief.getEquippedWeapon());
  }

  @Test
  public void equipStaffToDeadThiefHavingSwordEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),thief.getEquippedWeapon());
    thief.equip(sword);
    assertEquals(sword,thief.getEquippedWeapon());
    thief.setHealthPoints(0);
    thief.equip(staff);
    assertEquals(sword,thief.getEquippedWeapon());
    assertNotEquals(staff,thief.getEquippedWeapon());
  }

  @Test
  public void equipSwordToDeadThiefHavingSwordEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),thief.getEquippedWeapon());
    thief.equip(sword);
    assertEquals(sword,thief.getEquippedWeapon());
    thief.setHealthPoints(0);
    Sword otherSword = new Sword("otherNewSword",10,8);
    thief.equip(otherSword);
    assertEquals(sword,thief.getEquippedWeapon());
    assertNotEquals(otherSword,thief.getEquippedWeapon());
  }

  @Test
  public void equipStaffToDeadThiefHavingBowEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),thief.getEquippedWeapon());
    thief.equip(bow);
    assertEquals(bow,thief.getEquippedWeapon());
    thief.setHealthPoints(0);
    thief.equip(staff);
    assertEquals(bow,thief.getEquippedWeapon());
    assertNotEquals(staff,thief.getEquippedWeapon());
  }

  @Test
  public void equipSwordToDeadThiefHavingBowEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),thief.getEquippedWeapon());
    thief.equip(bow);
    assertEquals(bow,thief.getEquippedWeapon());
    thief.setHealthPoints(0);
    thief.equip(sword);
    assertEquals(bow,thief.getEquippedWeapon());
    assertNotEquals(sword,thief.getEquippedWeapon());
  }

  @Test
  public void equipBowToDeadThiefHavingBowEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),thief.getEquippedWeapon());
    thief.equip(bow);
    assertEquals(bow,thief.getEquippedWeapon());
    thief.setHealthPoints(0);
    Bow otherBow = new Bow("newOtherBow",10,5);
    thief.equip(otherBow);
    assertEquals(bow,thief.getEquippedWeapon());
    assertNotEquals(otherBow,thief.getEquippedWeapon());
  }

  @Test
  public void equipBowToDeadThiefHavingStaffEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),thief.getEquippedWeapon());
    thief.equip(staff);
    assertEquals(staff,thief.getEquippedWeapon());
    thief.setHealthPoints(0);
    thief.equip(bow);
    assertEquals(staff,thief.getEquippedWeapon());
    assertNotEquals(bow,thief.getEquippedWeapon());
  }

  @Test
  public void equipSwordToDeadThiefHavingStaffEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),thief.getEquippedWeapon());
    thief.equip(staff);
    assertEquals(staff,thief.getEquippedWeapon());
    thief.setHealthPoints(0);
    thief.equip(sword);
    assertEquals(staff,thief.getEquippedWeapon());
    assertNotEquals(sword,thief.getEquippedWeapon());
  }

  @Test
  public void equipStaffToDeadThiefHavingStaffEquipped(){
    assertEquals(NullWeapon.getNullWeapon(),thief.getEquippedWeapon());
    thief.equip(staff);
    assertEquals(staff,thief.getEquippedWeapon());
    thief.setHealthPoints(0);
    Staff otherStaff = new Staff("otherNewStaff", 10,8);
    thief.equip(otherStaff);
    assertEquals(staff,thief.getEquippedWeapon());
    assertNotEquals(otherStaff,thief.getEquippedWeapon());
  }

  @Test
  public void equipBowToDeadThiefNoInitialWeapon(){
    assertEquals(NullWeapon.getNullWeapon(),thief.getEquippedWeapon());
    thief.setHealthPoints(0);
    thief.equip(bow);
    assertEquals(NullWeapon.getNullWeapon(),thief.getEquippedWeapon());
    assertNotEquals(bow,thief.getEquippedWeapon());
  }

  @Test
  public void equipStaffToDeadThiefNoInitialWeapon(){
    assertEquals(NullWeapon.getNullWeapon(),thief.getEquippedWeapon());
    thief.setHealthPoints(0);
    thief.equip(staff);
    assertEquals(NullWeapon.getNullWeapon(),thief.getEquippedWeapon());
    assertNotEquals(staff,thief.getEquippedWeapon());
  }

  @Test
  public void equipSwordToDeadThiefNoInitialWeapon(){
    assertEquals(NullWeapon.getNullWeapon(),thief.getEquippedWeapon());
    thief.setHealthPoints(0);
    thief.equip(sword);
    assertEquals(NullWeapon.getNullWeapon(),thief.getEquippedWeapon());
    assertNotEquals(sword,thief.getEquippedWeapon());
  }

  @Test
  public void equipStaffToDeadWhiteMagHavingStaff(){
    whiteMagician.equip(staff);
    Staff otherStaff = new Staff("otherStaff",10,3);
    whiteMagician.setHealthPoints(0);
    whiteMagician.equip(otherStaff);
    assertEquals(staff,whiteMagician.getEquippedWeapon());
    assertNotEquals(otherStaff,whiteMagician.getEquippedWeapon());
  }

  @Test
  public void equipStaffToDeadWhiteMagicianNoInitialWeapon(){
    assertEquals(NullWeapon.getNullWeapon(),whiteMagician.getEquippedWeapon());
    whiteMagician.setHealthPoints(0);
    whiteMagician.equip(staff);
    assertNotEquals(staff,whiteMagician.getEquippedWeapon());
    assertEquals(NullWeapon.getNullWeapon(),whiteMagician.getEquippedWeapon());
  }
}


package com.github.cc3002.finalreality.model;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.controller.*;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class AbstractSetUpTest {
  private BlackMagician blackMagician;
  private WhiteMagician whiteMagician;
  private Engineer engineer;
  private Knight knight;
  private Thief thief;
  private Enemy enemy;

  private IWeaponKnight axeKnight;
  private IWeaponEngineer axeEngineer;
  private IWeaponEngineer bowEngineer;
  private IWeaponThief bowThief;
  private IWeaponKnight knifeKnight;
  private IWeaponBlack knifeBlack;
  private IWeaponThief staffThief;
  private IWeaponBlack staffBlack;
  private IWeaponWhite staffWhite;
  private IWeaponKnight swordKnight;
  private IWeaponThief swordThief;

  private String BLACK_MAGICIAN_NAME;
  private String WHITE_MAGICIAN_NAME;
  private String ENGINEER_NAME;
  private String KNIGHT_NAME;
  private String THIEF_NAME;
  private String ENEMY_NAME;

  private String AXE_NAME;
  private String BOW_NAME;
  private String KNIFE_NAME;
  private String STAFF_NAME;
  private String SWORD_NAME;

  private int HEALTH_POINTS;
  private int DEFENSE_POINTS;
  private int DAMAGE;
  private int WEIGHT;

  private int ENEMY_WEIGHT;
  private int ENEMY_ATTACK;

  private BlockingQueue<IUnit> turnsQueue;

  private CharacterController characterController;
  private EnemyController enemyController;
  private PlayerController playerController;
  private WeaponController weaponController;
  private FightController fightController;


  @BeforeEach
  public void setUp(){
    BLACK_MAGICIAN_NAME = "Javier";
    WHITE_MAGICIAN_NAME = "Rodrigo";
    ENGINEER_NAME = "Malu";
    KNIGHT_NAME = "Quijote";
    THIEF_NAME = "Andrea";
    ENEMY_NAME = "enemy1";

    AXE_NAME = "Basic Axe";
    BOW_NAME = "Basic Bow";
    KNIFE_NAME = "Basic knife";
    STAFF_NAME = "Basic Staff";
    SWORD_NAME = "Basic Sword";

    HEALTH_POINTS = 10;
    DEFENSE_POINTS = 4;
    DAMAGE = 5;
    WEIGHT = 2;

    ENEMY_WEIGHT = 10;
    ENEMY_ATTACK = 7;

    turnsQueue = new LinkedBlockingQueue<>();

    blackMagician = new BlackMagician(BLACK_MAGICIAN_NAME, turnsQueue, HEALTH_POINTS, DEFENSE_POINTS);
    whiteMagician = new WhiteMagician(WHITE_MAGICIAN_NAME, turnsQueue, HEALTH_POINTS, DEFENSE_POINTS);
    engineer = new Engineer(ENGINEER_NAME, turnsQueue, HEALTH_POINTS, DEFENSE_POINTS);
    knight = new Knight(KNIGHT_NAME, turnsQueue, HEALTH_POINTS, DEFENSE_POINTS);
    thief = new Thief(THIEF_NAME, turnsQueue, HEALTH_POINTS, DEFENSE_POINTS);
    enemy = new Enemy(ENEMY_NAME,ENEMY_WEIGHT,turnsQueue,HEALTH_POINTS,ENEMY_ATTACK,DEFENSE_POINTS);

    axeKnight = new Axe(AXE_NAME, DAMAGE, WEIGHT);
    axeEngineer = new Axe(AXE_NAME, DAMAGE, WEIGHT);
    bowEngineer = new Bow(BOW_NAME, DAMAGE, WEIGHT);
    bowThief = new Bow(BOW_NAME, DAMAGE, WEIGHT);
    knifeKnight = new Knife(KNIFE_NAME, DAMAGE, WEIGHT);
    knifeBlack = new Knife(KNIFE_NAME, DAMAGE, WEIGHT);
    staffThief = new Staff(STAFF_NAME, DAMAGE, WEIGHT);
    staffBlack = new Staff(STAFF_NAME, DAMAGE, WEIGHT);
    staffWhite = new Staff(STAFF_NAME, DAMAGE, WEIGHT);
    swordKnight = new Sword(SWORD_NAME, DAMAGE, WEIGHT);
    swordThief = new Sword(SWORD_NAME, DAMAGE, WEIGHT);

    characterController = new CharacterController();
    enemyController = new EnemyController();
    playerController = new PlayerController();
    weaponController = new WeaponController();
    fightController = new FightController();

  }

  public String getBlackName() {
    return BLACK_MAGICIAN_NAME;
  }

  public void setBlackMagicianName(String BLACK_MAGICIAN_NAME) {
    this.BLACK_MAGICIAN_NAME = BLACK_MAGICIAN_NAME;
  }

  public String getWhiteMagicianName() {
    return WHITE_MAGICIAN_NAME;
  }

  public void setWhiteMagicianName(String WHITE_MAGICIAN_NAME) {
    this.WHITE_MAGICIAN_NAME = WHITE_MAGICIAN_NAME;
  }

  public String getEngineerName() {
    return ENGINEER_NAME;
  }

  public void setEngineerName(String ENGINEER_NAME) {
    this.ENGINEER_NAME = ENGINEER_NAME;
  }

  public String getKnightName() {
    return KNIGHT_NAME;
  }

  public void setKnightName(String KNIGHT_NAME) {
    this.KNIGHT_NAME = KNIGHT_NAME;
  }

  public String getThiefName() {
    return THIEF_NAME;
  }

  public void setThiefName(String THIEF_NAME) {
    this.THIEF_NAME = THIEF_NAME;
  }

  public String getEnemyName(){
    return ENEMY_NAME;
  }

  public int getEnemyWeight(){
    return ENEMY_WEIGHT;
  }
  public String getAxeName() {
    return AXE_NAME;
  }

  public void setAxeName(String AXE_NAME) {
    this.AXE_NAME = AXE_NAME;
  }

  public String getBowName() {
    return BOW_NAME;
  }

  public void setBowName(String BOW_NAME) {
    this.BOW_NAME = BOW_NAME;
  }

  public String getKnifeName() {
    return KNIFE_NAME;
  }

  public void setKnifeName(String KNIFE_NAME) {
    this.KNIFE_NAME = KNIFE_NAME;
  }

  public String getStaffName() {
    return STAFF_NAME;
  }

  public void setStaffName(String STAFF_NAME) {
    this.STAFF_NAME = STAFF_NAME;
  }

  public String getSwordName() {
    return SWORD_NAME;
  }

  public void setSwordName(String SWORD_NAME) {
    this.SWORD_NAME = SWORD_NAME;
  }

  public int getHealthPoints() {
    return HEALTH_POINTS;
  }

  public int getDefensePoints() {
    return DEFENSE_POINTS;
  }


  public int getDamage() {
    return DAMAGE;
  }


  public int getWeight() {
    return WEIGHT;
  }

  public int getEnemyAttack(){
    return ENEMY_ATTACK;
  }


  public BlackMagician getBlackMagician(){
    return blackMagician;
  }

  public Engineer getEngineer(){
    return engineer;
  }

  public Knight getKnight(){
    return knight;
  }

  public Thief getThief(){
    return thief;
  }

  public WhiteMagician getWhiteMagician(){
    return whiteMagician;
  }

  public Enemy getEnemy(){
    return enemy;
  }

  public IWeaponKnight getAxeKnight(){
    return axeKnight;
  }

  public IWeaponEngineer getAxeEngineer(){
    return axeEngineer;
  }

  public IWeaponEngineer getBowEngineer(){
    return bowEngineer;
  }

  public IWeaponThief getBowThief(){
    return bowThief;
  }

  public IWeaponKnight getKnifeKnight(){
    return knifeKnight;
  }

  public IWeaponBlack getKnifeBlack(){
    return knifeBlack;
  }

  public IWeaponThief getStaffThief(){
    return staffThief;
  }
  public IWeaponBlack getStaffBlack(){
    return staffBlack;
  }
  public IWeaponWhite getStaffWhite(){
    return staffWhite;
  }

  public IWeaponKnight getSwordKnight(){
    return swordKnight;
  }
  public IWeaponThief getSwordThief(){
    return swordThief;
  }

  public CharacterController getCharacterController() {
    return characterController;
  }

  public void setHealthPoints(int HEALTH_POINTS) {
    this.HEALTH_POINTS = HEALTH_POINTS;
  }

  public void setDefensePoints(int n){
    this.DEFENSE_POINTS = n;
  }

  public void setDamage(int n){
    this.DAMAGE = n;
  }

  public void setWeight(int WEIGHT) {
    this.WEIGHT = WEIGHT;
  }

  public BlockingQueue<IUnit> getTurnsQueue(){
    return turnsQueue;
  }

  protected PlayerController getPlayerController() {
    return playerController;
  }

  protected WeaponController getWeaponController() {
    return weaponController;
  }

  protected EnemyController getEnemyController() {
    return enemyController;
  }

  protected FightController getFightController() {
    return fightController;
  }
}

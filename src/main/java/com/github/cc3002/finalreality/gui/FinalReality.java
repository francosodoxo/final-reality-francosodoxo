package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.gui.elements.*;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.controller.*;
import com.github.cc3002.finalreality.model.listeners.RefreshLabelCurrentTurn;
import com.github.cc3002.finalreality.model.listeners.RefreshLabelsHealthHandler;
import com.github.cc3002.finalreality.model.weapon.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.concurrent.BlockingQueue;

/**
 * Main entry point for the application.
 * <p>
 * This is a battle between three characters and two enemies.
 *
 * @author Ignacio Slater Muñoz.
 * @author Franco Seguel Lucero
 */
public class FinalReality extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws FileNotFoundException {
    TurnController turnController = new TurnController();
    CharacterController characterController = new CharacterController();
    FightController fightController = new FightController();
    PlayerController playerController = new PlayerController(turnController);
    FlowController flowController = new FlowController(
            playerController,
            turnController);
    playerController.addFlowController(flowController);
    EnemyController enemyController = new EnemyController(turnController,playerController.getAttackToCharacterHandler());
    flowController.addEnemyController(enemyController);
    RefreshLabelsHealthHandler refreshLabelsHealthHandler = new RefreshLabelsHealthHandler();
    flowController.addRefreshLabelListener(refreshLabelsHealthHandler);

    WeaponController weaponController = new WeaponController();
    BlockingQueue<IUnit> turns = turnController.getTurnQueue();
    BlackMagician blackMagician = characterController.createBlack(
            "Kali",
            turns,
            15,
            7
    );
    turnController.add(blackMagician);
    playerController.add(blackMagician);
    Thief thief = characterController.createThief(
            "Debian",
            turns,
            15,
            7
    );
    turnController.add(thief);
    playerController.add(thief);
    Knight knight = characterController.createKnight(
            "Manjaro",
            turns,
            15,
            6
    );
    turnController.add(knight);
    playerController.add(knight);
    WhiteMagician whiteMagician = characterController.createWhite(
            "Solaris",
            turns,
            15,
            6
    );
    turnController.add(whiteMagician);
    playerController.add(whiteMagician);
    Engineer engineer = characterController.createEngineer(
            "Arch",
            turns,
            15,
            6
    );
    turnController.add(engineer);
    playerController.add(engineer);
    Enemy enemy1 = enemyController.createEnemy(
            "The evil Dog",
            10,
            turns,
            15,
            7,
            5
    );
    turnController.add(enemy1);
    Enemy enemy2 = enemyController.createEnemy(
            "The Bloodthirsty Cat",
            10,
            turns,
            15,
            7,
            4
    );
    turnController.add(enemy2);

    Axe axe = weaponController.createAxe(
            "Axe",
            8,
            20);
    Bow bow = weaponController.createBow(
            "Bow",
            8,
            20
    );
    Knife knife = weaponController.createKnife(
            "Knife",
            8,
            20
    );
    Staff staff = weaponController.createStaff(
            "Staff",
            8,
            20
    );
    Sword sword = weaponController.createSword(
            "Sword",
            8,
            20
    );
    flowController.addApplication(this);
    primaryStage.setTitle("Final reality");
    int width = 1280;
    int height = 720;
    int widthObj = 80;
    int heightObj = 120;
    int delta = 20;
    String RESOURCES_PATH = "src/main/java/com/github/cc3002/finalreality/gui/resources/";
    Group playerCharacters = new Group();
    Group enemies = new Group();
    Group info = new Group();
    Group actions = new Group();
    Group weapons = new Group();
    Group mainGroup = new Group();

    //Buttons
    var blackMagView = new UnitElementBuilder(playerCharacters)
            .setImagePath(RESOURCES_PATH +"black_magician.png")
            .setPosition(0, 0)
            .setSize(widthObj,heightObj)
            .build();
    var knightView = new UnitElementBuilder(playerCharacters)
            .setImagePath(RESOURCES_PATH+"knight.png")
            .setPosition(0, heightObj)
            .setSize(widthObj,heightObj)
            .build();
    var thiefView = new UnitElementBuilder(playerCharacters)
            .setImagePath(RESOURCES_PATH+"thief.png")
            .setPosition(0,heightObj * 2)
            .setSize(widthObj,heightObj)
            .build();
    var whiteMagView = new UnitElementBuilder(playerCharacters)
            .setImagePath(RESOURCES_PATH+"whiteMagician.jpeg")
            .setPosition(0,heightObj * 3)
            .setSize(widthObj,heightObj)
            .build();
    var engineerView = new UnitElementBuilder(playerCharacters)
            .setImagePath(RESOURCES_PATH+"engineer.jpeg")
            .setPosition(0,heightObj * 4)
            .setSize(widthObj,heightObj)
            .build();
    var enemy1View=new UnitElementBuilder(enemies)
            .setImagePath(RESOURCES_PATH + "enemy1.png")
            .setPosition(widthObj * 4,0)
            .setSize(widthObj,heightObj)
            .build();
    var enemy2View = new UnitElementBuilder(enemies)
            .setImagePath(RESOURCES_PATH + "enemy2.png")
            .setPosition(widthObj * 4,heightObj)
            .setSize(widthObj, heightObj)
            .build();

    var buttonAttack = new ActionElementBuilder(actions)
            .setPosition(150,200)
            .setText("Attack")
            .build();
    var buttonEquip = new ActionElementBuilder(actions)
            .setPosition(150,250)
            .setText("Equip")
            .build();
    var buttonAxe = new UnitElementBuilder(weapons)
            .setImagePath(RESOURCES_PATH+"axe.jpeg")
            .setPosition(widthObj * 8,0)
            .setSize(widthObj,heightObj)
            .build();
    var buttonBow = new UnitElementBuilder(weapons)
            .setImagePath(RESOURCES_PATH+"bow.jpeg")
            .setPosition(widthObj * 8,heightObj)
            .setSize(widthObj,heightObj)
            .build();
    var buttonKnife = new UnitElementBuilder(weapons)
            .setImagePath(RESOURCES_PATH + "knife.jpeg")
            .setPosition(widthObj * 8 ,heightObj * 2)
            .setSize(widthObj,heightObj)
            .build();
    var buttonStaff = new UnitElementBuilder(weapons)
            .setImagePath(RESOURCES_PATH + "staff.jpeg")
            .setPosition(widthObj * 8,heightObj * 3)
            .setSize(widthObj,heightObj)
            .build();
    var buttonSword = new UnitElementBuilder(weapons)
            .setImagePath(RESOURCES_PATH + "sword.png")
            .setPosition(widthObj * 8,heightObj * 4)
            .setSize(widthObj,heightObj)
            .build();
    //Labels
    var labelBlackLife = new LabelElementBuilder(playerCharacters)
            .setPosition(widthObj,0)
            .setText("HP:"+characterController.getHealthPoints(characterController.getName(blackMagician)))
            .build();
    var labelBlackName = new LabelElementBuilder(playerCharacters)
            .setPosition(widthObj,20)
            .setText(characterController.getName(blackMagician))
            .build();
    var labelKnightLife = new LabelElementBuilder(playerCharacters)
            .setPosition(widthObj,heightObj)
            .setText("HP:" +characterController.getHealthPoints(characterController.getName(knight)))
            .build();
    var labelKnightName = new LabelElementBuilder(playerCharacters)
            .setPosition(widthObj,heightObj + 20)
            .setText(characterController.getName(knight))
            .build();
    var labelThiefLife = new LabelElementBuilder(playerCharacters)
            .setPosition(widthObj,heightObj * 2)
            .setText("HP:"+characterController.getHealthPoints(characterController.getName(thief)))
            .build();
    var labelThiefName = new LabelElementBuilder(playerCharacters)
            .setPosition(widthObj,heightObj * 2 + delta)
            .setText(characterController.getName(thief))
            .build();
    var labelWhiteLife = new LabelElementBuilder(playerCharacters)
            .setPosition(widthObj,heightObj * 3)
            .setText("HP: "+characterController.getHealthPoints(characterController.getName(whiteMagician)))
            .build();
    var labelWhiteName= new LabelElementBuilder(playerCharacters)
            .setPosition(widthObj,heightObj * 3 + delta)
            .setText(characterController.getName(whiteMagician))
            .build();
    var labelEngineerLife = new LabelElementBuilder(playerCharacters)
            .setPosition(widthObj,heightObj * 4)
            .setText("HP: "+characterController.getHealthPoints(characterController.getName(engineer)))
            .build();
    var labelEngineerName = new LabelElementBuilder(playerCharacters)
            .setPosition(widthObj,heightObj * 4 + delta)
            .setText(characterController.getName(engineer))
            .build();
    var labelEnemy1Life = new LabelElementBuilder(playerCharacters)
            .setPosition(widthObj * 5,0)
            .setText("HP:"+enemyController.getHealthPoints(enemyController.getName(enemy1)))
            .build();
    var labelEnemy1Name = new LabelElementBuilder(playerCharacters)
            .setPosition(widthObj * 5,delta)
            .setText(enemyController.getName(enemy1))
            .build();
    var labelEnemy2Life = new LabelElementBuilder(playerCharacters)
            .setPosition(widthObj * 5,heightObj)
            .setText("HP:" +enemyController.getHealthPoints(enemyController.getName(enemy2)))
            .build();
    var labelEnemy2Name = new LabelElementBuilder(playerCharacters)
            .setPosition(widthObj *5,heightObj + delta)
            .setText(enemyController.getName(enemy2))
            .build();
    var labelCurrentTurn = new LabelElementBuilder(actions)
            .setPosition(300,350)
            .setText("Current turn: "+turnController.getUnit().getName())
            .build();
    refreshLabelsHealthHandler.addLabel(characterController.getName(blackMagician),labelBlackLife);
    refreshLabelsHealthHandler.addLabel(enemyController.getName(enemy1),labelEnemy1Life);
    refreshLabelsHealthHandler.addLabel(enemyController.getName(enemy2),labelEnemy2Life);
    refreshLabelsHealthHandler.addLabel(characterController.getName(engineer),labelEngineerLife);
    refreshLabelsHealthHandler.addLabel(characterController.getName(knight),labelKnightLife);
    refreshLabelsHealthHandler.addLabel(characterController.getName(thief),labelThiefLife);
    refreshLabelsHealthHandler.addLabel(characterController.getName(whiteMagician),labelWhiteLife);

    RefreshLabelCurrentTurn refreshLabelCurrentTurn = new RefreshLabelCurrentTurn();
    refreshLabelCurrentTurn.addLabel(labelCurrentTurn);
    playerController.addFlowController(flowController);
    flowController.addRefreshLabelCurrentTurnListener(refreshLabelCurrentTurn);

    mainGroup.getChildren().add(enemies);
    mainGroup.getChildren().add(playerCharacters);
    mainGroup.getChildren().add(info);
    mainGroup.getChildren().add(actions);
    mainGroup.getChildren().add(weapons);

    blackMagView.setButtonAction(actionEvent -> flowController.setTarget(blackMagician));

    knightView.setButtonAction(actionEvent -> flowController.setTarget(knight));

    thiefView.setButtonAction(actionEvent -> flowController.setTarget(thief));

    whiteMagView.setButtonAction(actionEvent -> flowController.setTarget(whiteMagician));

    engineerView.setButtonAction(actionEvent -> flowController.setTarget(engineer));

    enemy1View.setButtonAction(actionEvent -> flowController.setTarget(enemy1));

    enemy2View.setButtonAction(actionEvent -> flowController.setTarget(enemy2));

    buttonAttack.setButtonAction(actionEvent -> {
      flowController.doAttackAction();
    });

    buttonEquip.setButtonAction(actionEvent -> flowController.equip());

    buttonAxe.setButtonAction(actionEvent -> flowController.setWeapon(axe));

    buttonBow.setButtonAction(actionEvent -> flowController.setWeapon(bow));

    buttonKnife.setButtonAction(actionEvent -> flowController.setWeapon(knife));

    buttonStaff.setButtonAction(actionEvent -> flowController.setWeapon(staff));

    buttonSword.setButtonAction(actionEvent -> flowController.setWeapon(sword));

    flowController.run();
    /*Label label = new Label("This will be a game sometime");
    label.setAlignment(Pos.CENTER);
    */
    // This sets the size of the Scene to be 400px wide, 200px high
    Scene scene = new Scene(mainGroup, width, height);

    primaryStage.setScene(scene);

    primaryStage.show();
  }
}
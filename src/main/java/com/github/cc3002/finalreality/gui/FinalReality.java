package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.gui.actions.AttackAction;
import com.github.cc3002.finalreality.gui.actions.EquipAction;
import com.github.cc3002.finalreality.gui.elements.*;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.character.player.BlackMagician;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.controller.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.FileNotFoundException;
import java.util.Queue;
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
    EnemyController enemyController = new EnemyController();
    PlayerController playerController = new PlayerController();
    FightController fightController = new FightController();
    BlockingQueue<IUnit> turns = turnController.getTurnQueue();
    BlackMagician blackMagician = characterController.createBlack(
            "Kali",
            turns,
            15,
            7
    );
    turnController.add(blackMagician);
    Thief thief = characterController.createThief(
            "Debian",
            turns,
            15,
            7
    );
    turnController.add(thief);
    Knight knight = characterController.createKnight(
            "Manjaro",
            turns,
            15,
            6
    );
    turnController.add(knight);
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
    FlowController flowController = new FlowController(enemyController,playerController,turnController);
    primaryStage.setTitle("Final reality");
    int width = 1280;
    int height = 720;
    String RESOURCES_PATH = "src/main/java/com/github/cc3002/finalreality/gui/resources/";
    Group playerCharacters = new Group();
    Group enemies = new Group();
    Group info = new Group();
    Group actions = new Group();
    Group mainGroup = new Group();
    var blackMagView = new UnitElementBuilder(playerCharacters)
            .setImagePath(RESOURCES_PATH +"black_magician.png")
            .setPosition(0,0)
            .setSize(150,200)
            .build();
    var knightView = new UnitElementBuilder(playerCharacters)
            .setImagePath(RESOURCES_PATH+"knight.png")
            .setPosition(0,200)
            .setSize(150,200)
            .build();
    var thiefView = new UnitElementBuilder(playerCharacters)
            .setImagePath(RESOURCES_PATH+"thief.png")
            .setPosition(0,400)
            .setSize(150,200)
            .build();
    var enemy1View=new UnitElementBuilder(enemies)
            .setImagePath(RESOURCES_PATH + "enemy1.png")
            .setPosition(500,0)
            .setSize(150,200)
            .build();
    var enemy2View = new UnitElementBuilder(enemies)
            .setImagePath(RESOURCES_PATH + "enemy2.png")
            .setPosition(500,200)
            .setSize(150,200)
            .build();

    var buttonAttack = new ActionElementBuilder(actions)
            .setPosition(300,200)
            .setText("Attack")
            .build();
    var buttonEquip = new ActionElementBuilder(actions)
            .setPosition(300,250)
            .setText("Equip")
            .build();
    var buttonOk = new ActionElementBuilder(actions)
            .setPosition(300,300)
            .setText("OK")
            .build();
    var labelBlackLife = new LabelElementBuilder(playerCharacters)
            .setPosition(0,0)
            .setText("HP:"+characterController.getHealthPoints(characterController.getName(blackMagician)))
            .build();
    var labelBlackName = new LabelElementBuilder(playerCharacters)
            .setPosition(0,50)
            .setText(characterController.getName(blackMagician))
            .build();
    var labelKnightLife = new LabelElementBuilder(playerCharacters)
            .setPosition(0,200)
            .setText("HP:" +characterController.getHealthPoints(characterController.getName(knight)))
            .build();
    var labelKnightName = new LabelElementBuilder(playerCharacters)
            .setPosition(0,250)
            .setText(characterController.getName(knight))
            .build();
    var labelThiefLife = new LabelElementBuilder(playerCharacters)
            .setPosition(0,400)
            .setText("HP:"+characterController.getHealthPoints(characterController.getName(thief)))
            .build();
    var labelThiefName = new LabelElementBuilder(playerCharacters)
            .setPosition(0,450)
            .setText(characterController.getName(thief))
            .build();
    var labelEnemy1Life = new LabelElementBuilder(playerCharacters)
            .setPosition(500,0)
            .setText("HP:"+enemyController.getHealthPoints(enemyController.getName(enemy1)))
            .build();
    var labelEnemy2Life = new LabelElementBuilder(playerCharacters)
            .setPosition(500,200)
            .setText("HP:" +enemyController.getHealthPoints(enemyController.getName(enemy2)));
    var labelCurrentTurn = new LabelElementBuilder(actions)
            .setPosition(300,350)
            .setText("Current turn: "+turnController.getUnit().getName())
            .build();
    mainGroup.getChildren().add(enemies);
    mainGroup.getChildren().add(playerCharacters);
    mainGroup.getChildren().add(info);
    mainGroup.getChildren().add(actions);

    enemy1View.setButtonAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        flowController.setTarget(enemy1);
      }
    });
    enemy2View.setButtonAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        flowController.setTarget(enemy2);
      }
    });

    buttonAttack.setButtonAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        flowController.setAction(new AttackAction(fightController));
      }
    });

    buttonEquip.setButtonAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        flowController.setAction(new EquipAction());
      }
    });

    buttonOk.setButtonAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        flowController.doAction();
        labelBlackLife.setText("HP:"+characterController.getHealthPoints(characterController.getName(blackMagician)));
        labelKnightLife.setText("HP:"+characterController.getHealthPoints(characterController.getName(knight)));
        labelThiefLife.setText("HP:"+characterController.getHealthPoints(characterController.getName(thief)));
      }
    });
    /*Label label = new Label("This will be a game sometime");
    label.setAlignment(Pos.CENTER);
    */
    // This sets the size of the Scene to be 400px wide, 200px high
    Scene scene = new Scene(mainGroup, width, height);

    primaryStage.setScene(scene);

    primaryStage.show();
  }
}
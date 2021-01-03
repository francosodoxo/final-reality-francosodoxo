package com.github.cc3002.finalreality.model.states;

import com.github.cc3002.finalreality.gui.elements.LabelElement;
import com.github.cc3002.finalreality.gui.elements.LabelElementBuilder;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

class WinGame extends Application {
  int width = 100;
  int height = 100;
  Group node =  new Group();
  LabelElement winLabel = new LabelElementBuilder(node)
          .setPosition(0,0)
          .setText("YOU WIN THE GAME! YOU'RE A GOD")
          .build();
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    Scene scene = new Scene(node, width, height);
    stage.setScene(scene);
    stage.show();
  }
}

/**
 * Represents a player's win
 */
public class PlayerWinsState implements IGameState{

  public PlayerWinsState(){
    new Thread(){
      @Override
      public void run(){
        Application.launch(WinGame.class);
      }
    }.start();
  }

  @Override
  public boolean equals(Object o){
    return o instanceof PlayerWinsState;
  }

  /**
   * Only for finishing the game
   * @return
   */
  @Override
  public IGameState goToPlayerWins() {
    return null;
  }

  /**
   * Only for finishing the game
   * @return
   */
  @Override
  public IGameState goToPlayerLoses() {
    return null;
  }

}

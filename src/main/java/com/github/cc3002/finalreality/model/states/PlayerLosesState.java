package com.github.cc3002.finalreality.model.states;

import com.github.cc3002.finalreality.gui.elements.LabelElement;
import com.github.cc3002.finalreality.gui.elements.LabelElementBuilder;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

class LoseGame extends Application {
  int width = 100;
  int height = 100;
  Group node = new Group();
  LabelElement loseLabel = new LabelElementBuilder(node)
          .setPosition(0,0)
          .setText("Sorry, you did your best")
          .build();
  public static void main(String[] args) {
    //launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    Scene scene = new Scene(node, width,height);
    stage.setScene(scene);
    stage.show();
  }
}
/**
 * Represents a player lose.
 */
public class PlayerLosesState implements IGameState {

  public PlayerLosesState(){
    new Thread(){
      @Override
      public void run(){
        try {
          new LoseGame().start(new Stage());
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }.start();
  }

  @Override
  public boolean equals(Object o){
    return o instanceof PlayerLosesState;
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

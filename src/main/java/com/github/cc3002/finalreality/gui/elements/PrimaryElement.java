package com.github.cc3002.finalreality.gui.elements;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class PrimaryElement {
  private final Group node;
  private int hpos, vpos, width, height;
  private Button button;

  public PrimaryElement(Group node,
                         int hpos,
                         int vpos){
    this.node= node;
    this.hpos = hpos;
    this.vpos = vpos;
    button = new Button();
    button.setLayoutX(hpos);
    button.setLayoutY(vpos);
    node.getChildren().add(button);
  }

  public void setButtonGraphic(ImageView sprite){
    button.setGraphic(sprite);
  }

  public void setButtonText(String text){
    button.setText(text);
  }

  public void setButtonAction(EventHandler<ActionEvent> event) {
    button.setOnAction(event);
  }
}

package com.github.cc3002.finalreality.gui.elements;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.control.Label;

public class LabelElement{
  private Group node;
  private int hpos,vpos;
  private Label label;
  private String text;
  public LabelElement(Group node,
                      int hpos,
                      int vpos,
                      String text){
    this.node = node;
    this.hpos = hpos;
    this.vpos = vpos;
    this.text = text;
    label = new Label();
    label.setText(text);
    label.setLayoutX(hpos);
    label.setLayoutY(vpos);
    this.node.getChildren().add(label);
    startAnimator();
  }

  private void startAnimator(){
    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(long l) {
        label.setText(text);
      }
    };
    timer.start();
  }

  public void setText(String text){
    this.text = text;
  }
}

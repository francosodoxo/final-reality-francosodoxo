package com.github.cc3002.finalreality.gui.elements;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;

public class ActionElement extends PrimaryElement{
  public ActionElement(Group node,
                       int hpos,
                       int vpos,
                       String text) {
  super(node,hpos,vpos);
  setButtonText(text);
  }

  public void setAction(EventHandler<ActionEvent> event){
    super.setButtonAction(event);
  }

}

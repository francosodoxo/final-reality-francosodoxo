package com.github.cc3002.finalreality.gui.elements;

import javafx.scene.Group;

public class ActionElementBuilder {
  private final Group node;
  private int hpos,vpos;
  private String text;

  public ActionElementBuilder(Group node) {
    this.node = node;
  }

  public ActionElementBuilder setPosition(int hpos, int vpos){
    this.hpos = hpos;
    this.vpos = vpos;
    return this;
  }

  public ActionElementBuilder setText(String text){
    this.text = text;
    return this;
  }
  public ActionElement build(){
    return new ActionElement(node,hpos,vpos, text);
  }
}

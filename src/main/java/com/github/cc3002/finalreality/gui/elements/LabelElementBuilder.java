package com.github.cc3002.finalreality.gui.elements;

import javafx.scene.Group;

public class LabelElementBuilder {
  private Group node;
  private int hpos, vpos;
  private String text;
  public LabelElementBuilder(Group node) {
    this.node = node;
  }

  public LabelElementBuilder setPosition(int hpos,int vpos){
    this.hpos = hpos;
    this.vpos = vpos;
    return this;
  }

  public LabelElementBuilder setText(String text){
    this.text = text;
    return this;
  }

  public LabelElement build(){
    return new LabelElement(node,hpos,vpos,text);
  }
}

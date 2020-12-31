package com.github.cc3002.finalreality.gui.elements;

import javafx.scene.Group;


import java.io.FileNotFoundException;

public class UnitElementBuilder {
  private final Group node;
  private String imagePath;
  private int hpos,vpos,width,height;

  public UnitElementBuilder(Group node){
    this.node = node;
  }
  public UnitElementBuilder setPosition(int hpos, int vpos){
    this.hpos = hpos;
    this.vpos = vpos;
    return this;
  }

  public UnitElementBuilder setSize(int width, int height){
    this.width = width;
    this.height = height;
    return this;
  }

  public UnitElementBuilder setImagePath(String path){
    this.imagePath = path;
    return this;
  }

  public UnitElement build() throws FileNotFoundException{
    return new UnitElement(node, hpos, vpos,height,width,imagePath);
  }
}

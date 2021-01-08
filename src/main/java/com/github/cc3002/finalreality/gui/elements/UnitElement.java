package com.github.cc3002.finalreality.gui.elements;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class UnitElement extends PrimaryElement {
  private ImageView sprite;
  private int imgWidth, imgHeight;

  public UnitElement(Group node, int hpos, int vpos, int imgHeight, int imgWidth, String imagePath)
  throws FileNotFoundException {
    super(node,hpos,vpos);
    this.imgWidth = imgWidth;
    this.imgHeight = imgHeight;
    addSprite(imagePath);
  }

  private void addSprite(final String imagePath) throws FileNotFoundException{
    FileInputStream spriteImage = new FileInputStream(imagePath);
    sprite = new ImageView(new Image(spriteImage));
    sprite.setFitHeight(imgHeight);
    sprite.setFitWidth(imgWidth);
    setButtonGraphic(sprite);
  }
}

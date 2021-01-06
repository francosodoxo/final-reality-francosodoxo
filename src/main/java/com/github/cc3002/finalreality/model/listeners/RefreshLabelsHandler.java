package com.github.cc3002.finalreality.model.listeners;

import com.github.cc3002.finalreality.gui.elements.LabelElement;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.controller.CharacterController;
import com.github.cc3002.finalreality.model.controller.EnemyController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;

public class RefreshLabelsHandler implements PropertyChangeListener {

  private HashMap<String,LabelElement> labels;
  private CharacterController characterController;
  private EnemyController enemyController;

  public RefreshLabelsHandler(CharacterController characterController,
                              EnemyController enemyController){
    this.characterController = characterController;
    this.enemyController = enemyController;
    labels = new HashMap<>();
  }

  public void addLabel(String characterName,LabelElement labelElement){
    labels.put(characterName,labelElement);
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    IUnit target = (IUnit) evt.getNewValue();
    LabelElement label = labels.get(target.getName());
    label.setText("HP: "+target.getHealthPoints());
  }
}

package com.github.cc3002.finalreality.model.listeners;

import com.github.cc3002.finalreality.gui.elements.LabelElement;
import com.github.cc3002.finalreality.model.controller.CharacterController;
import com.github.cc3002.finalreality.model.controller.EnemyController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class RefreshLabelsHandler implements PropertyChangeListener {

  private ArrayList<LabelElement> labels;
  private CharacterController characterController;
  private EnemyController enemyController;

  public RefreshLabelsHandler(CharacterController characterController,
                              EnemyController enemyController){
    this.characterController = characterController;
    this.enemyController = enemyController;
    labels = new ArrayList<>();
  }

  public void addLabel(LabelElement labelElement){
    labels.add(labelElement);
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    for(var label: labels){

    }
  }
}

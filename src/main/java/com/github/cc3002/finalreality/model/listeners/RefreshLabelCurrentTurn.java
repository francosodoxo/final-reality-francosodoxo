package com.github.cc3002.finalreality.model.listeners;

import com.github.cc3002.finalreality.gui.elements.LabelElement;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.controller.FlowController;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class RefreshLabelCurrentTurn implements PropertyChangeListener {
  private LabelElement labelCurrent;

  public void addLabel(LabelElement labelElement){
    this.labelCurrent = labelElement;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    IUnit current = (IUnit) evt.getNewValue();
    labelCurrent.setText(current.getName());
  }
}

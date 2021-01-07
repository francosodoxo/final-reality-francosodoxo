package com.github.cc3002.finalreality.model.listeners;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.controller.FightController;
import com.github.cc3002.finalreality.model.controller.FlowController;
import com.github.cc3002.finalreality.model.controller.PlayerController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.Flow;

public class AttackToCharacterHandler implements PropertyChangeListener {
  private PlayerController playerController;
  private FlowController flowController;

  public AttackToCharacterHandler(PlayerController playerController,
                                  FlowController flowController){
    this.playerController = playerController;
    this.flowController = flowController;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    Enemy enemy = (Enemy) evt.getNewValue();
    ICharacter character = playerController.chooseCharacter();
    flowController.setTarget((IUnit) character);
    try {
      Thread.sleep(1000);
      System.out.println("Atacando");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    flowController.doAttackAction();
  }
}

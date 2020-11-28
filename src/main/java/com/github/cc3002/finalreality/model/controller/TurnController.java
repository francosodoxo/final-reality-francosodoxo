package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.character.player.BlackMagician;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TurnController {
  private final BlockingQueue<IUnit> turns;

  public TurnController(){
    turns = new LinkedBlockingQueue<>();
  }

  public IUnit getUnit(){
    return turns.poll();
  }

  public void waitTurn(IUnit unit){
    unit.waitTurn();
  }

  public boolean waitInput(IUnit fromQueue) {
    return true;
  }

  public BlockingQueue<IUnit> getTurnQueue() {
    return turns;
  }
}

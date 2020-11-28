package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.character.player.BlackMagician;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TurnController {
  private final BlockingQueue<IUnit> turns;

  /**
   * Class to manage the player's turn
   */
  public TurnController(){
    turns = new LinkedBlockingQueue<>();
  }

  /**
   * Get a unit form the turns queue
   * @return
   */
  public IUnit getUnit(){
    return turns.poll();
  }

  /**
   * Makes a unit wait their turn
   * @param unit
   */
  public void waitTurn(IUnit unit){
    unit.waitTurn();
  }

  /**
   * Perform the user interactions in this turn
   * @param fromQueue
   * @return
   */
  public boolean waitInput(IUnit fromQueue) {
    return true;
  }

  /**
   * Get the turns queue
   * @return
   */
  public BlockingQueue<IUnit> getTurnQueue() {
    return turns;
  }
}

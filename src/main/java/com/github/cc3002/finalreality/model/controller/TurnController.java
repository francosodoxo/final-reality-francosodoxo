package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.character.player.BlackMagician;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TurnController {
  private final BlockingQueue<IUnit> turns;
  private IUnit current;

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
    current = turns.poll();
    current.isPlayable();
    return current;
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
  public boolean waitInput(IUnit fromQueue){
    return true; //here the unit attacks or makes an spell through an interaction that is pending to
    //implement
  }

  /**
   * Get the turns queue
   * @return
   */
  public BlockingQueue<IUnit> getTurnQueue() {
    return turns;
  }

  public void add(IUnit unit) {
    turns.add(unit);
    unit.setTurnsQueue(this.turns);
  }

  public IUnit getCurrent(){
    return current;
  }

  public void deleteEnemy(Enemy enemy){
    turns.remove(enemy);
  }

  public void deleteCharacter(ICharacter character) {
    turns.remove((IUnit) character);
  }
}

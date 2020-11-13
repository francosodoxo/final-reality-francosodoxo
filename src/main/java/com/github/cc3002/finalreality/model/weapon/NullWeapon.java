package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;

/**
 * Handle null weapons
 * */
public class NullWeapon extends AbstractWeapon implements IWeapon, IWeaponEngineer,IWeaponBlack, IWeaponKnight,IWeaponWhite, IWeaponThief {
  private static NullWeapon nullWeapon;
  private ICharacter character;
  /**
   * Private constructor only called inside this class
   * */
  private NullWeapon() {
    super();
  }

  /**
   * Only one instace of this object
   * */
  @Override
  public IWeapon copy() {
    return nullWeapon;
  }

  /**
   * Returns the same weapon instance
   * */
  public static NullWeapon getNullWeapon(){
    if(nullWeapon == null) {
      nullWeapon = new NullWeapon();
    }
    return nullWeapon;
  }

  @Override
  public void equippedByBlackMagician(BlackMagician blackMagician) {
    blackMagician.setEquippedWeapon(this);
  }

  @Override
  public void equippedByEngineer(Engineer engineer) {
    engineer.setEquippedWeapon(this);
  }

  @Override
  public void equippedByKnight(Knight knight) {
    knight.setEquippedWeapon(this);
  }

  @Override
  public void equippedByThief(Thief thief) {
    thief.setEquippedWeapon(this);
  }

  @Override
  public void equippedByWhite(WhiteMagician whiteMagician) {
    whiteMagician.setEquippedWeapon(this);
  }
}

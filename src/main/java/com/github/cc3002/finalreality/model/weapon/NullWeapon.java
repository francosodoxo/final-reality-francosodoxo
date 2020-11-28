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

  /**
   * Tells the black magician to equip this weapon
   * @param blackMagician
   */
  @Override
  public void equippedByBlackMagician(BlackMagician blackMagician) {
    blackMagician.setEquippedWeapon(this);
  }

  /**
   * Tells the enigneer to equip this weapon
   * @param engineer
   */
  @Override
  public void equippedByEngineer(Engineer engineer) {
    engineer.setEquippedWeapon(this);
  }

  /**
   * Tells the knight to equip this weapon
   * @param knight
   */
  @Override
  public void equippedByKnight(Knight knight) {
    knight.setEquippedWeapon(this);
  }

  /**
   * Tells the thief to equip this weapon
   * @param thief
   */
  @Override
  public void equippedByThief(Thief thief) {
    thief.setEquippedWeapon(this);
  }

  /**
   * Tells the white magician to equip this weapon
   * @param whiteMagician
   */
  @Override
  public void equippedByWhite(WhiteMagician whiteMagician) {
    whiteMagician.setEquippedWeapon(this);
  }
}

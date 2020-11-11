package gear;

/**
 * Gear interface.
 */
public interface Gear {
  /**
   * @return String
   */
  String getAdjective();

  /**
   * @return String
   */
  String getNoun();

  int getAttackVal();

  int getDefenseVal();

  /**
   * @param g Gear
   * @return Gear
   */
  Gear combine(Gear g);

  /**
   * Compare two gears and return a better one.
   * @param g Gear
   * @return Gear
   */
  Gear compare(Gear g);

}

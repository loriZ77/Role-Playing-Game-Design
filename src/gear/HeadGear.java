package gear;

/**
 * HeadGear class extends abstract Gear class.
 */
public class HeadGear extends AbstractGear {
  public HeadGear(String adj, String noun, int defenseVal, boolean isCombined) {
    super(adj, noun, 0, defenseVal, isCombined);
    if (defenseVal < 0) {
      throw new IllegalArgumentException("Invalid defense value!");
    }
    if (adj == null || noun == null) {
      throw new IllegalArgumentException("Invalid gear name!");
    }
  }


  public Gear combine(Gear g) {
    throw new IllegalArgumentException("Head Gear cannot be combined!");
  }

  @Override
  public String toString() {
    return String.format(" %s %s -- Defense Value: %d", getAdjective(), getNoun(), getDefenseVal());
  }
}

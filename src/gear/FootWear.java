package gear;

/**
 * FootWear class extends abstract Gear class.
 */
public class FootWear extends AbstractGear {
  public FootWear(String adj, String noun, int attackVal, int defenseVal, boolean isCombined) {
    super(adj, noun, attackVal, defenseVal, isCombined);
    if (attackVal < 0) {
      throw new IllegalArgumentException("Invalid attack value!");
    }
    if (defenseVal < 0) {
      throw new IllegalArgumentException("Invalid defense value!");
    }
    if (adj == null || noun == null) {
      throw new IllegalArgumentException("Invalid gear name!");
    }
  }

  @Override
  public Gear combine(Gear g) {
    if (g instanceof FootWear) {
      if (this.isCombined || ((FootWear) g).isCombined) {
        throw new IllegalArgumentException("This gear is already combined before!");
      }
      FootWear combinedFootWear =
          new FootWear(this.getAdjective(), ((FootWear) g).adjective + " " + ((FootWear) g).noun,
              this.getAttackVal() + g.getAttackVal(), this.getDefenseVal() + g.getDefenseVal(),
              true);
      return combinedFootWear;
    }
    //g is other type
    throw new IllegalArgumentException("Cannot combine different types!");
  }

  @Override
  public String toString() {
    return String.format(" %s %s -- Attack Value: %d -- Defense Value: %d", this.getAdjective(),
            this.noun, this.getAttackVal(), this.getDefenseVal());
  }
}

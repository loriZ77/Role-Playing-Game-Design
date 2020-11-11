package gear;

/**
 * HandGear class extends abstract Gear class.
 */
public class HandGear extends AbstractGear {
  public HandGear(String adj, String noun, int attackVal, boolean isCombined) {
    super(adj, noun, attackVal, 0, isCombined);
    if (attackVal < 0) {
      throw new IllegalArgumentException("Invalid attack value!");
    }
    if (adj == null || noun == null) {
      throw new IllegalArgumentException("Invalid gear name!");
    }
  }

  public Gear combine(Gear g) {
    if (g instanceof HandGear) {
      //bug here: forget to check this.combined
      if (this.isCombined || ((HandGear) g).isCombined) {
        throw new IllegalArgumentException("This gear is already combined before!");
      }
      HandGear combinedHandGear =
          new HandGear(this.getAdjective(), ((HandGear) g).adjective + " " + ((HandGear) g).noun,
              this.getAttackVal() + g.getAttackVal(), true);
      return combinedHandGear;
    }
    //g is other type
    throw new IllegalArgumentException("Cannot combine different types!");
  }

  @Override
  public String toString() {
    return String.format(" %s %s -- Attack Value: %d", this.getAdjective(), this.getNoun(),
        this.getAttackVal());
  }
}

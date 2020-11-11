package gear;

/**
 * Abstract class implements Gear interface.
 */
public class AbstractGear implements Gear {
  protected final String adjective;
  protected final String noun;
  protected final int attackModifier;
  protected final int defenseModifier;
  // check the gear can be used for combining
  protected final boolean isCombined;

  public AbstractGear(String adj, String noun, int attackVal, int defenseVal, boolean isCombined) {
    this.adjective = adj;
    this.noun = noun;
    this.attackModifier = attackVal;
    this.defenseModifier = defenseVal;
    this.isCombined = isCombined;
  }

  @Override
  public String toString() {
    return "";
  }

  @Override
  public String getAdjective() {
    return this.adjective;
  }

  @Override
  public String getNoun() {
    return this.noun;
  }

  @Override
  public int getAttackVal() {
    return this.attackModifier;
  }

  @Override
  public int getDefenseVal() {
    return this.defenseModifier;
  }

  @Override
  public Gear combine(Gear g) {
    return null;
  }

  public Gear compare(Gear g) {
    int totalPoints = this.getAttackVal() + this.getDefenseVal();
    int otherTotalPoints = g.getAttackVal() + g.getDefenseVal();
    if (totalPoints > otherTotalPoints) {
      return this;
    } else if (totalPoints < otherTotalPoints) {
      return g;
    } else {
      return this.getAttackVal() > g.getAttackVal() ? this : g;
    }

  }

}

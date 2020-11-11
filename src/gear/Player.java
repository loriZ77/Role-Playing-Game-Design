package gear;

import java.util.ArrayList;

/**
 * This class define the players in the game.
 */
public class Player {
  private String name;
  private final static int HEAD_GEAR_CAP = 1;
  private final static int HAND_GEAR_CAP = 2;
  private final static int FOOT_WEAR_CAP = 2;
  private ArrayList<Gear> HeadGears = new ArrayList<>();
  private ArrayList<Gear> HandGears = new ArrayList<>();
  private ArrayList<Gear> FootWears = new ArrayList<>();
  private final int attackBase;
  private final int defenseBase;
  private int attackStrength;
  private int defenseStrength;

  public Player(String name, int attackBase, int defenseBase) {
    if (attackBase < 0 || defenseBase < 0) {
      throw new IllegalArgumentException("Invalid base number!");
    }
    this.name = name;
    this.attackBase = attackBase;
    this.defenseBase = defenseBase;
    this.attackStrength = this.attackBase;
    this.defenseStrength = this.defenseBase;
  }

  public void pickupGear(Gear g) {
    // Whole pick up process:
    // add `g` to one of the player's gears depending on the
    // type of the gear.
    // If the existing number of this particular type of gear has reached
    // the corresponding cap, try to invoke combine() to combine one of
    // the existing gears and `g`.
    // If combine fails, discard `g` or the least powerful existing gear
    // to make space for `g`.
    // Pick up head gear.
    if (g instanceof HeadGear) {
      if (numOfHeadGears() == HEAD_GEAR_CAP) {
        try {
          HeadGear combinedHeadGear = (HeadGear) HandGears.get(0).combine(g);
        } catch (Exception e) {
          // If combine fails, get the better gear between `g` and existing gear using compare method.
          // Because the combined gear was put at 0 index, replace the better gear at 0 index.
          HeadGear betterHeadWear = (HeadGear) HeadGears.get(0).compare(g);
          HeadGears.set(0, betterHeadWear);
          this.attackStrength += betterHeadWear.getAttackVal();
          this.defenseStrength += betterHeadWear.getDefenseVal();
        }
      } else {
        HeadGears.add(g);
        this.attackStrength += g.getAttackVal();
        this.defenseStrength += g.getDefenseVal();
      }

    }
    //Pick up hand gear process.
    if (g instanceof HandGear) {
      if (numOfHandGears() < HAND_GEAR_CAP) {
        HandGears.add(g);
        this.attackStrength += g.getAttackVal();
        this.defenseStrength += g.getDefenseVal();
      }
      // If the existing number of this particular type of gear has reached
      // the corresponding cap, try to invoke combine() to combine the existing gears and `g`.
      // Both total strengths remain the same.
      if (numOfHandGears() == HAND_GEAR_CAP) {
        try {
          HandGear combinedHandGear = (HandGear) HandGears.get(0).combine(HandGears.get(1));
          HandGears.set(0, combinedHandGear);
          //bug: after combination, empty the slot for next pick up.
          HandGears.remove(1);
          this.attackStrength += g.getAttackVal();
          this.defenseStrength += g.getDefenseVal();
        } catch (Exception e) {
          // If combine fails, get the better gear between `g` and existing gear using compare method.
          // Because the combined gear was put at 0 index, replace the better gear at 1 index.
          HandGear betterHandGear = (HandGear) HandGears.get(1).compare(g);
          HandGears.set(1, betterHandGear);
          this.attackStrength = HandGears.get(0).getAttackVal() + HandGears.get(1).getAttackVal();
          this.defenseStrength = HandGears.get(0).getDefenseVal() + HandGears.get(1).getDefenseVal();
        }
      }
    }
    // Pick up foot wear.
    if (g instanceof FootWear) {
      if (numOfFootWears() < FOOT_WEAR_CAP) {
        FootWears.add(g);
        this.attackStrength += g.getAttackVal();
        this.defenseStrength += g.getDefenseVal();
      }
      // If the existing number of this particular type of gear has reached
      // the corresponding cap, try to invoke combine() to combine the existing gears and `g`.
      // Both total strengths remain the same.
      if (numOfFootWears() == FOOT_WEAR_CAP) {
        try {
          FootWear combinedFootWear = (FootWear) FootWears.get(0).combine(FootWears.get(1));
          FootWears.set(0, combinedFootWear);
          //bug: after combination, empty the slot for next pick up.
          FootWears.remove(1);
          this.attackStrength += g.getAttackVal();
          this.defenseStrength += g.getDefenseVal();
        } catch (Exception e) {
          // If combine fails, get the better gear between `g` and existing gear using compare method.
          // Because the combined gear was put at 0 index, replace the better gear at 1 index.
          FootWear betterFootWear = (FootWear) FootWears.get(1).compare(g);
          FootWears.set(1, betterFootWear);
          this.attackStrength = FootWears.get(0).getAttackVal() + betterFootWear.getAttackVal();
          this.defenseStrength = FootWears.get(0).getDefenseVal() + betterFootWear.getDefenseVal();
        }
      }
    }
  }

  public String getName() {
    return this.name;
  }

  public int getAttackStrength() {
    return this.attackStrength;

  }

  public int getDefenseStrength() {
    return this.defenseStrength;
  }

  public int numOfHeadGears() {
    return this.HeadGears.size();
  }

  public int numOfHandGears() {
    return this.HandGears.size();
  }

  public int numOfFootWears() {
    return this.FootWears.size();
  }



  @Override
  public String toString() {
    if (numOfHeadGears() < 1 || numOfHandGears() < 2 || numOfFootWears() < 2) {
      throw new IllegalArgumentException("You can keep picking up gear!");
    }
    return String.format(
        "Head Gear: %s  \n"
            + "Hand Gear1:%s \nHand Gear2:%s \n"
            + "Foot Wear1:%s \nFoot Wear2:%s \n"
            + "%s has %d attack points and %d defense strength. \n ",

        HeadGears.get(0),
        HandGears.get(0), HandGears.get(1),
        FootWears.get(0), FootWears.get(1),
        this.getName(), this.attackStrength, this.defenseStrength);
  }

}

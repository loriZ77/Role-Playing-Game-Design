package gear;

import java.util.ArrayList;

/**
 * This class starts the battle between two players
 * It will print their information and the winner.
 */
public class Battle {
  private Player p1;
  private Player p2;
  private ArrayList<Gear> choicesForP1;
  private ArrayList<Gear> choicesForP2;
  private int getUnitDamage1;
  private int getUnitDamage2;

  public Battle(Player p1, Player p2, ArrayList<Gear> choices1, ArrayList<Gear> choices2) {
    this.p1 = p1;
    this.p2 = p2;
    Gear headGear1 = new HeadGear("Rabadon", "Deathcap", 6, false);
    Gear headGear2 = new HeadGear("Better", "HeadGear", 8, false);
    choices1.add(headGear1);
    choices1.add(headGear2);
    choices2.add(headGear1);
    choices2.add(headGear2);
    // Create each 4 Head Gears in highest attack value order
    Gear handGear1 = new HandGear("Long", "Sword", 11, false);
    Gear handGear2 = new HandGear("Recurve", "Scepter", 8, false);
    Gear handGear3 = new HandGear("Vampiric", "Scepter", 3, false);
    Gear handGear4 = new HandGear("Long", "Sword", 1, false);
    Gear handGear5 = new HandGear("Haunting", "Guise", 12, false);
    Gear handGear6 = new HandGear("Speedy", "Boot", 7, false);
    Gear handGear7 = new HandGear("Swift", "Tabi", 5, false);
    Gear handGear8 = new HandGear("Ninja", "Tabi", 2, false);
    choices1.add(handGear1);
    choices1.add(handGear2);
    choices1.add(handGear3);
    choices1.add(handGear4);
    choices2.add(handGear5);
    choices2.add(handGear6);
    choices2.add(handGear7);
    choices2.add(handGear8);

    // Create each 4 Foot Wears in highest attack value primary order,
    // and highest defense value in secondary order
    Gear footWear1 = new FootWear("Speedy", "Boot", 5, 8, false);
    Gear footWear2 = new FootWear("Swift", "Tabi", 4, 6, false);
    Gear footWear3 = new FootWear("Ninja", "Tabi", 2, 2, false);
    Gear footWear4 = new FootWear("Speedy", "Boot", 1, 1, false);
    Gear footWear5 = new FootWear("Long", "Sword", 8,2, false);
    Gear footWear6 = new FootWear("Recurve", "Scepter", 6, 5,false);
    Gear footWear7 = new FootWear("Vampiric", "Scepter", 3,7, false);
    Gear footWear8 = new FootWear("Long", "Sword", 1,9, false);
    choices1.add(footWear1);
    choices1.add(footWear2);
    choices1.add(footWear3);
    choices1.add(footWear4);
    choices2.add(footWear5);
    choices2.add(footWear6);
    choices2.add(footWear7);
    choices2.add(footWear8);
    this.choicesForP1 = choices1;
    this.choicesForP2 = choices2;
  }

  void startBattle() {
    // two linearly scans for two players to pick up their items.
    // the process is defines in detail in Player class.
    for (Gear g : choicesForP1) {
      p1.pickupGear(g);
    }
    for (Gear g : choicesForP2) {
      p2.pickupGear(g);
    }

    // print p1 and p2
    // Print out each players name in the fight along with what they are wearing and
    // their attack points and defense strength.
    System.out.println("Player 1:   " + p1.getName());
    System.out.println(p1.toString());
    System.out.println("Player 2:   " + p2.getName());
    System.out.println(p2.toString());
    // if defense if greater, damage will be 0 not negative number.
    getUnitDamage1 = p2.getAttackStrength() < p1.getDefenseStrength() ? 0 :
        p2.getAttackStrength() - p1.getDefenseStrength();
    getUnitDamage2 = p1.getAttackStrength() < p2.getDefenseStrength() ? 0 :
        p1.getAttackStrength() - p2.getDefenseStrength();
    System.out.print("The battle ends with "+ p1.getName() + " having " + getUnitDamage1 + " units of damage -- ");
    System.out.println(p2.getName() + " having " + getUnitDamage2 + " units of damage.");

    // find the winner and print
    if (getUnitDamage1 < getUnitDamage2) {
      System.out.println(p1.getName() + " Wins!");
    } else if (getUnitDamage1 == getUnitDamage2) {
      System.out.println("Tie Game.");
    } else {
      System.out.println(p2.getName() + " Wins!");
    }
  }

}


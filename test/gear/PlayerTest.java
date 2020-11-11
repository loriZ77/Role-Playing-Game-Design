package gear;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * This test class test all the functions in Player class.
 * The pickup function is the most important part in this class.
 */

public class PlayerTest {
  private Player Abby;
  private Player Invalid;
  // Create 2 head gears and gear 2 is named by "better" for testing my pickup and compare method.
  Gear headGear1 = new HeadGear("Rabadon", "Deathcap", 6, false);
  Gear headGear2 = new HeadGear("Better", "HeadGear", 8, false);
  // Create 4 Hand Gears
  Gear handGear1 = new HandGear("Long", "Sword", 11, false);
  Gear handGear2 = new HandGear("Recurve", "Scepter", 8, false);
  Gear handGear3 = new HandGear("Vampiric", "Scepter", 3, false);
  Gear handGear4 = new HandGear("Long", "Sword", 1, false);
  // Create 4 Foot Wears
  Gear footWear1 = new FootWear("Speedy", "Boot", 5, 4, false);
  Gear footWear2 = new FootWear("Swift", "Tabi", 4, 5, false);
  Gear footWear3 = new FootWear("Ninja", "Tabi", 2, 2, false);
  Gear footWear4 = new FootWear("Speedy", "Boot", 1, 1, false);


  @Before
  public void setUp() throws Exception {
    Abby = new Player("Abby", 10, 5);
  }

  @Test
  public void pickupGear() {
    Abby.pickupGear(headGear1);
    Abby.pickupGear(headGear2);
    Abby.pickupGear(handGear1);
    Abby.pickupGear(handGear2);
    Abby.pickupGear(handGear3);
    Abby.pickupGear(handGear4);
    Abby.pickupGear(footWear1);
    Abby.pickupGear(footWear2);
    Abby.pickupGear(footWear3);
    Abby.pickupGear(footWear4);
    String expected = "Head Gear:  Better HeadGear -- Defense Value: 8  \n" +
        "Hand Gear1: Long Recurve Scepter -- Attack Value: 19 \n" +
        "Hand Gear2: Vampiric Scepter -- Attack Value: 3 \n" +
        "Foot Wear1: Speedy Swift Tabi -- Attack Value: 9 -- Defense Value: 9 \n" +
        "Foot Wear2: Ninja Tabi -- Attack Value: 2 -- Defense Value: 2 \n" +
        "Abby has 11 attack points and 11 defense strength. \n" +
        " ";
    System.out.println(Abby.toString());
    assertEquals(expected, Abby.toString());
  }

  @Test
  public void getNameTest() {
    assertEquals("Abby", Abby.getName());
  }

  @Test
  public void getAttackStrengthTest() {
    assertEquals(10, Abby.getAttackStrength());
    Abby.pickupGear(headGear1);
    assertEquals(10, Abby.getAttackStrength());
    Abby.pickupGear(handGear2);
    assertEquals(18, Abby.getAttackStrength());
    Abby.pickupGear(handGear3);
    assertEquals(24, Abby.getAttackStrength());
    Abby.pickupGear(handGear4);
    Abby.pickupGear(footWear1);
    Abby.pickupGear(footWear2);
    assertEquals(25, Abby.getAttackStrength());

  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidAttackStrengthTest() {
    Invalid = new Player("Fake", -5, 5);
  }

  @Test
  public void getDefenseStrength() {
    assertEquals(5, Abby.getDefenseStrength());
    Abby.pickupGear(handGear2);
    assertEquals(5, Abby.getDefenseStrength());
    Abby.pickupGear(headGear1);
    assertEquals(11, Abby.getDefenseStrength());
    Abby.pickupGear(footWear1);
    Abby.pickupGear(footWear2);
    assertEquals(25, Abby.getDefenseStrength());
  }

  @Test
  public void numOfHeadGears() {
    Abby.pickupGear(headGear1);
    Abby.pickupGear(headGear2);
    Abby.pickupGear(handGear1);
    Abby.pickupGear(handGear2);
    Abby.pickupGear(handGear3);
    Abby.pickupGear(handGear4);
    Abby.pickupGear(footWear1);
    Abby.pickupGear(footWear2);
    Abby.pickupGear(footWear3);
    Abby.pickupGear(footWear4);
    assertEquals(1, Abby.numOfHeadGears());
  }

  @Test
  public void numOfHandGears() {
    Abby.pickupGear(headGear1);
    Abby.pickupGear(headGear2);
    Abby.pickupGear(handGear1);
    Abby.pickupGear(handGear2);
    Abby.pickupGear(handGear3);
    Abby.pickupGear(handGear4);
    Abby.pickupGear(footWear1);
    Abby.pickupGear(footWear2);
    Abby.pickupGear(footWear3);
    Abby.pickupGear(footWear4);
    assertEquals(2, Abby.numOfHandGears());
  }

  @Test
  public void numOfFootWears() {
    Abby.pickupGear(headGear1);
    Abby.pickupGear(headGear2);
    Abby.pickupGear(handGear1);
    Abby.pickupGear(handGear2);
    Abby.pickupGear(handGear3);
    Abby.pickupGear(handGear4);
    Abby.pickupGear(footWear1);
    Abby.pickupGear(footWear2);
    Abby.pickupGear(footWear3);
    Abby.pickupGear(footWear4);
    assertEquals(2, Abby.numOfFootWears());
  }

}
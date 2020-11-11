package gear;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * This test class is used to test both valid and invalid combine function.
 */
public class FootWearTest {
  private Gear footWear1;
  private Gear footWear2;
  private Gear footWear3;

  @Before
  public void setUp() throws Exception {
    footWear1 = new FootWear("Speedy", "Boot", 5, 4, false);
    footWear2 = new FootWear("Swift", "Tabi", 4, 5, false);
    footWear3 = new FootWear("Ninja", "Tabi", 2, 2, false);
  }

  @Test
  public void combineTest() {
    Gear combined1 = footWear1.combine(footWear2);
    String expected = " Speedy Swift Tabi -- Attack Value: 9 -- Defense Value: 9";
    assertEquals(expected, combined1.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void combineInvalid() {
    Gear combined1 = footWear1.combine(footWear2);
    footWear3.combine((combined1));
  }
}
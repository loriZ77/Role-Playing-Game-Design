package gear;

import org.junit.Before;
import org.junit.Test;

/**
 * This test class is used to test combine exception.
 */
public class HeadGearTest {
  private Gear headGear1;
  private Gear headGear2;

  @Before
  public void setUp() {
    headGear1 = new HeadGear("Rabadon", "Deathcap", 6, false);
    headGear2 = new HeadGear("Better", "HeadGear", 8, false);
  }

  @Test (expected = IllegalArgumentException.class)
  public void combine() {
    headGear1.combine(headGear2);
  }
}
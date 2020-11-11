package gear;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * This test class is used to test both valid and invalid attack value.
 */
public class HandGearTest {
  private HandGear handGear1;
  private HandGear handGear2;

  @Before
  public void setUp() {
    handGear1 = new HandGear("Rabadon", "Deathcap", 6, false);
  }
  @Test
  public void getAttackValueTest(){
    assertEquals(6, handGear1.getAttackVal());
  }
  @Test (expected = IllegalArgumentException.class)
  public void InvalidAttackValueTest(){
    handGear2 = new HandGear("Rabadon", "Deathcap", -6, false);
  }

}
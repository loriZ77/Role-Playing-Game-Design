package gear;


import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

/**
 * This class test a battle between two players.
 */
public class BattleTest {
  private Battle battle1;
  private Player Abby;
  private Player Bob;
  ArrayList<Gear> choicesP1;
  ArrayList<Gear> choicesP2;


  @Before
  public void setUp() throws Exception {
    Abby = new Player("Abby", 3, 10);
    Bob = new Player("Bob", 10, 5);
    choicesP1 = new ArrayList<>();
    choicesP2 = new ArrayList<>();
    battle1 = new Battle(Abby, Bob, choicesP1, choicesP2);
  }

  @Test
  public void startBattleTest() {
    battle1.startBattle();
  }
}
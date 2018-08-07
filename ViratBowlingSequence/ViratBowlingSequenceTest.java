
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import priorityqueue.ViratBowlingSequence;
/**
 *
 * @author vishn_000
 */
public class ViratBowlingSequenceTest {
    ViratBowlingSequence minRuns;
   @Before
   public void test() {
       minRuns= new ViratBowlingSequence();
       minRuns.addPlayer(3,"Ram");
       minRuns.addPlayer(2,"Sachin");
       minRuns.addPlayer(1,"Irfan");
       minRuns.addPlayer(4,"Quereshi");
       minRuns.addPlayer(3,"Dhoni");
   }
   @Test(AssertionError)
   public void testViratMinRuns() {
       assertEquals(minRuns.playBowls(20),new StringBuilder("Quereshi->Quereshi->Dhoni"));
   }
   @Test
   public void testViratMinRuns() {
       assertEquals(minRuns.playBowls(3),new StringBuilder("Quereshi->Quereshi->Dhoni"));
   }
   @Test
   public void testViratMinRunsWithBowls2() {
       assertEquals(minRuns.playBowls(2),new StringBuilder("Quereshi->Quereshi"));
   }
   @Test
   public void testViratMinRunsWithBowls5() {
       assertEquals(minRuns.playBowls(5),new StringBuilder("Quereshi->Quereshi->Dhoni->Ram->Sachin"));
   }
}

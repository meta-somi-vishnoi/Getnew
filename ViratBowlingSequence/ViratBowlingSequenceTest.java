package priorityqueue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ViratBowlingSequenceTest {
    ViratBowlingSequence minRuns;

    @Before
    public void test() {
        minRuns = new ViratBowlingSequence();
        minRuns.addPlayer(3, "Ram");
        minRuns.addPlayer(2, "Sachin");
        minRuns.addPlayer(1, "Irfan");
        minRuns.addPlayer(4, "Quereshi");
        minRuns.addPlayer(3, "Dhoni");
    }

    @Test(expected = AssertionError.class)
    public void testViratMinRuns() {
        assertEquals(minRuns.playBowls(20), new StringBuilder("Quereshi->Quereshi->Dhoni"));
    }

    @Test
    public void testViratMinRunsWithBowls3() {
        assertEquals(minRuns.playBowls(3), "Quereshi->Quereshi->Ram");
    }

    @Test
    public void testViratMinRunsWithBowls2() {
        assertEquals(minRuns.playBowls(2), "Quereshi->Quereshi");
    }

    @Test
    public void testViratMinRunsWithBowls5() {
        assertEquals(minRuns.playBowls(5), "Quereshi->Quereshi->Ram->Dhoni->Dhoni");
    }
}

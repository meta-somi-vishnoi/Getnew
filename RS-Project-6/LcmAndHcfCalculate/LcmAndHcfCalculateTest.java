import static org.junit.Assert.*;

import org.junit.Test;

public class LcmAndHcfCalculateTest {
  
    @Test
    public void LcmCalculateTesting1() {
        int result;
        LcmAndHcfCalculator calculator1 = new LcmAndHcfCalculator();
        result = calculator1.lcmCalculator(20, 40);
        assertEquals(result, 40);
    }

    @Test
    public void LcmCalculateTesting2() {
        int result;
        LcmAndHcfCalculator calculator2 = new LcmAndHcfCalculator();
        result = calculator2.lcmCalculator(120, 90);
        assertEquals(result, 360);
    }

    @Test
    public void LcmCalculateTesting3() {
        int result;
        LcmAndHcfCalculator calculator3 = new LcmAndHcfCalculator();
        result = calculator3.lcmCalculator(25, 30);
        assertEquals(result, 150);
    }

    @Test
    public void LcmCalculateTesting4() {
        int result;
        LcmAndHcfCalculator calculator4 = new LcmAndHcfCalculator();
        result = calculator4.lcmCalculator(125, 30);
        assertNotEquals(result, 150);
    }

    @Test
    public void HcfCalculateTesting1() {
        int result;
        LcmAndHcfCalculator calculator = new LcmAndHcfCalculator();
        result = calculator.hcfCalculator(20, 40);
        assertEquals(result, 20);
    }

    @Test
    public void HcfCalculateTesting2() {
        int result;
        LcmAndHcfCalculator calculator = new LcmAndHcfCalculator();
        result = calculator.hcfCalculator(5, 2);
        assertEquals(result, 1);
    }

    @Test
    public void HcfCalculateTesting3() {
        int result;
        LcmAndHcfCalculator calculator = new LcmAndHcfCalculator();
        result = calculator.hcfCalculator(120, 90);
        assertEquals(result, 30);
    }

    @Test
    public void HcfCalculateTesting4() {
        int result;
        LcmAndHcfCalculator calculator = new LcmAndHcfCalculator();
        result = calculator.hcfCalculator(120, 45);
        assertNotEquals(result, 20);
    }
}

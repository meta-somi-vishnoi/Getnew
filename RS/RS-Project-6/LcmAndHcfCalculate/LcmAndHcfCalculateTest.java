import static org.junit.Assert.*;

import org.junit.Test;

public class LcmAndHcfCalculateTest {
    LcmAndHcfCalculate calculator = new LcmAndHcfCalculate();
    LcmAndHcfCalculate calculator1 = new LcmAndHcfCalculate();
    LcmAndHcfCalculate calculator2 = new LcmAndHcfCalculate();
    LcmAndHcfCalculate calculator3 = new LcmAndHcfCalculate();
    LcmAndHcfCalculate calculator4 = new LcmAndHcfCalculate();

    @Test
    public void testLcm1() {
        int result;
        result = calculator1.lcmCalculator(20, 40);
        assertEquals(result, 40);
    }

    @Test
    public void testLcm2() {
        int result;
        result = calculator2.lcmCalculator(120, 90);
        assertEquals(result, 360);
    }

    @Test
    public void testLcm3() {
        int result;
        result = calculator3.lcmCalculator(25, 30);
        assertEquals(result, 150);
    }

    @Test
    public void testLcm4() {
        int result;
        result = calculator4.lcmCalculator(125, 30);
        assertNotEquals(result, 150);
    }

    @Test
    public void testHcf1() {
        int result;
        result = calculator.hcfCalculator(20, 40);
        assertEquals(result, 20);
    }

    @Test
    public void testHcf2() {
        int result;
        result = calculator.hcfCalculator(5, 2);
        assertEquals(result, 1);
    }

    @Test
    public void testHcf3() {
        int result;
        result = calculator.hcfCalculator(120, 90);
        assertEquals(result, 30);
    }

    @Test
    public void testHcf4() {
        int result;
        result = calculator.hcfCalculator(120, 45);
        assertNotEquals(result, 20);
    }
}

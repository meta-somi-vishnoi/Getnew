import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayFunctionsTest {

    @Test
    public void testMirrorInArrayWithReturnValue7() {
        int maximumMirrorValue;
        ArrayFunctions arrayTests = new ArrayFunctions();
        maximumMirrorValue = arrayTests.maximumMirror(new int[] { 1, 2, 3, 4, 3, 2, 1 }, 7);
        assertEquals(maximumMirrorValue, 7);
    }

    @Test
    public void testMirrorInArrayWithReturnValue3() {
        int maximumMirrorValue;
        ArrayFunctions arrayTests = new ArrayFunctions();
        maximumMirrorValue = arrayTests.maximumMirror(new int[] { 1, 2, 1, 4 }, 4);
        assertEquals(maximumMirrorValue, 3);
    }

    @Test
    public void testMirrorInArrayWithReturnValue() {
        int maximumMirrorValue;
        ArrayFunctions arrayTests = new ArrayFunctions();
        maximumMirrorValue = arrayTests.maximumMirror(new int[] { 1, 2, 3, 8, 9, 3, 2, 1 }, 8);
        assertEquals(maximumMirrorValue, 3);
    }

    @Test
    public void testMirrorInArrayWithReturnValue1() {
        int maximumMirrorValue;
        ArrayFunctions arrayTests = new ArrayFunctions();
        maximumMirrorValue = arrayTests.maximumMirror(new int[] { 1, 2, 5, 4, 2, 7, 9 }, 7);
        assertEquals(maximumMirrorValue, 1);
    }

    @Test
    public void testClumpsWithReturnValue2() {
        int clumpCount;
        ArrayFunctions arrayTests = new ArrayFunctions();
        clumpCount = arrayTests.countClumps(new int[] { 1, 2, 2, 3, 3 }, 5);
        assertEquals(clumpCount, 2);
    }

    @Test
    public void testClumpsWithReturnValue1() {
        int clumpCount;
        ArrayFunctions arrayTests = new ArrayFunctions();
        clumpCount = arrayTests.countClumps(new int[] { 1, 1, 1, 1 }, 4);
        assertEquals(clumpCount, 1);
    }

    @Test
    public void testClumpsWithReturnValueTwo() {
        int clumpCount;
        ArrayFunctions arrayTests = new ArrayFunctions();
        clumpCount = arrayTests.countClumps(new int[] { 1, 1, 2, 1, 1 }, 5);
        assertEquals(clumpCount, 2);
    }

    @Test
    public void testClumpsWithReturnValue0() {
        int clumpCount;
        ArrayFunctions arrayTests = new ArrayFunctions();
        clumpCount = arrayTests.countClumps(new int[] { 1, 2, 4, 5, 8 }, 5);
        assertEquals(clumpCount, 0);
    }

    @Test
    public void testFixingXYInArrayWith2XYPair() {
        int[] actualResult;
        ArrayFunctions arrayTests = new ArrayFunctions();
        actualResult = new int[] { 9, 4, 5, 4, 5, 9 };
        int[] expectedResult = arrayTests.fixingInstance(new int[] { 5, 4, 9, 4, 9, 5 }, 6, 4, 5);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testFixingXYInArrayWith1XYPair() {
        int[] actualResult;
        ArrayFunctions arrayTests = new ArrayFunctions();
        actualResult = new int[] { 1, 4, 5, 1 };
        int[] expectedResult = arrayTests.fixingInstance(new int[] { 1, 4, 5, 1 }, 4, 4, 5);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testFixingXYInArrayWithX4Y5() {
        int[] actualResult;
        ArrayFunctions arrayTests = new ArrayFunctions();
        actualResult = new int[] { 1, 4, 5, 1, 1, 4, 5 };
        int[] expectedResult = arrayTests.fixingInstance(new int[] { 1, 4, 1, 5, 5, 4, 1 }, 7, 4, 5);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testSplitArrayWithReturnValue3() {
        int result;
        ArrayFunctions arrayTests = new ArrayFunctions();
        result = arrayTests.splittingArray(new int[] { 1, 2, 3, 2, 4 }, 5);
        assertEquals(result, 3);
    }

    @Test
    public void testSplitArrayWithReturnValueThree() {
        int result;
        ArrayFunctions arrayTests = new ArrayFunctions();
        result = arrayTests.splittingArray(new int[] { 1, 1, 1, 2, 1 }, 5);
        assertEquals(result, 3);
    }

    @Test
    public void testSplitArrayWithReturnValue-1() {
        int result;
        ArrayFunctions arrayTests = new ArrayFunctions();
        result = arrayTests.splittingArray(new int[] { 2, 1, 1, 2, 1 }, 5);
        assertEquals(result, -1);
    }
}

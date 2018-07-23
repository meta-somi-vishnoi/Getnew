import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayFunctionsTest {

    ArrayFunctions arrayTests = new ArrayFunctions();

    @Test
    public void testMirrorInArray1() {
        int maximumMirrorValue;
        maximumMirrorValue = arrayTests.maximumMirror(new int[] { 1, 2, 3, 4,
                3, 2, 1 }, 7);
        assertEquals(maximumMirrorValue, 7);
    }

    @Test
    public void testMirrorInArray2() {
        int maximumMirrorValue;
        maximumMirrorValue = arrayTests.maximumMirror(new int[] { 1, 2, 1, 4 },
                4);
        assertEquals(maximumMirrorValue, 3);
    }

    @Test
    public void testMirrorInArray3() {
        int maximumMirrorValue;
        maximumMirrorValue = arrayTests.maximumMirror(new int[] { 1, 2, 3, 8,
                9, 3, 2, 1 }, 8);
        assertEquals(maximumMirrorValue, 3);
    }

    @Test
    public void testMirrorInArray4() {
        int maximumMirrorValue;
        maximumMirrorValue = arrayTests.maximumMirror(new int[] { 1, 2, 5, 4,
                2, 7, 9 }, 7);
        assertEquals(maximumMirrorValue, 1);
    }

    @Test
    public void testClumps1() {
        int clumpCount;
        clumpCount = arrayTests.countClumps(new int[] { 1, 2, 2, 3, 3 }, 5);
        assertEquals(clumpCount, 2);
    }

    @Test
    public void testClumps2() {
        int clumpCount;
        clumpCount = arrayTests.countClumps(new int[] { 1, 1, 1, 1 }, 4);
        assertEquals(clumpCount, 1);
    }

    @Test
    public void testClumps3() {
        int clumpCount;
        clumpCount = arrayTests.countClumps(new int[] { 1, 1, 2, 1, 1 }, 5);
        assertEquals(clumpCount, 2);
    }

    @Test
    public void testClumps4() {
        int clumpCount;
        clumpCount = arrayTests.countClumps(new int[] { 1, 2, 4, 5, 8 }, 5);
        assertEquals(clumpCount, 0);
    }

    @Test
    public void testFixingXYInArray1() {
        int[] actualResult;
        actualResult = new int[] { 9, 4, 5, 4, 5, 9 };
        int[] expectedResult1 = arrayTests.fixingInstance(new int[] { 5, 4, 9,
                4, 9, 5 }, 6, 4, 5);
        assertArrayEquals(expectedResult1, actualResult);
    }

    @Test
    public void testFixingXYInArray2() {
        int[] actualResult;
        actualResult = new int[] { 1, 4, 5, 1 };
        int[] expectedResult2 = arrayTests.fixingInstance(new int[] { 1, 4, 5,
                1 }, 4, 4, 5);
        assertArrayEquals(expectedResult2, actualResult);
    }

    @Test
    public void testFixingXYInArray3() {
        int[] actualResult;
        actualResult = new int[] { 1, 4, 5, 1, 1, 4, 5 };
        int[] expectedResult3 = arrayTests.fixingInstance(new int[] { 1, 4, 1,
                5, 5, 4, 1 }, 7, 4, 5);
        assertArrayEquals(expectedResult3, actualResult);
    }

    @Test
    public void testSplitArray1() {
        int result;
        result = arrayTests.splittingArray(new int[] { 1, 2, 3, 2, 4 }, 5);
        assertEquals(result, 3);
    }

    @Test
    public void testSplitArray2() {
        int result;
        result = arrayTests.splittingArray(new int[] { 1, 1, 1, 2, 1 }, 5);
        assertEquals(result, 3);
    }

    @Test
    public void testSplitArray3() {
        int result;
        result = arrayTests.splittingArray(new int[] { 2, 1, 1, 2, 1 }, 5);
        assertEquals(result, -1);
    }
}

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchAlgorithmsTest {
    LinearSearch linear = new LinearSearch();
    BinarySearch binary = new BinarySearch();

    @Test
    public void testLinearSearch1() {
        int index = linear.linearSearching(new int[] { 1, 3, 6, 7, 9, 10 }, 6,
                7, 0);
        assertEquals(index, 4);
    }

    @Test
    public void testLinearSearch2() {
        int index = linear.linearSearching(
                new int[] { 1, 3, 36, 11, 3, 8, 49 }, 7, 8, 0);
        assertEquals(index, 6);
    }

    @Test
    public void testLinearSearch3() {
        int index = linear.linearSearching(new int[] { 11, 3, 26, 37, 29, 10,
                17 }, 7, 5, 0);
        assertNotEquals(index, 4);
    }

    @Test
    public void testBinarySearch1() {
        int index = binary.binarySearching(new int[] { 1, 3, 6, 7, 9, 10 }, 6,
                7, 0, 5);
        assertEquals(index, 4);
    }

    @Test
    public void testBinarySearch2() {
        int index = binary.binarySearching(
                new int[] { 22, 35, 57, 79, 91, 100 }, 6, 22, 0, 5);
        assertEquals(index, 1);
    }

    @Test
    public void testBinarySearch4() {
        int index = binary.binarySearching(new int[] { 1, 13, 26, 34, 59, 77,
                79, 89 }, 8, 26, 0, 7);
        assertNotEquals(index, 5);
    }

    @Test
    public void testBinarySearch3() {
        int index = binary.binarySearching(new int[] { 1, 13, 26, 37, 59, 77,
                79 }, 7, 23, 0, 6);
        assertEquals(index, -1);
    }
}

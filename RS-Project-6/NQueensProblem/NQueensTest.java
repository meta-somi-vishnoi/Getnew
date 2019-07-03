import static org.junit.Assert.*;

import org.junit.Test;

public class NQueensTest {

    @Test
    public void testNQueensWithValue4() {
        NQueensSolution findSolution = new NQueensSolution();
        int[][] array = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = 0;
            }
        }
        assertEquals(findSolution.solution(array, 0, 4), true);
    }
    
    @Test
    public void testNQueensTestWithValue8() {
        NQueensSolution findSolution = new NQueensSolution();
        int[][] array = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                array[i][j] = 0;
            }
        }
        assertEquals(findSolution.solution(array, 0, 8), true);
    }
    
    @Test
    public void testNQueensTestWithValue3() {
        NQueensSolution findSolution = new NQueensSolution();
        int[][] array = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = 0;
            }
        }
        assertNotEquals(findSolution.solution(array, 0, 3), true);
    }
}

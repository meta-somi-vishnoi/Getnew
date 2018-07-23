import static org.junit.Assert.*;

import org.junit.Test;

public class NQueensTest {

    @Test
    public void test1() {
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
    public void test2() {
        NQueensSolution findSolution = new NQueensSolution();
        int[][] array = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                array[i][j] = 0;
            }
        }
        assertEquals(findSolution.solution(array, 0, 8), true);
    }
}
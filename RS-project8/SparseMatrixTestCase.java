import static org.junit.Assert.*;

import org.junit.Test;


public class SparseMatrixTestCase {

    @Test
    public void testTransposeMatrix() {
        SparseMatrix matrix = new SparseMatrix(new int[][] {{1,0,0,2},{0,0,3,0},{5,0,0,4}});
        SparseMatrix sparseMatrix = new SparseMatrix();
        int[][] transposeMatrixActual=new int[][]{{0,3,2,0,3},{0,0,1,2,2},{1,2,3,5,4}};
        assertArrayEquals(sparseMatrix.transposeOfMatrix(matrix),transposeMatrixActual);
    }
    
    @Test
    public void testSymmetricMatrix() {
        SparseMatrix matrix = new SparseMatrix(new int[][] {{1,0,0,2},{0,0,3,0},{0,3,0,0},{2,0,0,1}});
        SparseMatrix sparseMatrix = new SparseMatrix();
        assertEquals(sparseMatrix.symmetricMatrix(matrix),true);
    }

    @Test
    public void testAddMatrix() {
        SparseMatrix firstMatrix = new SparseMatrix(new int[][] {{1,0,0,2},{0,0,3,0},{5,0,0,4}});
        SparseMatrix secondMatrix = new SparseMatrix(new int[][] {{0,2,0,7},{0,4,0,0},{0,9,0,4}});
        SparseMatrix sparseMatrix = new SparseMatrix();
        int[][] addMatrixActual=new int[][]{{1,2,0,9},{0,4,3,0},{5,9,0,8}};
        assertArrayEquals(sparseMatrix.addMatrix(firstMatrix,secondMatrix),addMatrixActual);
    }
    
    @Test
    public void testMultiplyMatrix() {
        SparseMatrix firstMatrix = new SparseMatrix(new int[][] {{1,0,0,2},{0,0,3,0},{5,0,0,4}});
        SparseMatrix secondMatrix = new SparseMatrix(new int[][] {{0,2,0,7},{0,4,0,0},{0,9,0,4}});
        SparseMatrix sparseMatrix = new SparseMatrix();
        int[][] multiplyMatrixActual=new int[][]{{1,2,0,9},{0,4,3,0},{5,9,0,8}};
        assertArrayEquals(sparseMatrix.addMatrix(firstMatrix,secondMatrix),multiplyMatrixActual);
    }
}

import static org.junit.Assert.*;

import org.junit.Test;

public class SparseMatrixTestCase {

    @Test
    public void testTransposeMatrixWithMatrixOne() {
        SparseMatrix matrixOne = new SparseMatrix(new int[][] { { 1, 0, 0, 2 }, { 0, 5, 3, 0 }, { 0, 3, 0, 0 }, { 2, 0, 0, 1 } });
        SparseMatrix sparseMatrix = new SparseMatrix();
        int[][] transposeMatrixActual = new int[][] { { 1, 0, 0, 2 }, { 0, 5, 3, 0 }, { 0, 3, 0, 0 }, { 2, 0, 0, 1 } };
        assertArrayEquals(sparseMatrix.transposeOfMatrix(matrixOne), transposeMatrixActual);
    }

    @Test
    public void testTransposeMatrixWithMatrixTwo() {
        SparseMatrix matrixTwo = new SparseMatrix(new int[][] { { 1, 0, 2 }, { 0, 3, 0 }, { 5, 0, 4 } });
        SparseMatrix sparseMatrix = new SparseMatrix();
        int[][] transposeMatrixActual = new int[][] { { 1, 0, 5 }, { 0, 3, 0 }, { 2, 0, 4 } };
        assertArrayEquals(sparseMatrix.transposeOfMatrix(matrixTwo), transposeMatrixActual);
    }

    @Test
    public void testTransposeMatrixWithMatrixThree() {
        SparseMatrix matrixThree = new SparseMatrix(
                new int[][] { { 2, 0, 1, 0 }, { 1, 0, 0, 0 }, { 9, 0, 0, 4 }, { 0, 0, 1, 6 } });
        SparseMatrix sparseMatrix = new SparseMatrix();
        int[][] transposeMatrixActual = new int[][] { { 2, 1, 9, 0 }, { 0, 0, 0, 0 }, { 1, 0, 0, 1 }, { 0, 0, 4, 6 } };
        assertArrayEquals(sparseMatrix.transposeOfMatrix(matrixThree), transposeMatrixActual);
    }

    @Test
    public void testSymmetricMatrixWithMatrixOne() {
        SparseMatrix matrixOne = new SparseMatrix(new int[][] { { 1, 0, 0, 2 }, { 0, 0, 3, 0 }, { 0, 3, 0, 0 }, { 2, 0, 0, 1 } });
        SparseMatrix sparseMatrix = new SparseMatrix();
        assertEquals(sparseMatrix.symmetricMatrix(matrixOne), true);
    }

    @Test
    public void testSymmetricMatrixWithMatrixTwo() {
        SparseMatrix matrixTwo = new SparseMatrix(new int[][] { { 1, 0, 0, 2 }, { 0, 0, 3, 0 }, { 0, 3, 0, 0 } });
        SparseMatrix sparseMatrix = new SparseMatrix();
        assertEquals(sparseMatrix.symmetricMatrix(matrixTwo), false);
    }

    @Test
    public void testSymmetricMatrixWithMatrixThree() {
        SparseMatrix matrixThree = new SparseMatrix(new int[][] { { 0, 0, 2 }, { 0, 3, 0 }, { 2, 0, 0 } });
        SparseMatrix sparseMatrix = new SparseMatrix();
        assertEquals(sparseMatrix.symmetricMatrix(matrixThree), true);
    }

    @Test
    public void testAddMatrixWithMatrixOne() {
        SparseMatrix firstMatrix = new SparseMatrix(new int[][] { { 1, 0, 0, 2 }, { 0, 0, 3, 0 }, { 5, 0, 0, 4 } });
        SparseMatrix secondMatrix = new SparseMatrix(new int[][] { { 0, 2, 0, 7 }, { 0, 4, 0, 0 }, { 0, 9, 0, 4 } });
        SparseMatrix sparseMatrix = new SparseMatrix();
        int[][] addMatrixActual = new int[][] { { 1, 2, 0, 9 }, { 0, 4, 3, 0 }, { 5, 9, 0, 8 } };
        assertArrayEquals(sparseMatrix.addMatrix(firstMatrix, secondMatrix), addMatrixActual);
    }

    @Test
    public void testAddMatrixWithMatrixTwo() {
        SparseMatrix firstMatrix = new SparseMatrix(
                new int[][] { { 0, 9, 0, 2 }, { 0, 0, 3, 0 }, { 5, 0, 0, 4 }, { 4, 0, 1, 0 } });
        SparseMatrix secondMatrix = new SparseMatrix(
                new int[][] { { 0, 2, 0, 7 }, { 4, 8, 0, 0 }, { 0, 4, 0, 0 }, { 0, 9, 0, 4 } });
        SparseMatrix sparseMatrix = new SparseMatrix();
        int[][] addMatrixActual = new int[][] { { 0, 11, 0, 9 }, { 4, 8, 3, 0 }, { 5, 4, 0, 4 }, { 4, 9, 1, 4 } };
        assertArrayEquals(sparseMatrix.addMatrix(firstMatrix, secondMatrix), addMatrixActual);
    }

    @Test
    public void testAddMatrixWithMatrixWithMatrixThree() {
        SparseMatrix firstMatrix = new SparseMatrix(new int[][] { { 1, 0, 0 }, { 0, 0, 3 }, { 5, 0, 0 } });
        SparseMatrix secondMatrix = new SparseMatrix(new int[][] { { 2, 0, 7 }, { 4, 0, 0 }, { 9, 0, 4 } });
        SparseMatrix sparseMatrix = new SparseMatrix();
        int[][] addMatrixActual = new int[][] { { 3, 0, 7 }, { 4, 0, 3 }, { 14, 0, 4 } };
        assertArrayEquals(sparseMatrix.addMatrix(firstMatrix, secondMatrix), addMatrixActual);
    }

    @Test
    public void testMultiplyMatrixWithMatrixOne() {
        SparseMatrix firstMatrix = new SparseMatrix(new int[][] { { 1, 2, 0, 0 }, { 5, 0, 0, 1 }, { 2, 0, 0, 0 } });
        SparseMatrix secondMatrix = new SparseMatrix(new int[][] { { 0, 0, 5 }, { 1, 2, 0 }, { 1, 0, 3 }, { 0, 0, 0 } });
        SparseMatrix sparseMatrix = new SparseMatrix();
        int[][] multiplyMatrixActual = new int[][] { { 2, 4, 5 }, { 0, 0, 25 }, { 0, 0, 10 } };
        assertArrayEquals(sparseMatrix.multiplyMatrix(firstMatrix, secondMatrix), multiplyMatrixActual);
    }

    @Test
    public void testMultiplyMatrixWithMatrixTwo() {
        SparseMatrix firstMatrix = new SparseMatrix(new int[][] { { 2, 0, 0 }, { 5, 0, 0 }, { 0, 0, 8 } });
        SparseMatrix secondMatrix = new SparseMatrix(new int[][] { { 0, 0, 5 }, { 1, 2, 0 }, { 1, 0, 3 } });
        SparseMatrix sparseMatrix = new SparseMatrix();
        int[][] multiplyMatrixActual = new int[][] { { 0, 0, 10 }, { 0, 0, 25 }, { 8, 0, 24 } };
        assertArrayEquals(sparseMatrix.multiplyMatrix(firstMatrix, secondMatrix), multiplyMatrixActual);
    }

    @Test
    public void testMultiplyMatrixWithMatrixThree() {
        SparseMatrix firstMatrix = new SparseMatrix(new int[][] { { 2, 1, 0 }, { 1, 0, 3 } });
        SparseMatrix secondMatrix = new SparseMatrix(new int[][] { { 0, 1 }, { 1, 3 }, { 2, 0 } });
        SparseMatrix sparseMatrix = new SparseMatrix();
        int[][] multiplyMatrixActual = new int[][] { { 1, 5 }, { 6, 1 } };
        assertArrayEquals(sparseMatrix.multiplyMatrix(firstMatrix, secondMatrix), multiplyMatrixActual);
    }
}

import static org.junit.Assert.*;

import org.junit.Test;

public class SparseMatrixTestCase {

    @Test(expected = AssertionError.class)
    public void testAssertionsEnabled() {
        SparseMatrix firstMatrix = new SparseMatrix(new int[][] { { 2, 0, 0 }, { 5, 0, 0 }, { 0, 0, 8 } });
        SparseMatrix secondMatrix = new SparseMatrix(new int[][] { { 0, 0 }, { 1, 0 }, { 1, 3 } });
        int[][] multiplyMatrixActual = new int[][] { { 0, 0, 10 }, { 0, 0, 25 }, { 8, 0, 24 } };
        assertArrayEquals(firstMatrix.multiplyMatrix(secondMatrix), multiplyMatrixActual);
    }

    @Test
    public void testTransposeMatrixWithMatrixOne() {
        SparseMatrix matrixOne = new SparseMatrix(new int[][] { { 1, 0, 0, 2 }, { 0, 5, 3, 0 }, { 0, 3, 0, 0 }, { 2, 0, 0, 1 } });
        int[][] transposeMatrixActual = new int[][] { { 1, 0, 0, 2 }, { 0, 5, 3, 0 }, { 0, 3, 0, 0 }, { 2, 0, 0, 1 } };
        assertArrayEquals(matrixOne.transposeOfMatrix(), transposeMatrixActual);
    }

    @Test
    public void testTransposeMatrixWithMatrixTwo() {
        SparseMatrix matrixTwo = new SparseMatrix(new int[][] { { 1, 0, 2 }, { 0, 3, 0 }, { 5, 0, 4 } });
        int[][] transposeMatrixActual = new int[][] { { 1, 0, 5 }, { 0, 3, 0 }, { 2, 0, 4 } };
        assertArrayEquals(matrixTwo.transposeOfMatrix(), transposeMatrixActual);
    }

    @Test
    public void testTransposeMatrixWithMatrixThree() {
        SparseMatrix matrixThree = new SparseMatrix(
            new int[][] { { 2, 0, 1, 0 }, { 1, 0, 0, 0 }, { 9, 0, 0, 4 }, { 0, 0, 1, 6 } });
        int[][] transposeMatrixActual = new int[][] { { 2, 1, 9, 0 }, { 0, 0, 0, 0 }, { 1, 0, 0, 1 }, { 0, 0, 4, 6 } };
        assertArrayEquals(matrixThree.transposeOfMatrix(), transposeMatrixActual);
    }

    @Test
    public void testSymmetricMatrixWithMatrixOne() {
        SparseMatrix matrixOne = new SparseMatrix(new int[][] { { 1, 0, 0, 2 }, { 0, 0, 3, 0 }, { 0, 3, 0, 0 }, { 2, 0, 0, 1 } });
        assertEquals(matrixOne.isSymmetricMatrix(), true);
    }

    @Test
    public void testSymmetricMatrixWithMatrixTwo() {
        SparseMatrix matrixTwo = new SparseMatrix(new int[][] { { 1, 0, 0, 2 }, { 0, 0, 3, 0 }, { 0, 3, 0, 0 } });
        assertEquals(matrixTwo.isSymmetricMatrix(), false);
    }

    @Test
    public void testSymmetricMatrixWithMatrixThree() {
        SparseMatrix matrixThree = new SparseMatrix(new int[][] { { 0, 0, 2 }, { 0, 3, 0 }, { 2, 0, 0 } });
        assertEquals(matrixThree.isSymmetricMatrix(), true);
    }

    @Test
    public void testAddMatrixWithMatrixOne() {
        SparseMatrix firstMatrix = new SparseMatrix(new int[][] { { 1, 0, 0, 2 }, { 0, 0, 3, 0 }, { 5, 0, 0, 4 } });
        SparseMatrix secondMatrix = new SparseMatrix(new int[][] { { 0, 2, 0, 7 }, { 0, 4, 0, 0 }, { 0, 9, 0, 4 } });
        int[][] addMatrixActual = new int[][] { { 1, 2, 0, 9 }, { 0, 4, 3, 0 }, { 5, 9, 0, 8 } };
        assertArrayEquals(firstMatrix.addMatrix(secondMatrix), addMatrixActual);
    }

    @Test
    public void testAddMatrixWithMatrixTwo() {
        SparseMatrix firstMatrix = new SparseMatrix(
            new int[][] { { 0, 9, 0, 2 }, { 0, 0, 3, 0 }, { 5, 0, 0, 4 }, { 4, 0, 1, 0 } });
        SparseMatrix secondMatrix = new SparseMatrix(
            new int[][] { { 0, 2, 0, 7 }, { 4, 8, 0, 0 }, { 0, 4, 0, 0 }, { 0, 9, 0, 4 } });
        int[][] addMatrixActual = new int[][] { { 0, 11, 0, 9 }, { 4, 8, 3, 0 }, { 5, 4, 0, 4 }, { 4, 9, 1, 4 } };
        assertArrayEquals(firstMatrix.addMatrix(secondMatrix), addMatrixActual);
    }

    @Test
    public void testAddMatrixWithMatrixWithMatrixThree() {
        SparseMatrix firstMatrix = new SparseMatrix(new int[][] { { 1, 0, 0 }, { 0, 0, 3 }, { 5, 0, 0 } });
        SparseMatrix secondMatrix = new SparseMatrix(new int[][] { { 2, 0, 7 }, { 4, 0, 0 }, { 9, 0, 4 } });
        int[][] addMatrixActual = new int[][] { { 3, 0, 7 }, { 4, 0, 3 }, { 14, 0, 4 } };
        assertArrayEquals(firstMatrix.addMatrix(secondMatrix), addMatrixActual);
    }

    @Test
    public void testMultiplyMatrixWithMatrixOne() {
        SparseMatrix firstMatrix = new SparseMatrix(new int[][] { { 1, 2, 0, 0 }, { 5, 0, 0, 1 }, { 2, 0, 0, 0 } });
        SparseMatrix secondMatrix = new SparseMatrix(new int[][] { { 0, 0, 5 }, { 1, 2, 0 }, { 1, 0, 3 }, { 0, 0, 0 } });
        int[][] multiplyMatrixActual = new int[][] { { 2, 4, 5 }, { 0, 0, 25 }, { 0, 0, 10 } };
        assertArrayEquals(firstMatrix.multiplyMatrix(secondMatrix), multiplyMatrixActual);
    }

    @Test
    public void testMultiplyMatrixWithMatrixTwo() {
        SparseMatrix firstMatrix = new SparseMatrix(new int[][] { { 2, 0, 0 }, { 5, 0, 0 }, { 0, 0, 8 } });
        SparseMatrix secondMatrix = new SparseMatrix(new int[][] { { 0, 0, 5 }, { 1, 2, 0 }, { 1, 0, 3 } });
        int[][] multiplyMatrixActual = new int[][] { { 0, 0, 10 }, { 0, 0, 25 }, { 8, 0, 24 } };
        assertArrayEquals(firstMatrix.multiplyMatrix(secondMatrix), multiplyMatrixActual);
    }

    @Test
    public void testMultiplyMatrixWithMatrixThree() {
        SparseMatrix firstMatrix = new SparseMatrix(new int[][] { { 2, 1, 0 }, { 1, 0, 3 } });
        SparseMatrix secondMatrix = new SparseMatrix(new int[][] { { 0, 1 }, { 1, 3 }, { 2, 0 } });
        int[][] multiplyMatrixActual = new int[][] { { 1, 5 }, { 6, 1 } };
        assertArrayEquals(firstMatrix.multiplyMatrix(secondMatrix), multiplyMatrixActual);
    }
}

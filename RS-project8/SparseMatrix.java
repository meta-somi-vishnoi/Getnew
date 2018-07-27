final public class SparseMatrix {
    private int noOfNonZeroElements;
    private int noOfRows;
    private int noOfColumns;
    private int sparseRepresentation[][];

    SparseMatrix() {
    }

    SparseMatrix(int[][] sparseMatrix) {
        int countNonZeroElements = 0;
        for (int i = 0; i < sparseMatrix.length; i++) {
            for (int j = 0; j < sparseMatrix[0].length; j++) {
                if (sparseMatrix[i][j] != 0) {
                    countNonZeroElements++;
                }
            }
        }
        this.noOfRows = sparseMatrix.length;
        this.noOfColumns = sparseMatrix[0].length;
        sparseRepresentation = new int[3][countNonZeroElements];
        noOfNonZeroElements = countNonZeroElements;
        int sparseIndex = 0;
        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfColumns; j++) {
                if (sparseMatrix[i][j] != 0) {
                    sparseRepresentation[0][sparseIndex] = i;
                    sparseRepresentation[1][sparseIndex] = j;
                    sparseRepresentation[2][sparseIndex] = sparseMatrix[i][j];
                    sparseIndex++;
                }
            }
        }
    }

    /**
     * calculates transpose of a given matrix
     * 
     * @param matrix
     * @return transposeMatrix
     */
    public int[][] transposeOfMatrix(SparseMatrix matrix) {
        int[][] transposeRepresentation = new int[3][matrix.noOfNonZeroElements];
        for (int i = 0; i < matrix.noOfNonZeroElements; i++) {
            transposeRepresentation[0][i] = matrix.sparseRepresentation[1][i];
            transposeRepresentation[1][i] = matrix.sparseRepresentation[0][i];
            transposeRepresentation[2][i] = matrix.sparseRepresentation[2][i];
        }
        int[][] transposeMatrix = new int[matrix.noOfColumns][matrix.noOfRows];
        for (int i = 0; i < matrix.noOfColumns; i++) {
            for (int j = 0; j < matrix.noOfRows; j++) {
                transposeMatrix[i][j] = 0;
            }
        }
        for (int i = 0; i < matrix.noOfNonZeroElements; i++) {
            transposeMatrix[transposeRepresentation[0][i]][transposeRepresentation[1][i]] = transposeRepresentation[2][i];
        }
        return transposeMatrix;
    }

    /**
     * calculates whether matrix is symmetric or not
     * 
     * @param matrix
     */
    public boolean symmetricMatrix(SparseMatrix matrix) {
        if (matrix.noOfRows != matrix.noOfColumns) {
            return false;
        }
        int[][] transposeRepresentationOfMatrix = transposeOfMatrix(matrix);
        for (int i = 0; i < matrix.noOfNonZeroElements; i++) {
            int found = 0;
            for (int j = 0; j < matrix.noOfNonZeroElements; j++) {
                if (matrix.sparseRepresentation[0][i] == matrix.sparseRepresentation[1][j] && matrix.sparseRepresentation[1][i] 
                == matrix.sparseRepresentation[0][j] && matrix.sparseRepresentation[2][i] == matrix.sparseRepresentation[2][j]) {
                    found = 1;
                    break;
                }
            }
            if (found == 1) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * calculates addition of two given matrix
     * 
     * @param firstMatrix
     *            , secondMatrix
     * @return addedMatrix
     */
    public int[][] addMatrix(SparseMatrix firstMatrix, SparseMatrix secondMatrix) {
        if (firstMatrix.noOfRows == secondMatrix.noOfRows && firstMatrix.noOfColumns == secondMatrix.noOfColumns) {
            int[][] addCount = new int[3][firstMatrix.sparseRepresentation[0].length + secondMatrix.sparseRepresentation[0].length];
            int indexCount = 0;
            for (indexCount = 0; indexCount < firstMatrix.sparseRepresentation[0].length; indexCount++) {
                addCount[0][indexCount] = firstMatrix.sparseRepresentation[0][indexCount];
                addCount[1][indexCount] = firstMatrix.sparseRepresentation[1][indexCount];
                addCount[2][indexCount] = firstMatrix.sparseRepresentation[2][indexCount];
            }
            for (int j = 0; j < secondMatrix.sparseRepresentation[0].length; j++) {
                int flag = 0;
                for (int i = 0; i < indexCount; i++) {
                    if (secondMatrix.sparseRepresentation[0][j] == addCount[0][i] 
                        && secondMatrix.sparseRepresentation[1][j] == addCount[1][i]) {
                        addCount[2][i] += secondMatrix.sparseRepresentation[2][j];
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    addCount[0][indexCount] = secondMatrix.sparseRepresentation[0][j];
                    addCount[1][indexCount] = secondMatrix.sparseRepresentation[1][j];
                    addCount[2][indexCount] = secondMatrix.sparseRepresentation[2][j];
                    indexCount++;
                }
            }
            int[][] addedMatrix = new int[firstMatrix.noOfRows][firstMatrix.noOfColumns];
            for (int i = 0; i < firstMatrix.noOfRows; i++) {
                for (int j = 0; j < firstMatrix.noOfRows; j++) {
                    addedMatrix[i][j] = 0;
                }
            }
            for (int i = 0; i < indexCount; i++) {
                addedMatrix[addCount[0][i]][addCount[1][i]] = addCount[2][i];
            }
            return addedMatrix;
        } else {
            throw new AssertionError();
        }
    }

    /**
     * calculates multiplication of two given matrix
     * 
     * @param firstMatrix
     *            , secondMatrix
     * @return multiplyMatrix
     */
    public int[][] multiplyMatrix(SparseMatrix firstMatrix, SparseMatrix secondMatrix) {
        if (firstMatrix.noOfRows == secondMatrix.noOfColumns && firstMatrix.noOfColumns == secondMatrix.noOfRows) {
            int[][] multiplyMatrix = new int[firstMatrix.noOfRows][secondMatrix.noOfColumns];
            for (int i = 0; i < firstMatrix.noOfRows; i++) {
                for (int j = 0; j < secondMatrix.noOfColumns; j++) {
                    multiplyMatrix[i][j] = 0;
                }
            }
            for (int i = 0; i < firstMatrix.sparseRepresentation[0].length; i++) {
                for (int j = 0; j < secondMatrix.sparseRepresentation[0].length; j++) {
                    if (firstMatrix.sparseRepresentation[1][i] == secondMatrix.sparseRepresentation[0][j]) {
                        multiplyMatrix[firstMatrix.sparseRepresentation[0][i]][secondMatrix.sparseRepresentation[1][j]] 
                        += (firstMatrix.sparseRepresentation[2][i] * secondMatrix.sparseRepresentation[2][j]);
                    }
                }
            }
            return multiplyMatrix;
        } else {
            throw new AssertionError();
        }
    }
}

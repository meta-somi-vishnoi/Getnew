final public class SparseMatrix {
    private int noOfNonZeroElements;
    private int noOfRows;
    private int noOfColumns;
    private int sparseRepresentation[][];

    SparseMatrix(int[][] sparseMatrix) {
        int countNonZeroElements = 0;
        for (int i = 0; i < sparseMatrix.length; i++) {
            for (int j = 0; j < sparseMatrix[0].length; j++) {
                if (sparseMatrix[i][j] != 0) {
                    countNonZeroElements++;
                }
            }
        }
        noOfRows = sparseMatrix.length;
        noOfColumns = sparseMatrix[0].length;
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
    public int[][] transposeOfMatrix() {
        int[][] transposeRepresentation = new int[3][this.noOfNonZeroElements];
        for (int i = 0; i < this.noOfNonZeroElements; i++) {
            transposeRepresentation[0][i] = this.sparseRepresentation[1][i];
            transposeRepresentation[1][i] = this.sparseRepresentation[0][i];
            transposeRepresentation[2][i] = this.sparseRepresentation[2][i];
        }
        int[][] transposeMatrix = new int[this.noOfColumns][this.noOfRows];
        for (int i = 0; i < this.noOfColumns; i++) {
            for (int j = 0; j < this.noOfRows; j++) {
                transposeMatrix[i][j] = 0;
            }
        }
        for (int i = 0; i < this.noOfNonZeroElements; i++) {
            transposeMatrix[transposeRepresentation[0][i]][transposeRepresentation[1][i]] = transposeRepresentation[2][i];
        }
        return transposeMatrix;
    }

    /**
     * calculates whether matrix is symmetric or not
     * 
     * @param matrix
     */
    public boolean isSymmetricMatrix() {
        if (this.noOfRows != this.noOfColumns) {
            return false;
        }
        for (int i = 0; i < this.noOfNonZeroElements; i++) {
            int found = 0;
            for (int j = 0; j < this.noOfNonZeroElements; j++) {
                if (this.sparseRepresentation[0][i] == this.sparseRepresentation[1][j] && 
                    this.sparseRepresentation[1][i] == this.sparseRepresentation[0][j] && 
                    this.sparseRepresentation[2][i] == this.sparseRepresentation[2][j]) {
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
     * @param firstMatrix, secondMatrix
     * @return addedMatrix
     */
    public int[][] addMatrix(SparseMatrix firstMatrix) {
        if (this.noOfRows == firstMatrix.noOfRows && this.noOfColumns == firstMatrix.noOfColumns) {
            int[][] addCount = new int[3][this.sparseRepresentation[0].length + 
                firstMatrix.sparseRepresentation[0].length];
            int indexCount = 0;
            for (indexCount = 0; indexCount < this.sparseRepresentation[0].length; indexCount++) {
                addCount[0][indexCount] = this.sparseRepresentation[0][indexCount];
                addCount[1][indexCount] = this.sparseRepresentation[1][indexCount];
                addCount[2][indexCount] = this.sparseRepresentation[2][indexCount];
            }
            for (int j = 0; j < firstMatrix.sparseRepresentation[0].length; j++) {
                int flag = 0;
                for (int i = 0; i < indexCount; i++) {
                    if (firstMatrix.sparseRepresentation[0][j] == addCount[0][i] && 
                        firstMatrix.sparseRepresentation[1][j] == addCount[1][i]) {
                            addCount[2][i] += firstMatrix.sparseRepresentation[2][j];
                            flag = 1;
                            break;
                    }
                }
                if (flag == 0) {
                    addCount[0][indexCount] = firstMatrix.sparseRepresentation[0][j];
                    addCount[1][indexCount] = firstMatrix.sparseRepresentation[1][j];
                    addCount[2][indexCount] = firstMatrix.sparseRepresentation[2][j];
                    indexCount++;
                }
            }
            int[][] addedMatrix = new int[this.noOfRows][this.noOfColumns];
            for (int i = 0; i < this.noOfRows; i++) {
                for (int j = 0; j < this.noOfRows; j++) {
                    addedMatrix[i][j] = 0;
                }
            }
            for (int i = 0; i < indexCount; i++) {
                addedMatrix[addCount[0][i]][addCount[1][i]] = addCount[2][i];
            }
            return addedMatrix;
        } else {
            throw new AssertionError("Rows and column mismatch.");
        }
    }

    /**
     * calculates multiplication of two given matrix
     * 
     * @param firstMatrix, secondMatrix
     * @return multiplyMatrix
     */
    public int[][] multiplyMatrix(SparseMatrix firstMatrix) {
        if (this.noOfRows == firstMatrix.noOfColumns && this.noOfColumns == firstMatrix.noOfRows) {
            int[][] multiplyMatrix = new int[this.noOfRows][firstMatrix.noOfColumns];
            for (int i = 0; i < this.noOfRows; i++) {
                for (int j = 0; j < firstMatrix.noOfColumns; j++) {
                    multiplyMatrix[i][j] = 0;
                }
            }
            for (int i = 0; i < this.sparseRepresentation[0].length; i++) {
                for (int j = 0; j < firstMatrix.sparseRepresentation[0].length; j++) {
                    if (this.sparseRepresentation[1][i] == firstMatrix.sparseRepresentation[0][j]) {
                        multiplyMatrix[this.sparseRepresentation[0][i]][firstMatrix.sparseRepresentation[1][j]] += 
                        (this.sparseRepresentation[2][i] * firstMatrix.sparseRepresentation[2][j]);
                    }
                }
            }
            return multiplyMatrix;
        } else {
            throw new AssertionError("Rows and column mismatch.");
        }
    }
}

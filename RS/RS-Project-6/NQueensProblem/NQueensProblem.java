class NQueensSolution {

    /**
     * print array board after queens are placed at right positions
     * 
     * @param array
     *            , number of queens
     */
    public void printBoard(int array[][], int numberOfQueens) {
        for (int i = 0; i < numberOfQueens; i++) {
            for (int j = 0; j < numberOfQueens; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println("\n");
        }
    }

    /**
     * checks if queen can be placed at given index
     * 
     * @param array
     *            , row at which queen is placed, column at which queen is
     *            placed, number of queens
     * @return true if queen can be places at particular row and column
     */
    public boolean rightPlaced(int array[][], int row, int column,
            int numberOfQueens) {
        for (int i = 0; i < row; i++) {
            if (array[i][column] == 1) {
                return false;
            }
        }
        int i, j;
        for (i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (array[i][j] == 1) {
                return false;
            }
        }
        for (i = row, j = column; i >= 0 && j < numberOfQueens; i--, j++) {
            if (array[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * recursive method calling itself at every row for placing queen in that
     * row
     * 
     * @param array
     *            , row at which queen is placed, number of queens
     * @return true if all queens can be placed safely
     */
    public boolean solution(int array[][], int row, int numberOfQueens) {
        if (row >= numberOfQueens) {
            return true;
        }
        for (int i = 0; i < numberOfQueens; i++) {
            if (rightPlaced(array, row, i, numberOfQueens)) {
                array[row][i] = 1;
                if (solution(array, row + 1, numberOfQueens)) {
                    return true;
                }
                array[row][i] = 0;
            }
        }
        return false;
    }
}

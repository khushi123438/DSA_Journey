class Solution {
    
    // Check whether val can be placed at board[row][col]
    private static boolean isSafe(char[][] board, int row, int col, char val) {

        // Check row and column
        for (int i = 0; i < 9; i++) {

            // Check row
            if (board[row][i] == val) {
                return false;
            }

            // Check column
            if (board[i][col] == val) {
                return false;
            }
        }

        // Find starting row and starting column
        // of the 3x3 box
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        // Check the 3x3 box
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {

                if (board[i][j] == val) {
                    return false;
                }
            }
        }

        return true;
    }


    // Find the next empty cell
    private static boolean findEmptyCell(char[][] board, int[] emptyCell) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {
                    emptyCell[0] = i;
                    emptyCell[1] = j;
                    return true;
                }
            }
        }

        return false;
    }


    // Backtracking function
    private static boolean solveSudokuHelper(char[][] board) {

        int[] emptyCell = new int[2];

        // Base Case:
        // No empty cells means Sudoku is solved
        if (!findEmptyCell(board, emptyCell)) {
            return true;
        }

        int rowIndex = emptyCell[0];
        int colIndex = emptyCell[1];

        // Try digits 1 to 9
        for (char val = '1'; val <= '9'; val++) {

            // Check whether this digit is safe
            if (isSafe(board, rowIndex, colIndex, val)) {

                // CHOOSE
                board[rowIndex][colIndex] = val;

                // EXPLORE
                if (solveSudokuHelper(board)) {
                    return true;
                }

                // UNCHOOSE / BACKTRACK
                board[rowIndex][colIndex] = '.';
            }
        }

        // No digit worked
        return false;
    }


    // Main method
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }
}
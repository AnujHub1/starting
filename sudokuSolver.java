public class sudokuSolver {

    public static boolean isSafes(int sudoku[][], int row, int col, int digit) {

        // column
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }

        // row
        for (int j = 0; j < 9; j++) {
            if (sudoku[row][j] == digit) {
                return false;
            }
        }
        // Grid

        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudokuSolve(int sudoku[][], int row, int col) {
        // base
        if (row == 9) {
            return true;
        }

        // recusion
        int nextrow = row;
        int nextcol = col + 1;
        if (col + 1 == 9) {
            nextrow = row + 1;
            nextcol = 0;
        }
        if (sudoku[row][col] != 0) {
            return sudokuSolve(sudoku, nextrow, nextcol);

        }
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafes(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (sudokuSolve(sudoku, nextrow, nextcol)) {
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }

        return false;
    }

    public static void printSudoku(int sudoku[][]) {
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int sudoku[][] = { { 2, 9, 0, 0, 0, 0, 0, 0, 5 },
                { 0, 0, 0, 0, 0, 0, 0, 2, 0 },
                { 6, 0, 8, 9, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 7, 0, 0, 0, 9, 4 },
                { 0, 4, 3, 0, 0, 5, 0, 0, 6 },
                { 0, 0, 0, 3, 1, 0, 0, 0, 8 },
                { 0, 2, 0, 0, 5, 0, 0, 3, 0 },
                { 0, 0, 0, 0, 4, 0, 0, 0, 9 },
                { 0, 0, 0, 0, 0, 0, 6, 7, 0 } };

        if (sudokuSolve(sudoku, 0, 0)) {
            System.out.println("solution exsits");
            printSudoku(sudoku);
        } else {
            System.out.println("solution does not exist");
        }
    }
}

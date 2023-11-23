public class ValidSudoku {
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] input = {{'5','3','.','.','7','.','.','.','.'}
        ,{'6','.','.','1','9','5','.','.','.'}
        ,{'.','9','8','.','.','.','.','6','.'}
        ,{'8','.','.','.','6','.','.','.','3'}
        ,{'4','.','.','8','.','3','.','.','1'}
        ,{'7','.','.','.','2','.','.','.','6'}
        ,{'.','6','.','.','.','.','2','8','.'}
        ,{'.','.','.','4','1','9','.','.','5'}
        ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(sol.isValidSudoku(input));

        char[][] input2 = {{'8','3','.','.','7','.','.','.','.'}
        ,{'6','.','.','1','9','5','.','.','.'}
        ,{'.','9','8','.','.','.','.','6','.'}
        ,{'8','.','.','.','6','.','.','.','3'}
        ,{'4','.','.','8','.','3','.','.','1'}
        ,{'7','.','.','.','2','.','.','.','6'}
        ,{'.','6','.','.','.','.','2','8','.'}
        ,{'.','.','.','4','1','9','.','.','5'}
        ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(sol.isValidSudoku(input2));

        char[][] input3 = {{'8','3','.','.','7','.','.','.','.'}
        ,{'6','.','.','1','9','5','.','.','.'}
        ,{'.','9','8','.','.','.','.','6','.'}
        ,{'5','.','.','.','6','.','.','.','3'}
        ,{'4','.','.','8','.','3','.','.','1'}
        ,{'7','.','.','.','2','.','.','.','6'}
        ,{'.','6','.','.','.','.','2','8','.'}
        ,{'.','.','.','4','1','9','.','.','5'}
        ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(sol.isValidSudoku(input3));
    }

    static class Solution {
        public boolean isValidSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                if (isValidRow(board, i) && isValidColumn(board, i) && isValidSub(board, i)) {
                    continue;
                } else {
                    return false;
                }
            }
            return true;
        }

        private boolean isValidRow(char[][] board, int row) {
            boolean[] occured = new boolean[10];
            for (int i = 0; i < 9; i++) {
                if (board[row][i] == '.') {
                    continue;
                }
                int current = Integer.parseInt(String.valueOf(board[row][i]));
                if (occured[current]) {
                    return false;
                } else {
                    occured[current] = true;
                }
            }
            return true;
        }

        private boolean isValidColumn(char[][] board, int column) {
            boolean[] occured = new boolean[10];
            for (int i = 0; i < 9; i++) {
                if (board[i][column] == '.') {
                    continue;
                }
                int current = Integer.parseInt(String.valueOf(board[i][column]));
                if (occured[current]) {
                    return false;
                } else {
                    occured[current] = true;
                }
            }
            return true;
        }

        private boolean isValidSub(char[][] board, int s) {
            int r = 0, c = 0;
            if (s != 0) {
                int rem = s % 3;
                int q = s / 3;
                r = rem * 3;
                c = q * 3;
            }
            boolean[] occured = new boolean[10];
            for (int i = r; i < r + 3; i++) {
                for (int j = c; j < c + 3; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    }
                    int current = Integer.parseInt(String.valueOf(board[i][j]));
                    if (occured[current]) {
                        return false;
                    } else {
                        occured[current] = true;
                    }
                }
            }
            return true;
        }

    }
}

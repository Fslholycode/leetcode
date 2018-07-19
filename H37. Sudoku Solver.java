class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
    }
    
    public boolean helper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(board,i,j,k)) {
                            board[i][j] = k;
                            if (helper(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(char[][] board, int x, int y, char k) {
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == k) return false;
        }
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == k) return false;
        }
        for (int i = 3*(x/3); i < 3*(x/3+1); i++) {
            for (int j = 3*(y/3); j < 3*(y/3+1); j++) {
                if (board[i][j] == k) return false;
            }
        }
        return true;
    }
}
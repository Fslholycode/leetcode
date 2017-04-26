public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        if (n == 0) return;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = countLive(board, m, n, i, j);
                if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2;
                }
            }
        }
        right(board, m, n);
    }
    public void right(int[][] board, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }
    public int countLive(int[][] board, int m, int n, int i, int j) {
        int lives = 0;
        for (int p = Math.max(0,i-1); p <= Math.min(m-1,i+1); p++) {
            for (int q = Math.max(0,j-1); q <= Math.min(n-1, j+1); q++) {
                if ((board[p][q] & 1) == 1) {
                    lives++;
                }
            }
        }
        lives -= board[i][j] & 1;
        return lives;
    }
}
class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public void solve(char[][] board) {
        if (board.length <= 2 || board[0].length <= 2)
            return;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n-1);
        }
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m-1, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '1') board[i][j] = 'O';
            }
        }
    }
    public void dfs(char[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') return;
        board[i][j] = '1';
        for (int d = 0; d < 4; d++) {
            dfs(board, i+dir[d][0], j+dir[d][1]);
        }
    }
}
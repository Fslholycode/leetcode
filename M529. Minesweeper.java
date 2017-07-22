public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int n = click[0];
        int m = click[1];
        dfs(board,n,m);
        return board;
    }
    public void dfs(char[][] board, int n, int m) {
        if (cal(board,n,m) == 'E') {
            if (adj(board,n,m) == '0') {
                board[n][m] = 'B';
                dfs(board,n-1,m);
                dfs(board,n-1,m-1);
                dfs(board,n-1,m+1);
                dfs(board,n,m-1);
                dfs(board,n,m+1);
                dfs(board,n+1,m-1);
                dfs(board,n+1,m);
                dfs(board,n+1,m+1);
            } else board[n][m] = adj(board,n,m);
        }  
        if (cal(board,n,m) == 'M') board[n][m] = 'X';
    }
    public char adj(char[][] board, int n, int m) {
        int count = 0;
        if (cal(board, n-1, m-1) == 'M') count++;
        if (cal(board, n-1, m) == 'M') count++;
        if (cal(board, n-1, m+1) == 'M') count++;
        if (cal(board, n, m-1) == 'M') count++;
        if (cal(board, n, m+1) == 'M') count++;
        if (cal(board, n+1, m-1) == 'M') count++;
        if (cal(board, n+1, m) == 'M') count++;
        if (cal(board, n+1, m+1) == 'M') count++;
        return (char) (count+'0');
    }
    public char cal(char[][] board, int n, int m) {
        if (n < 0 || m < 0 || n >= board.length || m >= board[0].length) {
            return 'B';
        } else return board[n][m];
    }
}
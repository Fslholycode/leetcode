class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] map = new int[26][2];
        int m = board.length;
        int n = board[0].length;
        boolean res = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                res = res || dfs(board, visited, i,j, word, 0);
            }
        }
        return res;
    }
    public boolean dfs(char[][] board, boolean[][] visited, int i, int j, String word, int pos) {
        int m = board.length;
        int n = board[0].length;
        if (pos == word.length()) return true;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != word.charAt(pos)) return false;
        visited[i][j] = true;
        boolean res = dfs(board, visited,i+1,j, word, pos+1) || dfs(board, visited,i-1,j, word, pos+1) || dfs(board, visited,i,j+1, word, pos+1) || dfs(board, visited,i,j-1, word, pos+1);
        visited[i][j] = false;
        return res;
    }
}
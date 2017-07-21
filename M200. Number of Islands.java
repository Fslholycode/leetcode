public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        if (m == 0) return 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    count++;
                    dfs(grid,visited,i,j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        if (visited[i][j] == true) return;
        visited[i][j] = true;
        if (cal(grid, i-1,j) == '1') dfs(grid,visited,i-1,j);
        if (cal(grid, i,j-1) == '1') dfs(grid,visited,i,j-1);
        if (cal(grid, i,j+1) == '1') dfs(grid,visited,i,j+1);
        if (cal(grid, i+1,j) == '1') dfs(grid,visited,i+1,j);
        
    }
    public char cal(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return '0';
        else return grid[i][j];
    }
}
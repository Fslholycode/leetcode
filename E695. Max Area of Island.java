class Solution {
    int max = 0;
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean[][] visited = new boolean[row][col];
                max = Math.max(max, dfs(i, j, visited, grid));
            }
        }
        return max;
    }
    public int dfs(int x, int y, boolean[][] visited, int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int sum = 0;
        if (x < 0 || y < 0 || x > row-1 || y > col-1 || visited[x][y] || grid[x][y] == 0) {
            return 0;
        }
        visited[x][y] = true;
        sum++;
        for (int i = 0; i < 4; i++) {
            sum += dfs(x+dir[i][0], y+dir[i][1], visited, grid);
        }
        // visited[x][y] = false;
        return sum;
    }
}
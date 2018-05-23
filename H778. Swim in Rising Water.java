class Solution {
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int res = grid[0][0];
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]> (new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[2]-b[2];
            }
        });
        pq.offer(new int[] {0, 0, grid[0][0]});
        while (!pq.isEmpty()) {
            int[] pos = pq.poll();
            res = Math.max(res, pos[2]);
            if (pos[0] == m-1 && pos[1] == n-1) return res;
            for (int i = 0; i < 4; i++) {
                int newx = pos[0]+dir[i][0];
                int newy = pos[1]+dir[i][1];
                if (newx < 0 || newy < 0 || newx >= m || newy >= n || visited[newx][newy]) continue;
                visited[newx][newy] = true;
                pq.offer(new int[] {newx, newy, grid[newx][newy]});
            }
        }
        return 0;
    }
}
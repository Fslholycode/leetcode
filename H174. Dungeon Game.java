class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int[] num:dp) Arrays.fill(num, Integer.MAX_VALUE);
        dp[m-1][n] = 1;
        dp[m][n-1] = 1;
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                int cur = Math.min(dp[i][j+1], dp[i+1][j])-dungeon[i][j];
                dp[i][j] = cur <= 0? 1:cur;
            }
        }
        return dp[0][0];
    }
}
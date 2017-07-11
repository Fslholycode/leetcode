public class Solution {
    public int maximalSquare(char[][] matrix) {
        int len = matrix.length;
        if (len == 0) return 0;
        int wid = matrix[0].length;
        if (wid == 0) return 0;
        int[][] dp = new int[len+1][wid+1];
        int max = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= wid; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1])+1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
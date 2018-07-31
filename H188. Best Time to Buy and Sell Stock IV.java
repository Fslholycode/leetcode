class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0) return 0;
        if (k >= prices.length/2) return quickSolve(prices);
        int[][] dp = new int[k][2];
        for (int i = 0; i < k; i++) {
            dp[i][0] = Integer.MIN_VALUE;
        }
        for (int price:prices) {
            for (int i = 0; i < k; i++) {
                if (i == 0) dp[i][0] = Math.max(dp[i][0],-price);
                else dp[i][0] = Math.max(dp[i-1][1]-price, dp[i][0]);
                dp[i][1] = Math.max(dp[i][0]+price, dp[i][1]);
            }
        }
        return dp[k-1][1];
    }
    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
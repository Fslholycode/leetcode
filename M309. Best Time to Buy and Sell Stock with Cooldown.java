class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] buy = new int[2];
        int[] sell = new int[2];
        int[] rest = new int[2];
        buy[0] = Integer.MIN_VALUE;
        for (int i = 1; i <= len; i++) {
            buy[i%2] = Math.max(buy[(i-1)%2], rest[(i-1)%2]-prices[i-1]);
            sell[i%2] = Math.max(sell[(i-1)%2], buy[(i-1)%2]+prices[i-1]);
            rest[i%2] = Math.max(rest[(i-1)%2], sell[(i-1)%2]);
        }
        return sell[len%2];
    }
}
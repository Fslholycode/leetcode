public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0; 
        int min = prices[0];
        int max = prices[0];
        int res = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i] <= prices[i+1]) {
                min = Math.min(prices[i], min);
                max = Math.max(prices[i+1], max);
                res = Math.max(max-min,res);
            } else {
                min = Math.min(prices[i+1], min);
                max = 0;
            }
        }
        return res;
    }
}
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int res = 0;
        int low = prices[1] >= prices[0]? prices[0]:prices[1];
        int high = prices[1] >= prices[0]? prices[1]:prices[0];
        boolean status = prices[1] >= prices[0]? false:true; //false means fall, true means drop
        
        for (int i = 2; i < prices.length; i++) {
            if (status == false) {
                if (prices[i] < prices[i-1]) {
                    high = prices[i-1];
                    status = true;
                    res += high-low;
                } 
            } else {
                if (prices[i] > prices[i-1]) {
                    low = prices[i-1];
                    status = false;
                }
            }
        }
        res += status == false? prices[prices.length-1] - low:0;
        return res;
    }
    public static void main(String[] args) {
    	    int[] a = {1,2,3,1,2,3};
    	    System.out.println(new Solution().maxProfit(a));
    }
}
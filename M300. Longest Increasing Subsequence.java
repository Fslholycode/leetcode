public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int[] dp = new int[nums.length+1];
        dp[0]= 0;
        dp[1] = 1;
        int len = 1;
        for (int i = 2; i < nums.length+1; i++) {
            int index = i-1;
            dp[i] = 1;
            while (index > 0) {
                if (nums[index-1] < nums[i-1]) {
                    dp[i] = Math.max(dp[i], dp[index]+1);
                }
                index--;
            }
            len = Math.max(len,dp[i]);
        }
        return len;
    }
    
}
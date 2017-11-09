public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) sum += num;
        if(sum % 2 == 1) return false;
        
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];
        // deal with the first row
        if(nums[0] <= target) dp[0][nums[0]] = true;
        
        // deal with the first col
        for(int i = 0; i < nums.length; i++) dp[i][0] = true;
        
        // deal with the rest
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        if (sum%2 == 1) return false;
        boolean[] dp = new boolean[sum/2+1];
        dp[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = sum/2; j >= nums[i-1]; j--) {
                dp[j] = dp[j] || dp[j-nums[i-1]];
            }
        }
        return dp[sum/2];
    } 
}
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        return helper(nums,S,0,sum);
    }
    public int helper(int[] nums, int S, int pos, int sum) {
        if (pos == nums.length) {
            if (S == sum) return 1;
            else return 0;
        }
        int time = 0;
        time = helper(nums, S, pos+1, sum-nums[pos])+helper(nums,S,pos+1,sum+nums[pos]);
        return time;
    }
}
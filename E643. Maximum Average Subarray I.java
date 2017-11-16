class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int max = 0;
        for (int j = 1; j < nums.length; j++) {
            nums[j] += nums[j-1];
        }
        max = nums[k-1];
        for (int i = k; i < nums.length; i++) {
            max = Math.max(max, nums[i] - nums[i-k]);
        }
        return (double)max/(double)k;
    }
}
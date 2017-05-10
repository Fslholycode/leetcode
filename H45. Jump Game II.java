public class Solution {
    public int jump(int[] nums) {
        int maxReach = nums[0];
        int edge = 0;
        int minStep = 0;
        for (int i = 1; i < nums.length; i++) {
            if (i > edge) {
                minStep += 1;
                edge = maxReach;
                if (edge >= nums.length - 1) return minStep;
            }
            maxReach = Math.max(maxReach, nums[i]+i);
            if (maxReach == i) return -1;
        }
        return minStep;
    }
    public static void main(String[] args) {
    	    int[] nums = {5,9,3,2,1,0,2,3,3,1,0,0};
    	    System.out.println(new Solution().jump(nums));
    }
}
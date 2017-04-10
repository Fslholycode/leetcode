public class Solution {
    public int thirdMax(int[] nums) {
        long max0 = Long.MIN_VALUE;
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == max0 || nums[i] == max1 || nums[i] == max2 || nums[i] < max0) {
                i++;
                continue;
            } 
            if (nums[i] > max2) {
                max0 = max1;
                max1 = max2;
                max2 = nums[i];
            }
            else if (nums[i] > max1) {
                max0 = max1;
                max1 = nums[i];
            }
            else if(nums[i] > max0) {
                max0 = nums[i];
            }
            i++;
        } 
        return max0 == Long.MIN_VALUE ? (int)max2:(int)max0;
    }
}
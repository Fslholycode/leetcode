class Solution {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) return 0;
        int max1= 0;
        int max2 = 1;
        if (nums[0] < nums[1]) {
            max1 = 1;
            max2 = 0;
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > nums[max1]) {
                max2 = max1;
                max1 = i;
            } else if (nums[i] > nums[max2]) {
                max2 = i;
            }
        }
        return nums[max1] >= 2*nums[max2]?max1:-1;
    }
}
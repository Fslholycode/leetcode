class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums.length <= 2) return true;
        int count = 0;
        for (int i = 0; i < nums.length-1 && count < 2; i++) {
            if (nums[i] > nums[i+1]) {
                count++;
                if (i < 1 || nums[i-1] <= nums[i+1]) nums[i]=nums[i+1];
                nums[i+1] = nums[i];
            }
        }
        return count<2;
    }
}
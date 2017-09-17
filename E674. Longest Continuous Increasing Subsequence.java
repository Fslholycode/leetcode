class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int index = 0;
        int length = 1;
        int max = 1;
        while (index+1 < nums.length) {
            if (nums[index] < nums[index+1]) {
                length++;
                max = Math.max(max,length);
            }
            else length=1;
            index++;
        }
        return max;
    }
}
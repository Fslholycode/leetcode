public class Solution {
    public int removeDuplicates(int[] nums) {
        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[m] != nums[i]) {
                nums[++m] = nums[i];
            }
        }
        return m+1;
    }
}
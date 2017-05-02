public class Solution {
    public int removeDuplicates(int[] nums) {
        int time = 1;
        int m = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[m]) {
                time++;
            } else {
                time = 1;
            }
            if (time <= 2) {
                nums[++m] = nums[i]; 
            } 
        }
        return m+1;
    }
}
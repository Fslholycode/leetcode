public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int start = 0;
        int end = nums.length-1;
        while (start < end) {
            while (end >= 0 && nums[end] == val) {
                end--;
            }
            if (end > start && nums[start] == val) {
                int temp = nums[end];
                nums[start] = temp;
                nums[end] = val;
            }
            start++;
        }
        int i = nums.length-1;
        while (i >= 0 && nums[i] == val) {
            i--;
        }
        return i+1;
    }
}
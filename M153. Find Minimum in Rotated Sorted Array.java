public class Solution {
    public int findMin(int[] nums) {
        int start = 0; 
        int end = nums.length-1;
        while (start+1 < end) {
            int mid = start + (end - start)/2;
            if (nums[mid] > nums[0] && nums[mid] > nums[end]) {
                start = mid;
            }
            if (nums[mid] > nums[0] && nums[mid] < nums[end]) {
                return nums[0];
            }
            if (nums[mid] < nums[0]) {
                end = mid;
            }
        }
        return Math.min(nums[start],nums[end]);
    }
}
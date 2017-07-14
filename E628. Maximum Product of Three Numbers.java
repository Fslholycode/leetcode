public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (nums.length == 3) return nums[0]*nums[1]*nums[2];
        else if (nums[0] <= 0 && nums[1] >= 0) {
            return nums[n-1]*nums[n-2]*nums[n-3];
        } else if (nums[0] < 0 && nums[1] < 0) {
            return Math.max(nums[0]*nums[1]*nums[n-1], nums[n-1]*nums[n-2]*nums[n-3]);
        } else {
            return nums[n-1]*nums[n-2]*nums[n-3];
        }
    }
}
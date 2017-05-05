public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0; 
        int end = nums.length-1;
        int[] res = {-1,-1};
        if (nums.length == 0) return res;

        while (start < end) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target) {
                int i = 1;
                while (mid-i >= 0 && nums[mid-i] == target) {
                    i++;
                }
                res[0] = mid-i+1;
                i=1;
                while (mid+i < nums.length && nums[mid+i] == target) {
                    i++;
                }
                res[1] = mid+i-1;
                return res;
            } else if (nums[mid] < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        if (nums[start] == target) {
            res[0] = start;
            res[1] = start;
        }
        return res;
    }
}
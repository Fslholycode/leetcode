public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int start = 0;
        int end = nums.length-1;
        while (start + 1 < end) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target) return true;
            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else if (nums[mid] > nums[end] || nums[mid] > nums[start]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                end--;
            }
        }
        return target == nums[end] || target == nums[start]? true:false;
    }
    public static void main(String[] args) {
    	    int[] a = {3,5,1};
    	    int b = 1;
    	    System.out.println(new Solution().search(a,b));
    }
}
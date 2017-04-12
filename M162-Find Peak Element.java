public class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        
        while (start+1 < end) {
            int mid = start + (end-start)/2;
            if (nums(nums,mid) > nums(nums,mid+1) && nums(nums,mid) > nums(nums,mid-1)) {
                return mid;
            } else if (nums(nums,mid+1) < nums(nums,mid)) {
                end = mid;
            } else if (nums(nums,mid-1) < nums(nums,mid) ) {
                start = mid;
            } else {
                start = mid;
            }
        }
        if (nums(nums,start) > nums(nums,start+1) && nums(nums,start) > nums(nums,start-1)) {
            return start;
        }
        if (nums(nums,end) > nums(nums,end+1) && nums(nums,end) > nums(nums,end-1)) {
            return end;
        }
        return -1;
    }
    public long nums(int[] nums, int index) {
        if (index == -1 || index == nums.length) {
            return Long.MIN_VALUE;
        }
        else {
            return nums[index];
        }
    }

    public static void main(String[] args) {
    	    int[] a = {1};
    	    System.out.println(new Solution().findPeakElement(a));
    }
}
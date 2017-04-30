public class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int len = nums.length-1;
        int min = nums[0];
        while (start + 1 < end) {
            int mid = start + (end-start)/2;
            if (nums[len] == nums[mid]) {
            	    int i;
            	    for (i = mid; i <= len; i++) {
            	    	    if (nums[i] != nums[mid]) {
            	    	    	    start = i;
            	    	    	    break;
            	    	    }
            	    }
            	    if (i == len + 1) {
            	    	    end = mid;
            	    }
            }
            else if (nums[0] == nums[mid]) {
	            	int i;
	        	    for (i = 0; i <= mid; i++) {
	        	    	    if (nums[i] != nums[mid]) {
	        	    	    	    end = i;
	        	    	    	    break;
	        	    	    }
	        	    }
	        	    if (i == mid + 1) {
	        	    	    start = mid;
	        	    }
            }
            else if (nums[0] < nums[mid] && nums[mid] > nums[nums.length-1]) {
                start = mid;
            }
            else if (nums[0] < nums[mid] && nums[mid] < nums[nums.length-1]) {
                return nums[0];
            }
            else if (nums[0] > nums[mid] && nums[mid] < nums[nums.length-1]) {
                end = mid;
            }
        } 
        return Math.min(min,Math.min(nums[start], nums[end]));
    }
    public static void main(String[] args) {
    	    int[] a = {3,3,1,3,3,3,3,3};
    	    System.out.println(new Solution().findMin(a));
    }
}


//precise solution
class Solution {
public:
    int findMin(vector<int> &num) {
        int lo = 0;
        int hi = num.size() - 1;
        int mid = 0;
        
        while(lo < hi) {
            mid = lo + (hi - lo) / 2;
            
            if (num[mid] > num[hi]) {
                lo = mid + 1;
            }
            else if (num[mid] < num[hi]) {
                hi = mid;
            }
            else { // when num[mid] and num[hi] are same
                hi--;
            }
        }
        return num[lo];
    }
};
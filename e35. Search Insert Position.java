public class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start+1 < end) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] > target) {
            return Math.max(start-1,0);
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] > target) {
            return start+1;
        }
        if (nums[end] == target) {
            return end;
        }
        return end+1;
    }
}


public int searchInsert(int[] A, int target) {
int low = 0, high = A.length-1;
while(low<=high){
    int mid = (low+high)/2;
    if(A[mid] == target) return mid;
    else if(A[mid] > target) high = mid-1;
    else low = mid+1;
}
return low;
}
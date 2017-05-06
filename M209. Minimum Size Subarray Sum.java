public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int end = 0;
        int min = nums.length+1;
        int sum = 0;
        while (end < nums.length) {
            sum += nums[end++];
            while (sum >= s) {
                min = Math.min(min, end-start);
                System.out.println(min);
                sum -= nums[start++];
            }
        }
        return min == nums.length+1? 0:min;
    }
    public static void main(String[] args) {
    		int s = 7;
    		int[] nums = {2,3,1,2,4,3};
    		System.out.println(new Solution().minSubArrayLen(s,nums));
    }
}
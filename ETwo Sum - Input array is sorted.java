public class Solution {
    /*
     * @param nums an array of Integer
     * @param target = nums[index1] + nums[index2]
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        int start = 0, end = nums.length-1,sum = 0;
        int[] res = new int[2];
        while (start < end) {
            sum = nums[start] + nums[end];
            if (sum < target) start++;
            else if (sum > target) end--;
            else {
                res[0] = start+1;
                res[1] = end+1;
                return res;
            }
        }
        return res;
    }
}
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        int start = 0;
        int end = 0;
        List<String> res = new ArrayList<String>();
        if (nums.length == 0) return res;
        int prev = nums[0];
        while (end < nums.length) {
            if (start == end) end++;
            else if (prev != nums[end]-1) {
                if (start == end-1) {
                    res.add(Integer.toString(nums[start]));
                } else {
                    res.add(nums[start] + "->" + nums[end-1]);
                }
                start = end;
                prev = nums[end++];
            } else {
                prev = nums[end++];
            }
        }
        if (start == end-1) {
            res.add(Integer.toString(nums[start]));
        } else {
            res.add(nums[start] + "->" + nums[end-1]);
        }
        return res;
    }
}
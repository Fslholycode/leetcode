public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int result = 0;
        int nowres = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                result = Math.max(result,nowres);
                nowres = 0;
            }
            else {
                nowres++;
            }
        }
        return Math.max(nowres,result);
    }
}

concise solution
public int findMaxConsecutiveOnes(int[] nums) {
    int maxHere = 0, max = 0;
    for (int n : nums)
        max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
    return max; 
}
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i  = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1) != 0) {
                    sum++;
                    sum%=3;
                }
            }
            if(sum != 0) {
                res += 1 << i;
            }
        }
        return res;
    }
    
}
class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int max = 0;
        int num = 0;
        int[] dpl = new int[nums.length];
        int[] dpc = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dpl[i] = dpc[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dpl[i] == dpl[j] + 1) dpc[i] += dpc[j];
                    if (dpl[i] < dpl[j] + 1) {
                        dpl[i] = dpl[j] + 1;
                        dpc[i] = dpc[j];
                    } 
                }
            }
            if (max == dpl[i]) num += dpc[i];
            if (max < dpl[i]) {
                max = dpl[i];
                num = dpc[i];
            }
        }
        return num;
    }
}
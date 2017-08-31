class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] max = new int[k];
        for (int i = 0; i < k; i++) {
            max[i] = Integer.MIN_VALUE;
        }
        int i = 0;
        while (i < nums.length) {
            for (int j = k-1; j >= 0; j--) {
                if (nums[i] > max[j]) {
                    for (int m = 0; m <= j-1; m++) {
                        max[m] = max[m+1];
                    }
                    max[j] = nums[i];
                    break;
                }
            }
            i++;
        }
        return max[0];
    }
}
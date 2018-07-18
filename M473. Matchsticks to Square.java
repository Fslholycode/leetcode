class Solution {
    public boolean makesquare(int[] nums) {
        if (nums.length == 0) return false;
        int sum = 0;
        for (int num:nums) sum+=num;
        if (sum%4 != 0) return false;
        int side = sum/4;
        Arrays.sort(nums);
        reverse(nums);
        boolean[] visited = new boolean[nums.length];
        int[] each = new int[4];
        return helper(nums, side,each, 0);
    }
    public boolean helper(int[] nums, int side, int[] each, int pos) {
        if (pos == nums.length) {
            if (each[0] == side && each[1] == side && each[2] == side) return true;
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (nums[pos] +each[i] > side) continue;
            each[i] += nums[pos];
            if (helper(nums, side, each, pos+1)) return true;
            each[i] -= nums[pos];
        }
        return false;
        
    }
    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j--;
        }
    }
}
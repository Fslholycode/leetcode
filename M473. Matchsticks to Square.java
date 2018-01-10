class Solution {
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) return false;
        Arrays.sort(nums);
        reverse(nums);
        int sum = 0;
        for (int num:nums) {
            sum += num;
        }
        int target = sum/4;
        if (sum%4 != 0) return false;
        int[] each = new int[4];
        return dfs(nums, target, each, 0);
    }
    public boolean dfs(int[] nums, int target, int[] each, int pos) {
        if (pos == nums.length-1) {
            if (each[0] == target && each[1] == target && each[2] == target) return true;
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (nums[pos] + each[i] > target) continue;
            each[i] += nums[pos];
            if (dfs(nums, target, each, pos+1)) return true;
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
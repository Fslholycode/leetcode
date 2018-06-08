class Solution {
    double eps = 0.00001;
    public boolean judgePoint24(int[] nums) {
        return helper(new double[] {nums[0], nums[1], nums[2], nums[3]});
    }
    public boolean helper(double[] nums) {
        if (nums.length == 1) {
            return Math.abs(nums[0]-24.0) < eps;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                double[] b = new double[nums.length-1];
                for (int k = 0, m = 0; k < nums.length; k++) {
                    if (k != i && k != j) b[m++] = nums[k];
                }
                for (double d : compute(nums[i],nums[j])) {
                    b[nums.length-2] = d;
                    if (helper(b)) return true;
                }
            }
        }
        return false;
    }
    public double[] compute (double a, double b) {
        return new double[] {a+b, a-b,b-a,a*b, a/b, b/a};
    }
}
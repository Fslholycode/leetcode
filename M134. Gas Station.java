class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int sum = 0;
        int res = 0;
        for (int i = 0; i < gas.length; i++) {
            sum+=gas[i]-cost[i];
            if (sum < 0) {
                total += sum;
                res = i+1;
                sum = 0;
            }
        }
        total += sum;
        return total >= 0? res:-1;
    }
}
public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int sum = n, remain;
        while (set.add(sum)) {
            remain = 0;
            while (sum > 0) {
                remain += (sum%10)*(sum%10);
                sum = sum/10;
            }
            sum = remain;
            if (remain == 1) return true;
        }
        return false;
    }
}
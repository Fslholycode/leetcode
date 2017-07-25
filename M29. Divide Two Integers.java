public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1:1;
        long dd = Math.abs((long)dividend);
        long dr = Math.abs((long)divisor);
        int res = 0;
        while (dd >= dr) {
            long temp = dr, multiple = 1;
            while (dd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            dd -= temp;
            res += multiple;
        }
        return sign == 1? res:-res;
    }
}
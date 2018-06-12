public class Solution {
    int base = 1337;
    public int superPow(int a, int[] b) {
        return helper(a, b, b.length-1);
    }
    public int helper(int a, int[] b, int pos) {
        a %= base;
        if (pos < 0) return 1;
        return powmod(helper(a, b, pos-1),10)*powmod(a, b[pos])%1337;
    }
    public int powmod(int a, int k) {
        a %= base;
        int result = 1;
        for (int i = 0; i < k; ++i)
            result = (result * a) % base;
        return result;
    }
}
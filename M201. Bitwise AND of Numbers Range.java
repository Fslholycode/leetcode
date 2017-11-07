class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) return 0;
        int index = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            index <<= 1;
        }
        return m*index;
    }
}
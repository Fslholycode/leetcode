class Solution {
    public boolean hasAlternatingBits(int n) {
        int mask = Integer.highestOneBit(n);
        int i = mask;
        while (i > 0) {
            i /= 4;
            mask += i;
        }
        return mask == n;
    }
}
public class Solution {
    public int hammingDistance(int x, int y) {
        int add = x ^ y;
        int res = 0;
        while (add != 0) {
            int sum = add & 1;
            if (sum == 1) res++;
            add = add >> 1;
        }
        return res;
    }
}
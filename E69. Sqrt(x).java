public class Solution {
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int left = 0, right = Integer.MAX_VALUE;
        while (left+1 < right) {
            int mid = left + (right-left)/2;
            if (mid > x/mid) {
                right = mid;
            } else if (mid < x/mid) {
                left = mid;
            } else {
                return mid;
            }
        }
        int res = (left == 0)?1:left;
        return res;
    }
}
public class Solution {
    public boolean judgeSquareSum(int c) {
        int a = 0, b = (int)(Math.sqrt(c)+1);
        while (a <= b) {
            if (a*a+b*b > c) {
                b -= 1;
            } else if (a*a+b*b == c) {
                return true;
            } else {
                a += 1;
            }
        }
        return false;
    }
}
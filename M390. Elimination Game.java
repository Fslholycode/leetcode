class Solution {
    public int lastRemaining(int n) {
        int head = 1;
        int step = 0;
        boolean left = true;
        while (n > 1) {
            if (left || n%2 == 1) {
                head = head+(int)Math.pow(2,step);
            }
            step++;
            n /= 2;
            left = !left;
        }
        return head;
    }
}
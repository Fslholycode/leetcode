class Solution {
    public int rotatedDigits(int N) {
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (isValid(i)) res++;
        }
        return res;
    }
    public boolean isValid(int n) {
        boolean res = false;
        while (n != 0) {
            if (n%10 == 2) res = true;
            if (n%10 == 5) res = true;
            if (n%10 == 6) res = true;
            if (n%10 == 9) res = true;
            if (n%10 == 3) return false;
            if (n%10 == 4) return false;
            if (n%10 == 7) return false;
            n = n/10;
        }
        return res;
    }
}
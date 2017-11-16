class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int len = digits.length;
        int[] dp = new int[len];
        dp[len-1] = digits[len-1]-'0';
        for (int i = len-2; i >= 0; i--) {
            dp[i] = Math.max(digits[i]-'0', dp[i+1]);
        }
        
        for (int i = 0; i < len; i++) {
            if (digits[i]-'0' == dp[i]) continue;
            else {
                int s1 = i;
                int k = i+1;
                while (k < len && dp[k] == dp[k-1]) {
                    k++;
                }
                char c = digits[i];
                digits[i] = digits[k-1];
                digits[k-1] = c;
                break;
            }
        }
        return Integer.valueOf(new String(digits));
    }
}
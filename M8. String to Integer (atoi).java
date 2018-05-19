class Solution {
    public int myAtoi(String str) {
        if (str.length() == 0) return 0;
        int num_sign = 0;
        int num_digit = 0;
        int sign = 1;
        long num = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '+' || c == '-') {
                num_sign++;
                if (num_digit > 0) break;
                if (num_sign >= 2) return 0;
                if (c == '-') sign = -1;
            }
            else if (c == ' ') {
                if (num_digit == 0 && num_sign == 0) continue;
                else break;
            }
            else if (c >= '0' && c <= '9') {
                num = num*10+str.charAt(i)-'0';
                num_digit = 1;
                if (num > Integer.MAX_VALUE) break;
            }
            else break;
        }
        if (num > Integer.MAX_VALUE) return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
        return (int)(sign*num);
    }
}
public class Solution {
    public boolean checkRecord(String s) {
        int num1 = 0, num2 = 0, num3 = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') num1++;
            if (c == 'L') {
                if (i > 0 && s.charAt(i-1) == 'L') num3++;
                else num3 = 1;
            }
            num2 = Math.max(num2,num3);
        }
        if (num1 <= 1 && num2 <= 2) return true;
        else return false;
    }
}
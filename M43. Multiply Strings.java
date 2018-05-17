class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1+len2];
        
        for (int i = len1-1; i >= 0; i--) {
            for (int j = len2-1; j >= 0; j--) {
                int p = i+j;
                int q = i+j+1;
                int sum = res[q]+(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                
                res[q] = sum%10;
                res[p] += sum/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (!(sb.length() == 0 && res[i] == 0)) sb.append(res[i]);
        }
        return sb.length() == 0? "0":sb.toString();
    }
}
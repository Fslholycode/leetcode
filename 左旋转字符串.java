public class Solution {
    public String LeftRotateString(String str,int n) {
        if (str.length() == 0) return str;
        char[] array = str.toCharArray();
        reverse(array, 0, n-1);
        reverse(array, n, str.length()-1);
        reverse(array, 0, str.length()-1);
        return String.valueOf(array);
    }
    public void reverse(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}
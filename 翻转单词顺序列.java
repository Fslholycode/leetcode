public class Solution {
    public String ReverseSentence(String str) {
        char[] array = str.toCharArray();
        reverse(array, 0, array.length-1);
        int pre = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ') {
                reverse(array, pre, i-1);
                pre = i+1;
            }
        }
        reverse(array, pre, array.length-1);
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
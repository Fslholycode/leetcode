class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int len = s.length();
        int index = 0;
        while (len >= 2*k) {
            reverse(arr, index, index+k-1);
            len-=2*k;
            index+=2*k;
        }
        reverse(arr, index, index+Math.min(k-1, len-1));
        return String.valueOf(arr);
    }
    public void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
} 
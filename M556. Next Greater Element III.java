class Solution {
    public int nextGreaterElement(int n) {
        char[] arr = (n+"").toCharArray();
        int i;
        for (i = arr.length-1; i > 0; i--) {
            if (arr[i] > arr[i-1]) break;
        }
        if (i == 0) return -1;
        int smallest = i;
        for (int j = i; j < arr.length; j++) {
            if (arr[j] < arr[smallest] && arr[j] > arr[i-1]) smallest = j;
        }
        char temp = arr[i-1];
        arr[i-1] = arr[smallest];
        arr[smallest] = temp;
        Arrays.sort(arr, i, arr.length);
        long res = Long.parseLong(new String(arr));
        return res > Integer.MAX_VALUE?-1:(int)res;
    }
}
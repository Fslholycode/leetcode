public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        if (len == 0) return 0;
        int[] ar = new int[len+1];
        for (int i = 0; i < len; i++) {
            if (citations[i] >= len) ar[len]++;
            else ar[citations[i]]++;
        }
        int sum = 0;
        for (int i = len; i >= 0; i--) {
            sum += ar[i];
            if (sum >= i) return i;
        }
        return 0;
    }
}
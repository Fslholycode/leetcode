class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        int lo = 0, len = citations.length, hi = len-1;
        while (lo + 1 < hi) {
            int mid = lo + (hi-lo)/2;
            if (citations[mid] == len - mid) return len-mid;
            else if (citations[mid] < len - mid) lo = mid;
            else hi = mid;  
        } 
        if (citations[lo] >= len - lo) return len-lo;
        if (citations[hi] >= len - hi) return len-hi;
        return 0;
    }
}
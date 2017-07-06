public class Solution {
    public int strStr(String haystack, String needle) {
        int length1 = needle.length();
        int length2 = haystack.length();
        if (length1 > length2) return -1;
        for (int i = 0; i <= length2-length1; i++) {
            if (needle.equals(haystack.substring(i, i+length1))) return i;
        }
        return -1;
    }
}
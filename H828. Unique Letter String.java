class Solution {
    public int uniqueLetterString(String S) {
        int[] contribution = new int[128];
        int[] lastshow = new int[128];
        int cur = 0;
        int res = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            cur -= contribution[c];
            contribution[c] = i - lastshow[c]+1;
            cur += contribution[c];
            lastshow[c] = i+1;
            res += cur;
        }
        return res;
    }
}
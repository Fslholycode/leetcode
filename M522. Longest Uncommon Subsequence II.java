class Solution {
    public int findLUSlength(String[] strs) {
        for (int i = 10; i >= 0; i--) {
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length() == i) {
                    int count = 0;
                    for (int z = 0; z < strs.length; z++) {
                        if (strs[z].length() >= i && isSub(strs[z], strs[j])) count++;
                    }
                    if (count == 1) return i;
                }
            }
        }
        return -1;
    }
    public boolean isSub(String s1, String s2) {
        int i = 0, j = 0;
        for (; i < s1.length() && j < s2.length(); i++) {
            if (s1.charAt(i) == s2.charAt(j)) j++;
        }
        return j == s2.length();
    }
}
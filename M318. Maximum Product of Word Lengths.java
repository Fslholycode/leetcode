class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        int len = words.length;
        int res = 0;
        int[] val = new int[len];
        for (int i = 0; i < len; i++) {
            for (char c : words[i].toCharArray()) {
                val[i] |= 1 << c-'a';
            }
        }
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                int max = words[i].length()*words[j].length();
                if (max <= res) continue;
                if ((val[i] & val[j]) == 0) res = max;
            }
        }
        return res;
    }
}
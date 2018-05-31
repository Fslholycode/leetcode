class Solution {
    public int minimumLengthEncoding(String[] words) {
        int res = 0;
        Trie trie = new Trie();
        List<Trie> list = new ArrayList();
        for (String s : words) {
            char[] arr = s.toCharArray();
            Trie t = trie;
            boolean isVisited = true;
            for (int i = arr.length-1; i >= 0; i--) {
                int c = arr[i]-'a';
                if (t.child[c] == null) {
                    isVisited = false;
                    t.child[c] = new Trie();
                    t = t.child[c];
                } else {
                    t = t.child[c];
                }
            }
            t.depth = arr.length;
            if (!isVisited) list.add(t);
        }
        for (Trie tr : list) {
            int i = 0;
            for (i = 0; i < 26; i++) {
                if (tr.child[i] != null) break;
            }
            if (i == 26) res += tr.depth+1;
        }
        return res;
    }
    class Trie {
        Trie[] child = new Trie[26];
        int depth = 0;
    }
}
class Solution {
    class Trie {
        Trie[] children = new Trie[26];
        String val = "";
        public Trie() {
        }
    }
    public String replaceWords(List<String> dict, String sentence) {
        Trie node = new Trie();
        for (String s:dict) {
            Trie cur = node;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (cur.children[c-'a'] == null) cur.children[c-'a'] = new Trie();
                cur = cur.children[c-'a'];
            }
            cur.val = s;
        }
        StringBuilder sb = new StringBuilder();
        String[] arr = sentence.split(" ");
        for (int j = 0; j < arr.length; j++) {
            String s = arr[j];
            Trie temp = node;
            boolean change = false;
            if (j != 0) sb.append(" ");

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (temp.children[c-'a'] != null) {
                    if (!temp.children[c-'a'].val.equals("")) {
                        sb.append(s.substring(0,i+1));
                        change = true;
                        break;
                    }
                    else temp = temp.children[c-'a'];
                } else break;
            }
            if (!change) sb.append(s);
        }
        return sb.toString();
    }
}
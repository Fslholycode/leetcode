class Solution {
    List<String> res = new ArrayList();
    int[][] dirs = {{0,1}, {-1, 0}, {1, 0}, {0,-1}};
    public List<String> findWords(char[][] board, String[] words) {
        trieNode root = new trieNode();
        root = buildTrie(words, root);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                visited[i][j] = true;
                if (root.next[board[i][j]-'a'] != null) dfs(board, i, j, root.next[board[i][j]-'a'], visited);
            }
        }
        return res;
    }
    
    public void dfs(char[][] board, int row, int col, trieNode node, boolean[][] visited) {
        if (!node.word.equals("")) {
            res.add(node.word);
            node.word = "";
        }
        for (int[] dir:dirs) {
            int newx = row+dir[0];
            int newy = col+dir[1];
            if (newx < 0 || newx >= board.length || newy < 0 || newy >= board[0].length || visited[newx][newy] || node.next[board[newx][newy]-'a'] == null) continue;
            visited[newx][newy] = true;
            dfs(board, newx, newy, node.next[board[newx][newy]-'a'], visited);
            visited[newx][newy] = false;
        }
        return;
    }
    public trieNode buildTrie(String[] words, trieNode root) {
        for (String word : words) {
            trieNode cur = root;
            for (char c:word.toCharArray()) {
                if (cur.next[c-'a'] == null) cur.next[c-'a'] = new trieNode();
                cur = cur.next[c-'a'];
            }
            cur.word = word;
        }
        return root;
    }
        
    class trieNode {
        trieNode[] next = new trieNode[26];
        String word = "";
    } 
}
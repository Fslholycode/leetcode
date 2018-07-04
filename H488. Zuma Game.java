class Solution {
    public int findMinStep(String board, String hand) {
        int[] handcount = new int[26];
        for (int i = 0; i < hand.length(); i++) {
            handcount[hand.charAt(i)-'A']++;
        }
        int res = helper(board+"#", handcount);
        return res > hand.length()?-1:res;
    }
    public int helper(String board, int[] h) {
        board = removeConsecutive(board);
        if (board.equals("#")) return 0;
        int res = 6;
        for (int i = 0, j = 0; i < board.length(); i++) {
            if (board.charAt(i) == board.charAt(j)) continue;
            if (h[board.charAt(j)-'A'] >= 3-(i-j)) {
                h[board.charAt(j)-'A'] -= 3-(i-j);
                res = Math.min(res, 3-(i-j)+helper(board.substring(0,j)+board.substring(i), h));
                h[board.charAt(j)-'A'] += 3-(i-j);
            }
            j = i;
        }
        return res;
    }
    public String removeConsecutive(String s) {
        
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(j)) continue;
            if (i-j>2) return removeConsecutive(s.substring(0, j)+s.substring(i));
            else j = i;
        }
        return s;
    }
}
class Solution {
    public boolean judgeCircle(String moves) {
        int[] res = new int[2];
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'R') res[0]++;
            if (c == 'L') res[0]--;
            if (c == 'U') res[1]++;
            if (c == 'D') res[1]--;
        }
        if (res[0] == 0 && res[1] == 0) return true;
        return false;
    }
}
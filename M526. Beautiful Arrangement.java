class Solution {
    int count = 0;
    public int countArrangement(int N) {
        int[] used = new int[N+1];
        helper(N, 1, used);
        return count;
    }
    public void helper(int N, int pos, int[] used) {
        if (N < pos) {
            count++;
            return;
        }
        for (int i = 1; i < N+1; i++) {
            if (used[i] == 0 && (pos%i == 0 || i%pos == 0)) {
                used[i] = 1;
                helper(N,pos+1,used);
                used[i] = 0;
            }
        } 
    }
}
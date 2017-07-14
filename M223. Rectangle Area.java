public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int[] wid = {A,C,E,G};
        int[] len = {B,D,F,H};
        Arrays.sort(wid);
        Arrays.sort(len);
        if (E >= C || F >= D || A >= G || B >= H) return (C-A)*(D-B) + (G-E)*(H-F);
        else return (C-A)*(D-B) + (G-E)*(H-F) - (wid[2]-wid[1])*(len[2]-len[1]);
    }
}
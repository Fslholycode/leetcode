class Solution {
    public int minSwap(int[] A, int[] B) {
        int count = 0;
        int len = A.length;
        int[] swap = new int[2];
        int[] noswap = new int[2];
        swap[0] = 1;
        for (int i = 1; i < len; i++) {
            if (A[i] <= A[i-1] || B[i] <= B[i-1]) {
                swap[i%2] = noswap[(i-1)%2]+1;
                noswap[i%2] = swap[(i-1)%2];
            } 
            else if (A[i] <= B[i-1] || B[i] <= A[i-1]) {
                swap[i%2] = swap[(i-1)%2]+1;
                noswap[i%2] = noswap[(i-1)%2];
            }
            else {
                swap[i%2] = Math.min(swap[(i-1)%2], noswap[(i-1)%2])+1;
                noswap[i%2] = Math.min(swap[(i-1)%2], noswap[(i-1)%2]);
            }
        }
        return Math.min(swap[(len-1)%2],noswap[(len-1)%2]);
    }
}
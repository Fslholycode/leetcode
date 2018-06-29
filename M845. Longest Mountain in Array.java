class Solution {
    public int longestMountain(int[] A) {
        int[][] res = new int[A.length][2];
        int cur = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i-1]) res[i][0] = cur++;
            else cur = 1;
        }
        cur = 1;
        for (int i = A.length-2; i>=0; i--) {
            if (A[i] > A[i+1]) res[i][1] = cur++;
            else cur = 1;
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (res[i][0] > 0 && res[i][1] > 0) result = Math.max(1+res[i][0]+res[i][1], result);
        }
        return result < 3?0:result;
    }
}
class Solution {
    public int maxRotateFunction(int[] A) {
        int sum = 0;
        int f = 0;
        for (int i = 0; i < A.length; i++) {
            sum+=A[i];
            f+=i*A[i];
        }
        int res = f;
        int index = A.length-1;
        while (index > 0) {
            f = f-(A.length-1)*A[index]+sum-A[index];
            res = Math.max(res, f);
            index--;
        }
        return res;
    }
}
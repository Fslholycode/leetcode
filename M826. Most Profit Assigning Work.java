class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] work = new int[difficulty.length][2];
        for (int i = 0; i < difficulty.length; i++) {
            work[i][0] = difficulty[i];
            work[i][1] = profit[i];
        }
        Arrays.sort(work, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return a[1]-b[1];
                else return a[0]-b[0];
            }
        });
        Arrays.sort(worker);
        int i = 0;
        int res = 0;
        int maxp = 0;
        for (int ability:worker) {
            while (i < work.length && ability >= work[i][0]) {
                maxp = Math.max(maxp, work[i][1]);
                i++;
            }
            res+=maxp;
        }
        return res;
    }
}
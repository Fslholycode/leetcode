class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]> (new Comparator<int[]>() {
            public int compare(int[] a, int [] b) {
                int r1 = A[a[0]]*A[b[1]];
                int r2 = A[a[1]]*A[b[0]];
                return r1-r2;
            }
        });
        int count = K;
        for (int i = 0; i < A.length-1; i++) {
            pq.add(new int[]{i, A.length-1});
            if (--count == 0) break;
        }
        while (!pq.isEmpty()) {
            if (--K == 0) break;
            int[] arr = pq.poll();
            arr[1]--;
            if (arr[1] > arr[0]) pq.offer(arr);
        }
        int[] res = {A[pq.peek()[0]], A[pq.peek()[1]]};
        return res;
    }
}
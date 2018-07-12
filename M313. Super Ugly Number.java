class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<pair> pq = new PriorityQueue();
        for (int i = 0; i < primes.length; i++) {
            pq.add(new pair(primes[i], 1, primes[i]));
        }
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = pq.peek().val;
            while (pq.peek().val == res[i]) {
                pair cur = pq.poll();
                pq.add(new pair(res[cur.index]*cur.prime, cur.index+1, cur.prime));
            }
        }
        return res[n-1];
    }
    class pair implements Comparable<pair>{
        int val;
        int index;
        int prime;
        
        public pair(int val, int index, int prime) {
            this.val = val;
            this.index = index;
            this.prime = prime;
        }
        
        @Override
        public int compareTo(pair that) {
            return this.val-that.val;
        }
    }
}
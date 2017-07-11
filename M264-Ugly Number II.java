import java.util.PriorityQueue;

public class Solution {
    public int nthUglyNumber(int n) {
        long result = 0;
        PriorityQueue<Long>  pq = new PriorityQueue<Long>();
        pq.add((long) 1);
        while (n > 0) {
            result = pq.poll();
            if (!pq.contains(result*2)) {pq.add(result*2);}
            if (!pq.contains(result*3)) {pq.add(result*3);}
            if (!pq.contains(result*5)) {pq.add(result*5);}
            n--;
        }
        return (int) result;
    }
    public static void main (String[] args) {
    	    System.out.println(new Solution().nthUglyNumber(1600));
    }
}

//DP
public class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int t1 = 0, t2 = 0, t3 = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[t1]*2, Math.min(dp[t2]*3, dp[t3]*5));
            if (dp[i] == dp[t1]*2) t1++;
            if (dp[i] == dp[t2]*3) t2++;
            if (dp[i] == dp[t3]*5) t3++;
        }
        return dp[n-1];
    }
}
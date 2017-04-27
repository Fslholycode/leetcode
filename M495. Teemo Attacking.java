public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        int last = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            int now = timeSeries[i]+duration;
            if (last < now) {
                res += now-Math.max(last,timeSeries[i]);
            } 
            last = Math.max(now,last);
        }
        return res;
    }
}
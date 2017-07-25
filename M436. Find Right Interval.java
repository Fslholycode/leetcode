/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    int[] start;
    public int[] findRightInterval(Interval[] intervals) {
        int[] res = new int[intervals.length];
        if (intervals.length == 1) res[0] = -1;
        start = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            res[i] = -1;
        }
        Arrays.sort(start);
        for (int i = 0; i < intervals.length; i++) {
            int index = intervals[i].end;
            int left = 0, right = intervals.length-1;
            while (left + 1 < right) {
                int mid = left + (right-left)/2;
                if (start[mid] == index){
                    res[i] = find(intervals, mid);
                    break;
                } else if (start[mid] > index) {
                    right = mid;
                } else left = mid;
            }
            if (res[i] == -1 && start[right] >= index) {
                res[i] = find(intervals,right);
            }
        }
        return res;
    }
    public int find(Interval[] intervals, int mid) {
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i].start == start[mid])
                return i;
        }
        return -1;
    }
}
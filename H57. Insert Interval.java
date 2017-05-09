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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        int start = newInterval.start;
        int end = newInterval.end;
        boolean add = false;
        for (Interval interval:intervals) {
            if (interval.end >= newInterval.end && interval.start <= newInterval.start) {
                res.add(interval);
                add = true;
            } else if (interval.end < newInterval.start) {
                res.add(interval);
            } else if (interval.start > newInterval.end) {
                if (!add) {
                    res.add(newInterval);
                    add = true;
                }
                res.add(interval);
            } else if (interval.end < newInterval.end && interval.start > newInterval.start) {
                continue;
            } else if (interval.start < newInterval.start && interval.end <= newInterval.end) {
                newInterval.start = interval.start;
            } else if (interval.end > newInterval.end && interval.start > newInterval.start) {
                newInterval.end = interval.end;
            }
        }
        if (!add) res.add(newInterval);
        return res;
    }
}
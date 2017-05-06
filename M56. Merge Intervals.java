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
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval obj0, Interval obj1) {
                return obj0.start - obj1.start;
            }
        });
        Interval prev = null;
        List<Interval> res = new ArrayList<Interval>();
        for (Interval inter:intervals) {
            if (prev == null || prev.end < inter.start) {
                res.add(inter);
                prev = inter;
            } else if (prev.end < inter.end) prev.end = inter.end;
        }
        return res;
    }
}
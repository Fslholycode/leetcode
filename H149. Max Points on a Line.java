/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        int len = points.length;
        if (len <= 2) return points.length;
        int res = 0;
        for (int i = 0; i < len-1; i++) {
            Map<String, Integer> map = new HashMap<>();
            int overlap = 0;
            int lineMax = 0;
            for (int j = i+1; j < len; j++) {
                int x = points[i].x-points[j].x;
                int y = points[i].y-points[j].y;
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd = helper(x,y);
                x /= gcd;
                y /= gcd;
                String slope = String.valueOf(x) + String.valueOf(y);
                int num = map.getOrDefault(slope,0);
                num++;
                map.put(slope, num);
                lineMax = Math.max(lineMax, num);
            }
            res = Math.max(res, lineMax+overlap+1);
        }
        return res;
    }
    public int helper(int a, int b) {
        if (b == 0) return a;
        return helper(b, a%b);
    }
}

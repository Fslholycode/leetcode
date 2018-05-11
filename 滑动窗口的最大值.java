import java.util.*;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList();
        if (num.length == 0 || size == 0) return res;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            int begin = i-size+1;
            if (q.isEmpty()) q.add(i);
            else if (begin > q.peekFirst()) q.pollFirst();
            while (!q.isEmpty() && num[q.peekLast()] <= num[i]) q.pollLast();
            q.add(i);
            if (begin >= 0) res.add(num[q.peekFirst()]);
        }
        return res;
    }
}
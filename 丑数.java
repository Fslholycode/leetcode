import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 1) return index;
        Queue<Long> q = new PriorityQueue<Long>();
        Set<Long> set = new HashSet<Long>();
        set.add((long)1);
        q.offer((long)1);
        long num = 1;
        while (--index >= 0) {
            num = q.poll();
            if (set.add(num*2)) q.offer(num*2);
            if (set.add(num*3)) q.offer(num*3);
            if (set.add(num*5)) q.offer(num*5);
        }
        return (int)num;
    }
}

//最优解
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index < 7) return index;
        int[] r = new int[index];
        r[0] = 1;
        int t2 = 0,t3 = 0,t5 = 0;
        for(int i = 1;i < index;i++){
            r[i] = Math.min(r[t2] * 2,Math.min(r[t3] * 3,r[t5] * 5));
            if(r[i] == r[t2] * 2) t2++;
            if(r[i] == r[t3] * 3) t3++;
            if(r[i] == r[t5] * 5) t5++;
        }
        return r[index-1];
    }
}

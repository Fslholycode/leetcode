import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        int small = 1;
        int big = 2;
        int cur = small+big;
        while (small < big && small <= (sum+1)/2) {
            if (cur < sum) {
                big++;
                cur+=big;
            } else if (cur == sum) {
                ArrayList<Integer> list = new ArrayList();
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                res.add(list);
                big++;
                cur+=big;
            } else {
                cur-=small;
                small++;
            }
        }
        return res;
    }
}
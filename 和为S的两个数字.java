import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> res = new ArrayList();
        Map<Integer, Integer> map = new HashMap();
        int[] cur = new int[2];
        int dif = 0;
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(sum-array[i])) {
                if (i - map.get(sum-array[i]) > dif) {
                    cur[0] = sum-array[i];
                    cur[1] = array[i];
                    dif = i-map.get(sum-array[i]);
                }
            } else map.put(array[i], i);
        }
        if (cur[0] == 0 && cur[1] == 0) return res;
        res.add(cur[0]);
        res.add(cur[1]);
        return res;
    }
}

//best solution
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> res = new ArrayList();
        int left= 0;
        int right = array.length-1;
        while (left < right) {
            if (array[left]+array[right] > sum) right--;
            else if (array[left] + array[right] == sum) {
                res.add(array[left]);
                res.add(array[right]);
                return res;
            } else left++;
        }
        return res;
    }
}
import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) return 0;
        int start = 0;
        int end = array.length-1;
        while (start < end) {
            int mid = start + (end-start)/2;
            if (array[end] < array[mid]) start = mid+1;
            else if (array[end] > array[mid]) end = mid;
            else {
                int res = Integer.MAX_VALUE;
                for (int i = 0; i < array.length; i++) {
                    res = Math.min(res, array[i]);
                }
                return res;
            }
        }
        return array[start];
    }
}
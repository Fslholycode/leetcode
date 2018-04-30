import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
public class Solution {
    int count = 0;
    public int InversePairs(int [] array) {
        if(array==null||array.length==0) return 0;
        helper(array,0,array.length-1);//数值过大求余
        return count%1000000007;
    }
    public void helper(int[] array, int start, int end) {
        if (start == end) return;
        int mid = start+(end-start)/2;
        helper(array, start, mid);
        helper(array, mid+1, end);
        merge(array, start ,mid, end);
    }
    public void merge(int[] a, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (a[i] <= a[j])
                tmp[k++] = a[i++];
            else {
                tmp[k++] = a[j++];
                count += (mid - i + 1)%1000000007;  // core code, calculate InversePairs............
                count %= 1000000007;
            }
        }
        while (i <= mid)
            tmp[k++] = a[i++];
        while (j <= end)
            tmp[k++] = a[j++];
        for (k = 0; k < tmp.length; k++)
            a[start + k] = tmp[k];
    }
}
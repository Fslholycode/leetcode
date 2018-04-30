import java.util.ArrayList;
public class Solution {
    ArrayList<Integer> res  = new ArrayList();
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input.length == 0 || k <= 0 || k > input.length) return res;
        partition(input, k, 0, input.length-1);
        return res;
    }
    public void partition(int[] input, int k, int start, int end) {
        int num = input[start];
        int index = start;
        swap(input, start, end);
        for (int i = start; i < end; i++) {
            if (input[i] < num) {
                swap(input, i, index++);
            }
        }
        swap(input, end, index);
        if (index+1-start > k) partition(input, k, start, index);
        else if (index+1-start == k) getRes(input, k, start);
        else {
            getRes(input, index+1-start, start);
            partition(input, k-index-1+start, index+1, end);
        }
    }
    public void getRes(int[] input, int k, int start) {
        for (int i = start; i <= start+k-1; i++) res.add(input[i]);
    }
    public void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
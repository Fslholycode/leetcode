import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int num = nums[0]-1;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Helper(res, nums, new ArrayList<Integer>(), 0, num);
        res.add(new ArrayList<Integer>());
        return res;
    }
    public void Helper(List<List<Integer>> res, int[] nums, ArrayList<Integer> list, int pos, int num) {
        for (int i = pos; i < nums.length; i++) {
            if (num == nums[i]) {
                continue;
            }
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            Helper(res, nums, list, i+1,num);
            num = list.get(list.size()-1);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
    	    int[] a = {1,2,2};
    	    System.out.println(new Solution().subsetsWithDup(a));
    }
}
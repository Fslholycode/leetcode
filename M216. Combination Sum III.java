import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        Helper(res, new ArrayList<Integer>(), k, n, 1);
        return res;
    }
    
    public void Helper(List<List<Integer>> res, ArrayList<Integer> list, int k, int n, int pos) {
    	    if (k == 0 && n == 0) {
    	    	    	    res.add(new ArrayList<Integer>(list));//reference，必须复制
    	    } else {
	        for (int i = pos; i <= 9 && n > 0 && k > 0 ; i++) {
	        	    list.add(i);
	        	    Helper(res, list, k-1, n-i, i+1);
	        	    list.remove(list.size()-1);
	        }
    	    }
    }
    public static void main(String[] args) {
    	    System.out.println(new Solution().combinationSum3(2,7));
    }
}
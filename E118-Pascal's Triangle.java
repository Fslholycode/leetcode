import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) return (List<List<Integer>>)new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> preList = new ArrayList<Integer>();
        preList.add(1);
        result.add(preList);
        while (numRows > 1) {
        		List<Integer> nowList = newLine(preList);
            result.add(nowList);
            preList = nowList;
            numRows--;
            
        } 
        return result;
    }
    public List<Integer> newLine(List<Integer> pre) {
    		List<Integer> result = new ArrayList<Integer>();
        if (pre.size() == 1) {
            result.add(1);
            result.add(1);
        }
        else {
        	    result.add(1);
            for (int i = 1; i < pre.size(); i++) {
                result.add(pre.get(i-1)+pre.get(i));
            }
            result.add(1);
        }
        return result;
    }

    public static void main(String[] args) {
    		int a = 8;
    		System.out.println(new Solution().generate(a));
    }
}
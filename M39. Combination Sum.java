public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int pos=0;
        Helper(res, new ArrayList<Integer>(), candidates, target, pos);
        return res;
    }
    
    public void Helper(List<List<Integer>> res, ArrayList<Integer> list, int[] can, int tar, int pos) {
        for (int i = pos; i < can.length; i++) {
            list.add(can[i]);
            if (tar - can[i] < 0) {
                list.remove(list.size()-1);
                continue;
            }
            if (tar - can[i] == 0) {
                res.add(new ArrayList<Integer>(list));
                list.remove(list.size()-1);
                continue;
            }
            Helper(res, list, can, tar-can[i], i);
            list.remove(list.size()-1);
        }
    }
}
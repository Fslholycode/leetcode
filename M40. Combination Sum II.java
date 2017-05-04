public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int num = candidates[0]-1;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Helper(res, candidates,target, new ArrayList<Integer>(),0,num);
        return res;
    }
    public static void Helper(List<List<Integer>> res, int[] candidates, int target, ArrayList<Integer> list, int pos,int num) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if (target < 0) return;
        for (int i = pos; i < candidates.length; i++) {
            if (num == candidates[i]) continue;
            list.add(candidates[i]);
            Helper(res, candidates, target-candidates[i],list,i+1, num);
            num = list.get(list.size()-1);
            list.remove(list.size()-1);
        }
    }
}
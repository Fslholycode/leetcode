public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, visited, res, new ArrayList());
        return res;
    }
    public void helper(int[] nums, boolean[] visited, List<List<Integer>> res, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && visited[i-1] && nums[i] == nums[i-1]) continue;
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                helper(nums, visited, res, list);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
}
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for (int num:nums) {
            map.put(num, map.getOrDefault(num,0)+1);
            max = Math.max(max, map.get(num));
        }
        List<Integer>[] bucket = new List[max+1];
        for (int num:map.keySet()) {
            int fre = map.get(num);
            if (bucket[fre] == null) bucket[fre] = new ArrayList<>();
            bucket[fre].add(num);
        }
        for (int i = bucket.length-1; i >= 0; i--) {
            if (bucket[i] == null) continue;
            for (int num:bucket[i]) {
                res.add(num);
                k--;
                if (k == 0) return res;
            }
        }
        return res;
    }
}
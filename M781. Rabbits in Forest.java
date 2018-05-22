class Solution {
    public int numRabbits(int[] answers) {
        if (answers == null || answers.length == 0) return 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for (int ans: answers) map.put(ans, map.getOrDefault(ans,0)+1);
        for (int ans : map.keySet()) res += (map.get(ans)+ans)/(ans+1)*(ans+1);
        return res;
    }
}
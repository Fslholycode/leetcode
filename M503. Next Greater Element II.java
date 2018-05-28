class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] newarr = new int[nums.length*2];
        for (int i = 0; i < nums.length; i++) {
            newarr[i] = nums[i];
            newarr[nums.length+i] = nums[i];
        }
        Stack<Integer> s = new Stack();
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < newarr.length; i++) {
            if (!map.containsKey(i%nums.length)) map.put(i, -1);
            while (!s.isEmpty() && newarr[i] > nums[s.peek()]) {
                map.put(s.pop(), newarr[i]);
            }
            s.push(i%nums.length);
        }
        int[] res = new int[nums.length];
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            res[k++] = map.get(i);
        }
        return res;
    }
}
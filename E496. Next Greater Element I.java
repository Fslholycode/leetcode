class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack();
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : nums2) {
            map.put(num, -1);
            while (!s.isEmpty() && s.peek() < num) {
                map.put(s.pop(), num);
            }
            s.push(num);
        }
        int[] res = new int[nums1.length];
        int i = 0;
        for (int num:nums1) {
            res[i++] = map.get(num);
        }
        return res;
    }
}
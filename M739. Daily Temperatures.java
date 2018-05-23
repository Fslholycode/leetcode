class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[temperatures.length];
        Stack<Integer> s = new Stack();
        for (int i = 0; i < len; i++) {
            if (s.isEmpty()) {
                s.push(i);
                continue;
            }
            while (!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                int index = s.pop();
                res[index] = i-index;
            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            res[s.pop()] = 0;
        }
        return res;
    }
}
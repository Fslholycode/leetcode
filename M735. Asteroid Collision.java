class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack();
        for (int i = 0; i < asteroids.length; i++) {
            while (!s.isEmpty() && asteroids[i] < 0 && s.peek() > 0 && Math.abs(asteroids[i]) > s.peek()) {
                s.pop();
            }
            if (!s.isEmpty() && asteroids[i] < 0 && s.peek() > 0 && Math.abs(asteroids[i]) == s.peek()) {
                s.pop();
                continue;
            }
            if (!s.isEmpty() && asteroids[i] < 0 && s.peek() > 0 && Math.abs(asteroids[i]) < s.peek()) {
                continue;
            }
            s.push(asteroids[i]);
        }
        int[] res = new int[s.size()];
        int i = s.size()-1;
        while (!s.isEmpty()) {
            res[i--] = s.pop();
        }
        return res;
    }
}
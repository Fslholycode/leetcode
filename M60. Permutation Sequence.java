class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> num = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) num.add(i);
        int[] fact = new int[n];
        fact[0] = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i-1]*(i);           
        }
        k = k-1;
        for (int i = n; i > 0; i--) {
            int index = k/fact[i-1];
            k = k%fact[i-1];
            sb.append(num.get(index));
            num.remove(index);
        }
        return sb.toString();
    }
}
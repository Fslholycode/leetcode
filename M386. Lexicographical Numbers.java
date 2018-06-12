class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList();
        int cur = 1;
        for (int i = 0; i < n; i++) {
            res.add(cur);
            if (cur * 10 <= n) cur *= 10;
            else if ((cur%10) != 9 && cur+1<=n) cur++;
            else {
                while (cur == n || cur%10 == 9) cur /= 10;
                cur+=1;
            }
        }
        return res;
    }
}

//dfs
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList();
        for (int i = 1; i <= 9; i++) {
            helper(i, n, res);
        }
        return res;
    }
    public void helper(int cur, int n, List<Integer> res) {
        if (cur > n) return;
        res.add(cur);
        for (int i = 0;i < 10; i++) {
            if (10*cur+i <= n) helper(10*cur+i, n, res);
            else return;
        }
    }
}
public class Solution {
    Map<Integer,Integer> amountDict = new HashMap<Integer,Integer>();
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if(amountDict.containsKey(amount))
            return amountDict.get(amount);
        Arrays.sort(coins);
        int num = amount+1;
        for (int i = coins.length-1; i >= 0; i--) {
            int cur = 0;
            if (amount >= coins[i]) {
                cur = 1 + coinChange(coins, amount-coins[i]);
            }
            if (cur > 0) {
                num = Math.min(num, cur);
            }
        }
        int finalCount = (num == amount+1) ? -1 : num;
        amountDict.put(amount,finalCount);
        return finalCount;
    }
}
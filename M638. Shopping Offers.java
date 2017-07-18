public class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return shop(price, special, needs, 0);
    }
    public int shop(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int pos) {
        if (pos == special.size()) return dot(needs, price);
        ArrayList < Integer > clone = new ArrayList < > (needs);
        int j;
        for (j = 0; j < special.get(pos).size()-1; j++) {
            if (clone.get(j) < special.get(pos).get(j)) break;
            clone.set(j, clone.get(j) - special.get(pos).get(j));
        }
        if (j == special.get(pos).size()-1) {
            return Math.min(special.get(pos).get(j) + shop(price, special, clone, pos), shop(price, special, needs, pos + 1));
        } else 
            return shop(price, special, needs, pos + 1);
    }
    public int dot(List<Integer> needs, List<Integer> price) {
        int sum = 0;
        for (int i = 0; i < needs.size(); i++) {
            sum += needs.get(i)*price.get(i);
        }
        return sum;
    }
}
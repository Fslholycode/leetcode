public class Solution {
    public String[] findWords(String[] words) {
        int[] alpha = {2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3};
        List<String> res = new ArrayList<>();
        for (String word:words) {
            int num = word.toLowerCase().charAt(0) - 97;
            int i;
            for (i = 1; i < word.length(); i++) {
                int num1 = word.toLowerCase().charAt(i) - 97;
                if (alpha[num] != alpha[num1]) {
                    break;
                }
            }
            if (word.length() == 1 || i == word.length()) {
                res.add(word);
            }
        }
        return res.toArray(new String[0]);
    }
}
class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList();
        char[] arr = S.toCharArray();
        helper(arr, res, 0);
        res.add(S);
        return res;
    }
    public void helper(char[] arr, List<String> res, int pos) {
        for (int i = pos; i < arr.length; i++) {
            if (arr[i] >= 'a' && arr[i] <= 'z') {
                arr[i] = (char)(arr[i]-'a'+'A');
                res.add(String.valueOf(arr));
                helper(arr, res, i+1);
                arr[i] = (char)(arr[i]-'A'+'a');
            } else if (arr[i] >= 'A' && arr[i] <= 'Z') {
                arr[i] = (char)(arr[i]-'A'+'a');
                res.add(String.valueOf(arr));
                helper(arr, res, i+1);
                arr[i] = (char)(arr[i]-'a'+'A');
            } 
        }
        return;
    }
}
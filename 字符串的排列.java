
import java.util.ArrayList;
import java.util.Collections;
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return res;
    }
    public void PermutationHelper(char[] array, int pos, ArrayList<String> res) {
        if (pos == array.length-1) {
            res.add(String.valueOf(array));
        }
        for (int i = pos; i < array.length; i++) {
            if (i == pos || array[i] != array[pos]) {
                swap(array, i, pos);
                PermutationHelper(array, pos+1, res);
                swap(array, i, pos);
            }
        }
    }
    public void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    } 
}
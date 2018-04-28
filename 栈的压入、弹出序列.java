import java.util.ArrayList;
import java.util.Stack;
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0 || popA.length == 0) {
           return false;
        }
        int j = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < pushA.length; i++) {
            s.push(pushA[i]);
            while (j < popA.length && s.peek() == popA[j]) {
                s.pop();
                j++;
            }
        }
        return j==popA.length;
    }
}
import java.util.Stack;

public class Solution {
    Stack<Integer> s1 = new Stack();
    Stack<Integer> s2 = new Stack();
    
    public void push(int node) {
        if (s2.isEmpty() || node < s2.peek()) s2.push(node);
        else s2.push(s2.peek());
        s1.push(node);
    }
    
    public void pop() {
        s1.pop();
        s2.pop();
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int min() {
        return s2.peek();
    }
}
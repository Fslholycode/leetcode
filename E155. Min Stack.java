class MinStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    /** initialize your data structure here. */
    public MinStack() {
    }
    
    public void push(int x) {
        if (stack2.isEmpty() || x <= getMin()) {
            stack2.push(x);
        } 
        stack1.push(x);
    }
    
    public void pop() {
        if (getMin() == stack1.peek()) stack2.pop();
        stack1.pop();
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int getMin() {
        return stack2.peek();
    }
}

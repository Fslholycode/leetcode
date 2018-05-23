class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] arr = preorder.split(",");
        Stack<String> s = new Stack();
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            while (str.equals("#") && !s.isEmpty() && s.peek().equals("#")) {
                s.pop();
                if (s.isEmpty()) return false;
                s.pop();
            }
            s.push(str);
        }
        return s.size()==1 && s.peek().equals("#");
        
    }
}
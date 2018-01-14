public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        node[] node = new node[numCourses];
        int[] result = new int[numCourses];
        List<node> list = new ArrayList<node>();
        for (int i = 0; i < numCourses; i++) {
            node[i] = new node(i);
            list.add(node[i]);
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            node[prerequisites[i][0]].parent.add(node[prerequisites[i][1]]);
            node[prerequisites[i][1]].children.add(node[prerequisites[i][0]]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (node[i].parent.size() == 0) {
                result[0] = i;
            }
        }
        int index = 0;
        while (list.size() > 0) {
            int num = index;
            List<node> newl = new ArrayList(list);
            for (node n : list) {
                if (n.parent.size() == 0) {
                    result[index++] = n.item;
                    for (node n1 : n.children) {
                        n1.parent.remove(n);
                    }
                    newl.remove(n);
                }
            }
            if (num == index) return new int[0];
            list = newl;
        }
        return result;
    }
    
    private class node{
        int item;
        ArrayList<node> parent;
        ArrayList<node> children;
        
        public node(int num){
            item = num;
            parent = new ArrayList<node>();
            children = new ArrayList<node>();
        }
    }
}
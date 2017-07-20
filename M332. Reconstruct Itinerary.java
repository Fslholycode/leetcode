public class Solution {
    HashMap<String, PriorityQueue<String>> maps = new HashMap<String, PriorityQueue<String>>();
    LinkedList<String> res = new LinkedList<String>();

    public List<String> findItinerary(String[][] tickets) {
        for (int i = 0; i < tickets.length; i++) {
            if (!maps.containsKey(tickets[i][0])) {
                PriorityQueue<String> p = new PriorityQueue<String>();
                maps.put(tickets[i][0], p);
            }
            maps.get(tickets[i][0]).offer(tickets[i][1]);
        }
        dsp("JFK");
        return res;
    }

    public void dsp(String s) {
        PriorityQueue<String> neibors = maps.get(s);
        while (neibors != null && !neibors.isEmpty()) {
            dsp(neibors.poll());// 访问某边就将该边删除
        }
        res.addFirst(s);
    }
}
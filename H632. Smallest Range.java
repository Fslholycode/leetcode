class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> pq = new PriorityQueue<Element>(new Comparator<Element>() {
			public int compare(Element a, Element b) {
				return a.val - b.val;
			}
		});
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.size(); i++) {
			Element e = new Element(nums.get(i).get(0), i, 0);
			pq.offer(e);
			max = Math.max(max, nums.get(i).get(0));
		}
        int[] res = new int[] {pq.peek().val, max};
        while (!pq.isEmpty() && pq.peek().col < nums.get(pq.peek().row).size()-1) {
            Element n = pq.poll();
            pq.offer(new Element(nums.get(n.row).get(n.col+1), n.row, n.col+1));
            max = Math.max(max, nums.get(n.row).get(n.col+1));
            if (max - pq.peek().val < res[1]-res[0]) {
                res[0] = pq.peek().val;
                res[1] = max;
            }
        }
        return res;
    }
    class Element {
        int val;
        int row;
        int col;
        public Element(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
}
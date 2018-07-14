class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList();
        Set<String> set = new HashSet();
        Set<String> visited = new HashSet();
        Map<String, Set<String>> pre = new HashMap();
        for (String s : wordList) {
            set.add(s);
        }
        if (!set.contains(endWord)) return res;
        Queue<String> q = new LinkedList();
        q.offer(beginWord);
        visited.add(beginWord);
        int times = Integer.MAX_VALUE;
        int depth = 0;
        while (!q.isEmpty()) {
            int num = q.size();
            // System.out.println(depth);
            List<String> strs = new ArrayList();
            for (int i = 0; i < num; i++) {
                String cur = q.poll();
                // System.out.println(cur);
                char[] arr = cur.toCharArray();
                for (int j = 0; j < cur.length(); j++) {
                    char before = arr[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        arr[j] = k;
                        String changed = String.valueOf(arr);
                        // System.out.println(changed);
                        if (changed.equals(endWord)) {
                            times = Math.min(times, depth);
                        }
                        if (set.contains(changed) && !visited.contains(changed)) {
                            // System.out.println(changed);
                            strs.add(changed);
                            q.add(changed);
                            if (pre.containsKey(changed)) pre.get(changed).add(cur);
                            else {
                                pre.put(changed, new HashSet<String>());
                                pre.get(changed).add(cur);
                            }
                        }
                    }
                    arr[j] = before;
                }
            }
            for (int i = 0; i < strs.size(); i++) {
                visited.add(strs.get(i));
            }
            if (times == depth) {
                backTrace(pre, beginWord, endWord, res, new ArrayList<String>());
                break;
            }
            depth++;
        }
        return res;
    }
    public void backTrace(Map<String, Set<String>> pre, String beginWord, String endWord, List<List<String>> res, List<String> list) 
    {
        if (endWord.equals(beginWord)){
            list.add(0,beginWord);
            res.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }
        list.add(0,endWord);
        if (pre.get(endWord)!=null)
            for (String s:pre.get(endWord))
                backTrace(pre,beginWord,s,res,list);
        list.remove(0);
    }
}
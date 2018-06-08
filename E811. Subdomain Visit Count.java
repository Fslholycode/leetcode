class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap();
        for (String s : cpdomains) {
            String[] arr = s.split(" ");
            int num = Integer.parseInt(arr[0]);
            String[] newarr = arr[1].split("\\.");
            // System.out.println(arr[1]);
            // System.out.println(newarr[0]);
            String str = "";
            for (int i = newarr.length-1; i >= 0; i--) {
                if (!str.equals("")) str = newarr[i]+"."+str;
                else str = newarr[i];   
                map.put(str, map.getOrDefault(str, 0)+num);
            }
        }
        List<String> res = new ArrayList();
        for (String s:map.keySet()) res.add(map.get(s)+" "+s);
        return res;
    }
}
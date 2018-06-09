class Solution {
    public List<String> restoreIpAddresses(String s) {
        StringBuilder ip = new StringBuilder();
        List<String> res = new ArrayList();
        for (int a = 1; a <= 3; a++) {
            for (int b = 1; b <= 3; b++) {
                for (int c = 1; c <= 3; c++) {
                    if (s.length()-a-b-c > 0 && s.length()-a-c-b <= 3) {
                        int num1 = Integer.parseInt(s.substring(0,a));
                        int num2 = Integer.parseInt(s.substring(a, a+b));
                        int num3 = Integer.parseInt(s.substring(a+b, a+b+c));
                        int num4 = Integer.parseInt(s.substring(a+b+c));
                        if(num1 <= 255 && num2 <= 255 && num3 <= 255 && num4 <= 255) {
                            ip.append(num1).append(".").append(num2).append(".").append(num3).append(".").append(num4);
                            if (ip.length() == s.length()+3) res.add(ip.toString());
                            ip = new StringBuilder();
                        }
                    }
                }
            }
        }
        return res;
    }
}
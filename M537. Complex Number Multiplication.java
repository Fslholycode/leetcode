class Solution {
    public String complexNumberMultiply(String a, String b) {
        int[] numa = helper(a);
        int[] numb = helper(b);
        int first = numa[0]*numb[0]-numa[1]*numb[1];
        int second = numa[0]*numb[1]+numa[1]*numb[0];
        StringBuilder sb  = new StringBuilder();
        sb.append(first+"");
        sb.append("+");
        sb.append(second+"");
        sb.append("i");
        return sb.toString();
    }
    public int[] helper(String s) {
        int[] res = new int[2];
        String[] arr = s.split("\\+");
        res[0] = Integer.parseInt(arr[0]);
        res[1] = Integer.parseInt(arr[1].replace("i",""));
        return res;
    }
}
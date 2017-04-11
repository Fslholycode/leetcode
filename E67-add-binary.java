public class Solution {
    public String addBinary(String a, String b) {
        int indexa = a.length() - 1;
        int indexb = b.length() - 1;
        int jinwei = 0;
        String result = "";
        while (true) {
            int sum = 0;
            if (indexa < 0 && indexb < 0) {
                break;
            }
            else if (indexa < 0) {
                sum = b.charAt(indexb) -48 + jinwei;
                indexb--;
            }
            else if (indexb < 0) {
                sum = a.charAt(indexa) -48 + jinwei;
                indexa--;
            }
            else {
                sum = a.charAt(indexa) + b.charAt(indexb) - 96 + jinwei;
                indexa--;
                indexb--;
            }
            if (sum < 2) {
                jinwei = 0;
            }
            else {
                jinwei = 1;
            }
            result = Integer.toString(sum%2) + result;
        }
        return jinwei == 1? "1"+result:result;
    }
}
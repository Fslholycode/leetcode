class Solution {
    public String solveEquation(String equation) {
        String res = "x=";
        int[] x = new int[2];
        int[] num = new int[2];
        int index = 0;
        int add = 1;
        boolean left = true;
        boolean isX = false;
        boolean hasDigit = false;
        int cur = 0;
        for (int i = 0; i < equation.length(); i++) {
            char c = equation.charAt(i);
            index = left?0:1;
            if (c == 'x') {
                if (!hasDigit) cur = 1;
                isX = true;
            } else if (c == '=') {
                if (isX) x[index]+=add*cur;
                else num[index] += add*cur;
                left =  false;
                cur = 0;
                isX = false;
                add = 1;
                hasDigit = false;
            } else if (c == '+') {
                if (isX) x[index]+=add*cur;
                else num[index]+=add*cur;
                cur = 0;
                add = 1;
                isX = false;
                hasDigit = false;
            } else if (c == '-') {
                if (isX) x[index]+=add*cur;
                else num[index]+=add*cur;
                add = -1;
                cur = 0;
                isX = false;
                hasDigit = false;
            } else {
                int k = c-'0';
                cur = cur*10+k;
                hasDigit = true;
            }
            // System.out.println(x[0]+" "+num[0]+" "+x[1]+" "+num[1]);

        }
        if (isX) x[index]+=cur*add;
        else num[index]+=add*cur;
        // System.out.println(x[0]+" "+x[1]+" "+num[0]+" "+num[1]);
        if (num[0]-num[1] == 0 && x[0]-x[1] == 0) res = "Infinite solutions";
        else if (x[0]-x[1] == 0) res = "No solution";
        else {
            int val = (num[0]-num[1])/(x[1]-x[0]);
            res = res+String.valueOf(val);
        }
        return res;
    }
}
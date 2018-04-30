//直接在循环到最后一个数字的时候判断count的值，这样可以省去跳出循环后再进行一次验证。

public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array.length == 0) return 0;
        int count  = 1;
        int cur = array[0];
        for (int i = 1; i < array.length; i++) {
            if (cur == array[i]) count++;
            else count--;
            if (i == array.length-1) {
                if (count <= 0) return 0;//如果最后一次count是小于等于0的，说明没有数字符合要求
                else return cur;//若最后的count大于0，则说明目前的cur是满足要求的数字
            }
            if (count < 0) { //如果count小于0了，就将当前的数字设为cur，但因为其已经将前一个数字抵消掉，所以count = 0.
                cur = array[i];
                count = 0;
            }
        }
        return cur;
    }
}

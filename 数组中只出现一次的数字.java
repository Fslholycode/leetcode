//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array.length == 0) return;
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            sum ^= array[i];
        }
        int i = 1;
        while ((sum & i) == 0) {
            i = i << 1;
        } 
        //if (i > 1) i = i >> 1;
        int[] a1 = new int[array.length];
        int index1 = 0;
        int[] a2 = new int[array.length];
        int index2 = 0;
        for (int j = 0; j < array.length; j++) {
            if ((array[j] & i) != 0) a1[index1++] = array[j];
            else a2[index2++] = array[j];
        }
        num1[0] = a1[0];
        for (i = 1; i < index1; i++) {
            num1[0] ^= a1[i];
        }
        num2[0] = a2[0];
        for (i = 1; i < index2; i++) {
            num2[0] ^= a2[i];
        }
    }
}
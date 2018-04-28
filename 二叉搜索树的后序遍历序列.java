public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) return false;
        return helper(sequence, 0, sequence.length-1);
    }
    public boolean helper(int[] sequence, int start, int end) {
        if (start >= end) return true;
        int head = sequence[end];
        int index = start;
        while (sequence[index] < head) {index++;}
        int j = index-1;
        for (int i = index; i < end; i++) {
            if (sequence[i] < head) return false;
        }
        return helper(sequence, start, j) && helper(sequence, j+1, end-1);
    }
}
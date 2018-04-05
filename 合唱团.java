import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.nextLine();
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
        		array[i] = in.nextInt();
        }
        in.nextLine();
        int k = in.nextInt();
        int d = in.nextInt();
        helper(array, k, d);
	} 
	
	public static void helper(int[] array, int k, int d) {
		long dp_max[][] = new long[k+1][array.length+1]; //第一维代表取了i个数，第二维代表最后一个数的index，dp[i][j]代表最大值
		long dp_min[][] = new long[k+1][array.length+1];
		for (int i = 1; i < k+1; i++) {
			Arrays.fill(dp_max[i], Long.MIN_VALUE);
			Arrays.fill(dp_min[i], Long.MAX_VALUE);
		}
		dp_max[0][0] = 1;
		dp_min[0][0] = 1;
		for (int i = 1; i <= array.length; i++) {
			dp_max[1][i] = dp_max[0][0]*array[i-1];
			dp_min[1][i] = dp_min[0][0]*array[i-1];
		}
		for (int i = 2; i < k+1; i++) {
			for (int j = i-1; j <= array.length-k+i; j++) {
				for (int n = j+1; n <= Math.min(j+d, array.length-k+i); n++) {
					dp_max[i][n] = Math.max(dp_min[i-1][j]*array[n-1],Math.max(dp_max[i][n], dp_max[i-1][j]*array[n-1]));
					dp_min[i][n] = Math.min(dp_max[i-1][j]*array[n-1],Math.min(dp_min[i][n], dp_min[i-1][j]*array[n-1]));

//					System.out.println(i+" "+n+" "+dp[i][n]);
				}
			}
		}
		Long max = Long.MIN_VALUE;
		for (int i = 1; i <= array.length; i++) {
			max = Math.max(dp_max[k][i], max);
		}
		System.out.println(max);
	}
}

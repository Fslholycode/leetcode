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
        helper(array);
	} 
	public static void helper(int[] array) {
		int[] dp = new int[array.length+1];
		dp[0] = 0;
		for (int i = 1; i <= array.length; i++) {
			dp[i] = 200000;
			for (int j = i-1; j >= 0; j--) {
				if (array[j]+j >= i) dp[i] = Math.min(dp[i], dp[j]+1);
//				System.out.println(j);
//				System.out.println(dp[i]);
			}
//			System.out.println(dp[i]);
		}
		if (dp[array.length] < 20000) System.out.println(dp[array.length]);
		else System.out.println(-1);
	}
}

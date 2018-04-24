import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		long[] daily = new long[10000000];
		long[] work = new long[10000000];
		int max = 1;
		Arrays.fill(daily, Integer.MIN_VALUE);
		Arrays.fill(daily, Integer.MIN_VALUE);
		for (int i = 0; i < num; i++) {
			sc.nextLine();
			int type = sc.nextInt();
			if (type == 1) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				max = Math.max(max, end);
				int score = sc.nextInt();
				for (int j = start; j <= end; j++) {
					daily[j-1] = Math.max(daily[j-1], score);
				}
			} else {
				int day = sc.nextInt();
				int score = sc.nextInt();
				work[day-1] = Math.max(work[day-1], score);
			}
		}
		long sum = 0;
		for (int i = 0; i < max; i++) {
			sum += daily[i];
			sum += work[i];
		}
		System.out.println(sum);
	}
}
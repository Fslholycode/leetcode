import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long m = in.nextLong();
        helper(n, m);
	} 
	
	public static void helper(long n, long m) {
		m--;
		long i = 1;
		while (m != 0) {
			long start = i, end = i+1;
			long num = 0;
			while (start <= n) {
				num += Math.min(n+1, end)-start;
				start *= 10;
				end *= 10;
			}
			if (num > m) {
	            i *= 10;
	            m--;
	        } else {
	        		m -= num;
	            i++;
	        }
			//System.out.println(start+" "+end+" "+i);
		}
		System.out.println(i);
	}
}

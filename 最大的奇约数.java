import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextInt();
        
        helper(n);
	} 
	public static void helper(long n) {
		long count = 0;
		for (long i = n; i >= 1; i=i/2) {
			long temp = (i+1)/2;
            count += temp*temp;
		}
		System.out.println(count);
	}
}
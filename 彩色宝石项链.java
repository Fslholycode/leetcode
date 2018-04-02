import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
        		helper(in.nextLine());
        }
	} 
	public static void helper(String s) {
		s = s+s;
		int len = s.length();
		int[] book = new int[5];
		int num = 0;
		int min = Integer.MAX_VALUE;
		int j = 0;
		int i = 0;
		while (true) {
			while (i < len && num < 5) {
				int c = s.charAt(i)-'A';
				if (!(c > 4) && book[c]++ == 0) {
					num++;
				}
				i++;
			}
			if (num < 5) break;
			min = Math.min(min, i-j);
			int c = s.charAt(j)-'A';
			if (!(c > 4) && --book[c] == 0) {
				num--;
			}
			j++;
		}
		System.out.println(len/2-min);
	}
}

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
		int head = 0;
		int tail = array.length - 1;
		int times = 0;
		while(head < tail) {
			if (array[head] > array[tail]){
				array[--tail] += array[tail + 1];
				times++;
			}else if(array[head] < array[tail]){
				array[++head] += array[head - 1];
				times++;
			}else{
				head++;
				tail--;
			}
		}
		System.out.println(times);
	}
}

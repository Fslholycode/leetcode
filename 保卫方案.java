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
        int[] array = new int[2*num]; 
        for (int i = 0; i < num; i++) {
        		int n = in.nextInt();
        		array[i] = n;
        		array[i+num] = n;
        }
        helper(array);
	} 
	public static void helper(int[] array) {
		int len = array.length/2;
		int left = 0;
		int right = 1;
		int count = len;
		Map<Integer, Set<Integer>> map = new HashMap();  
		while (left < len) {
			//System.out.print(left+" ");
			int min = array[left];
			for (right = left+1; right < left+len-1; right++) {
				if (array[right] > array[left]) {
					if (right > left+1 && canAdd(map, left, right%len)) {
						count++;
						break;
//						System.out.println("jiba"+left+" "+right+" "+count);
					}
					else break;
				} else {
					if (right-left == 1) min = array[right];
					else {
						if (array[right] >= min) {
							if (canAdd(map, left, right%len)) {
								count++;
								min = array[right];
							}
						} else continue;
//							System.out.println(left+" "+right+" "+count);
					}
				}
			}
			left++;
			//System.out.println(count);
		}
		System.out.println(count);
	}
	public static boolean canAdd(Map<Integer, Set<Integer>> map, int left, int right) {
		if (right < left) {
			int temp = right;
			right = left;
			left = temp;
		}
//		System.out.println(left+" "+right);
		boolean res;
		if (map.containsKey(left)) {
			res = map.get(left).add(right);
		} else {
			res = true;
			map.put(left, new HashSet<Integer>());
			map.get(left).add(right);
		}
		return res;
	}
}

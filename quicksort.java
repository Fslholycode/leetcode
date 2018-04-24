import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String s = sc.nextLine();
		int[] array = {4,3,6,7,2,1,9,8,5};
		array = helper(array);
		for (int num : array) {
			System.out.println(num);
		}
	}
	private static int[] helper(int[] array){
		quicksort(array, 0, array.length-1);
		return array;
	}  
	private static void quicksort(int[] array, int start, int end) {
		if (start >= end) return;
		int base = start+(end-start)/2;
		int pivot = array[base];
		swap(array, base, end);
		int index = start;
		for (int i = start; i < end; i++) {
			if (array[i] < pivot) {
				swap(array, index++, i);
			}
		}
		swap(array, index, end);
		quicksort(array, start, index);
		quicksort(array, index+1, end);
		
	}
	private static void swap(int[] array, int base, int end) {
		int temp = array[base];
		array[base] = array[end];
		array[end] = temp;
	}
}
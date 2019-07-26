package com.visa.prj.util;

public class ArrayUtil {
	
	public static void sort(Comparable[] elems) {
		for (int i = 0; i < elems.length; i++) {
			for (int j = i + 1; j < elems.length; j++) {
				if(elems[i].compareTo(elems[j]) > 0) {
					Comparable temp = elems[i];
					elems[i] = elems[j];
					elems[j] = temp;
				}
			}
		}
	}

	public static int getSum(int[] data) {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;
	}
	
	public static void sort(int[] elems) {
		
	}
	
	/**
	 * method to return number of occurence of "no" in an array
	 */
	public static int getCount(int[] elems, int no) {
		return 0;
	}
	
	
	public static int[] convert(int[][] data) {
		return null;
	}
}

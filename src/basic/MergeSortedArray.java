package basic;

import java.util.Arrays;

/**
 * @author: BlueCitizen
 * @description 合并有序数组
 * 
 *              给定两个按升序排列的有序数组，将它们合并成一个新的有序数组。 例如：a = [1,2,6,8], b =
 *              [2,4,7,10]，输出为 arr = [1,2,2,4,6,7,8,10]
 * 
 * @date: 2024/1/30 11:34
 */
public class MergeSortedArray {

	// 逆向双指针
	public static int[] msa(int[] arr1, int[] arr2) {
		
		int[] arr = new int[arr1.length + arr2.length];
		int p1 = arr1.length - 1, p2 = arr2.length - 1;
		int p = arr.length - 1;
		
		while (p1 >= 0 || p2 >= 0) {
			if (p1 == -1) {
				arr[p] = arr2[p2--];
			} else if (p2 == -1) {
				arr[p] = arr1[p1--];
			} else if (arr1[p1] >= arr2[p2]) {
				arr[p] = arr1[p1--];
			} else if (arr1[p1] < arr2[p2]) {
				arr[p] = arr2[p2--];
			}
			p--;
		}

		/*
		 * while (p1 >= 0) { arr[p] = arr1[p1]; p1--; p--; }
		 * 
		 * while (p2 >= 0) { arr[p] = arr2[p2]; p2--; p--; }
		 */

		return arr;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 4, 5 };
		int[] arr2 = { -2, 3, 5, 7 };
		System.out.println(Arrays.toString(msa(arr1, arr2)));
	}
}

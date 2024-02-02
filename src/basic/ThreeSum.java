package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: BlueCitizen
 * @description 三数之和
 * 
 *              给定一个数组和目标数target，找出数组中a,b,c满足 a+b+c = target 的所有组合。
 * 
 *              例如：arr = [-3,-1,-2,1,2,3]，target = 0。输出为 [(-3,1,2),(-2,-1,3)]
 * 
 *              https://blog.csdn.net/jiaobiandianliu/article/details/102470491
 * 
 *              https://blog.csdn.net/qq_38783664/article/details/122854012
 * 
 * @date: 2024/2/2 11:15
 */
public class ThreeSum {

	// 暴力解法
	public static Set<List<Integer>> ts(int[] arr, int target) {

		// 利用set去重 注意list有顺序 {1,2,3}{2,1,3}是两个不同的序列
		Set<List<Integer>> s = new HashSet<>();
		// 提前排好序 方便凑和
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length - 2; i++) {
			for (int j = i + 1; j < arr.length - 1; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					if (arr[i] + arr[j] + arr[k] == target) {
						s.add(Arrays.asList(arr[i], arr[j], arr[k]));
					}
				}
			}

		}
		return s;
	}

	// 双指针法
	public static Set<List<Integer>> ts1(int[] arr, int target) {

		Set<List<Integer>> s = new HashSet<>();
		Arrays.sort(arr);
		// 游标指向最左，当前考虑的第一个数（最小数）
		for (int i = 0; i < arr.length; i++) {
			// 最小数大于目标，直接退出
			if (arr[i] > target) {
				break;
			}
			if (i > 0 && arr[i] == arr[i - 1]) {
				continue;
			}
			// 设置左右指针，分别指向游标右侧序列的两端
			int l = i + 1, r = arr.length - 1;
			// 向中间移动指针
			while (l < r) {
				if (arr[i] + arr[l] + arr[r] < target) {
					l++;
				} else if (arr[i] + arr[l] + arr[r] > target) {
					r--;
				} else {
					s.add(Arrays.asList(arr[i], arr[l], arr[r]));
					// 跳过重复值 加速查找
					// 如果值重复 就会一直卡在循环里直到不重复或越过边界退出
					while (l < r && arr[l] == arr[++l]) {
					}
					while (l < r && arr[r] == arr[--r]) {
					}
				}
			}
		}
		return s;
	}

	public static void main(String[] args) {

		/*
		 * Set<List<Integer>> s = new HashSet<>(); List<Integer> l = new ArrayList<>();
		 * s.add(Arrays.asList(1, 2, 3)); s.add(Arrays.asList(2, 4, 3));
		 * s.add(Arrays.asList(1, 2, 3)); System.out.println(s.toString());
		 */
		int[] arr = { -1, -2, -3, 4, 5, -4, 3 };
		System.out.println(ts1(arr, 2));

		/*
		 * int l = 0, r = 5;
		 * 
		 * while (l < r && l < --r) { System.out.println(r); } System.out.println(r);
		 */

	}
}

package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: BlueCitizen
 * @description 无重复序列的全排列 给定一个数组，找出其所有可能的排列。
 * 
 *              例如: arr = [1,1,3]，输出为 [[1,1,3],[1,3,1],[3,1,1]]。
 * 
 *              动态规划，排列组合
 * 
 *              https://segmentfault.com/a/1190000040142137
 * 
 * @date: 2024/1/31 16:56
 */
public class Permutations {

	static int[] arr = { 1, 2, 3 };
	static int result = 0;

	public static List<Integer[]> p(Integer[] arr) {
		List<Integer[]> rs = new ArrayList<>();

		if (arr.length <= 1) {
			rs.add(arr);
			return rs;
		}

		return new ArrayList<>();
	}

	// 邻里互换法
	public static void dfs(int start) {

		if (start >= arr.length) {
			// 递归到游标越界，按顺序输出当前的数组
			System.out.print(arr[0]);
			for (int i = 1; i < arr.length; i++) {
				System.out.print("," + arr[i]);
			}
			System.out.println();
			result++;
			return;
		}
		// 游标未越界时，继续向后循环
		// 游标越界后退出这一层递归
		for (int i = start; i < arr.length; i++) {
			// 交换游标位置和当前循环到的位置
			swap(start, i);
			// 当前位置交换完成，进入下一层递归
			dfs(start + 1);
			// 上一层递归退出后，将元素换回原本的位置
			swap(start, i);
		}
	}

	public static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		Integer[] arr = { 1, 2, 3 };
		System.out.println(p(arr));
		dfs(0);
		// 邻里交换法退出后，所有元素还在原本的位置
		System.out.println(Arrays.toString(arr));
	}
}

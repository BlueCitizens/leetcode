package basic;

/**
 * @author: BlueCitizen
 * @description 最大回撤
 * 
 * 有一个数组，求其中两个数x,y，满足x的索引小于y的索引，使得 x-y 最大。 
 * 例如 arr = [3,7,2,6,4,1,9,8,5]， 最大回撤是6，对应的x=7,y=1。
 * 
 * @date: 2024/1/30 11:05
 */
public class MaxDrawdown {
	
	// Solution 1
	public static int md(int[] arr) {

		int x = arr[0];
		int y = arr[1];
		int xm = x;
		int maxDiff = x - y;

		for (int i = 2; i < arr.length; i++) {
			if (arr[i - 1] > x) {
				xm = arr[i - 1];
			}
			if (xm - arr[i] > maxDiff) {
				x = xm;
				y = arr[i];
				maxDiff = x - y;
			}
		}

		return maxDiff;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 7, 2, 6, 4, 1, 9, 8, 5 };
		System.out.println(md(arr));
	}
}

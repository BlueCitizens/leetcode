package basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: BlueCitizen
 * @description 两数之和
 * @date: 2024/1/7 20:17
 * https://blog.csdn.net/humor2020/article/details/123637239
 */
public class TwoSum {

	public static Integer[] ts(Integer[] arr, Integer target) {

		Map<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			if (hm.containsKey(target - arr[i])) {
				return new Integer[] { i, hm.get(target - arr[i]) };
			}
			hm.put(arr[i], i);
		}

		return new Integer[] { -1 };
	}

	public static void main(String[] args) {
		Integer[] arr = { 1, 3, 4, 5, 7 };
		System.out.println(Arrays.toString(ts(arr, 2)));
	}
}

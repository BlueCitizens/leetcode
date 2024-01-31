package basic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: BlueCitizen
 * @description 最长无重复字串
 * 
 *              给定一个字符串，找出没有重复字符的最长的子串。例如输入“abcbefgf”，答案是 “cbefg”。
 * 
 *              动态规划，哈希查找
 * 
 * @date: 2024/1/31 16:42
 */
public class LongestSubStr {

	public static String lss(String str) {
		// char[] cs = str.toCharArray();
		// 用到哈希表查询 空间换时间
		Map<Character, Integer> hm = new HashMap<>();
		int start = 0, maxlen = 0;
		String subStr = "";
		for (int i = 0; i < str.length(); i++) {
			if (!hm.containsKey(str.charAt(i))) {
				hm.put(str.charAt(i), i);
			} else {
				// 碰撞 查重复字符的上一次出现的位置，记录下一位为起始点
				// 也可能start的位置被更靠后的重复字符更新过，取两者中最大的
				start = hm.get(str.charAt(i)) > start ? hm.get(str.charAt(i)) : start;
				hm.put(str.charAt(i), i);
			}
			// 实时更新最长字串
			// 一旦当前的字串长度超过之前的最长字串 就更新
			maxlen = i - start + 1 > maxlen ? i - start + 1 : maxlen;
			subStr = str.substring(start, i + 1);
		}

		return subStr;
	}

	public static void main(String[] args) {
		String str = "abdhdks";
		System.out.println(lss(str));
	}

}

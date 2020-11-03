package sliding_window;

import java.util.HashMap;
import java.util.Map;

//LeetCode 76
public class MinimumWindowSubstring {
	public String solution1(String s, String t) {
		Map<Integer, String> map = new HashMap<>();
		Map<Character, Integer> charMap = new HashMap<>();
		for (Character c : t.toCharArray()) {
			Integer n = charMap.containsKey(c) ? charMap.get(c) + 1 : 1;
			charMap.put(c, n);
		}
		// i表示左指针，j是右指针
		int i = 0, j = 0;
		while (j < s.length()) {
			Character cj = s.charAt(j++);
			boolean flag = false;
			if (charMap.containsKey(cj)) {
				charMap.put(cj, charMap.get(cj) - 1);
				flag = check(charMap);
			}

			while (flag && i <= j) {
				map.put(j - i, s.substring(i, j));
				Character ci = s.charAt(i++);
				if (charMap.containsKey(ci)) {
					Integer n = charMap.get(ci) + 1;
					charMap.put(ci, n);
					flag = n <= 0 ? true : false;
				}
			}
		}
		return getMinimumString(map);

	}

	private String getMinimumString(Map<Integer, String> map) {
		Integer minLen = Integer.MAX_VALUE;
		for (Integer i : map.keySet())
			if (minLen > i)
				minLen = i;
		return map.get(minLen) == null ? "" : map.get(minLen);
	}

	private boolean check(Map<Character, Integer> map) {
		boolean flag = true;
		for (Integer i : map.values())
			if (i > 0) {
				flag = false;
				break;
			}
		return flag;
	}

	// 优化方法1，不需要用map储存所有解决方案
	public String solution2(String s, String t) {
		Map<Character, Integer> charMap = new HashMap<>();
		for (Character c : t.toCharArray()) {
			Integer n = charMap.containsKey(c) ? charMap.get(c) + 1 : 1;
			charMap.put(c, n);
		}
		// i表示左指针，j是右指针
		int i = 0, j = 0;
		int len = Integer.MAX_VALUE;
		int ansL = -1, ansR = -1;
		while (j < s.length()) {
			Character cj = s.charAt(j++);
			boolean flag = false;
			if (charMap.containsKey(cj)) {
				charMap.put(cj, charMap.get(cj) - 1);
				flag = check(charMap);
			}
			while (flag && i <= j) {
				Character ci = s.charAt(i);
				if (charMap.containsKey(ci)) {
					if (j - i < len) {
						len = j - i;
						ansL = i;
						ansR = j;
					}
					Integer n = charMap.get(ci) + 1;
					charMap.put(ci, n);
					flag = n <= 0 ? true : false;
				}
				i++;
			}
		}
		return ansL == -1 ? "" : s.substring(ansL, ansR);
	}

	// 优化方法2中的check方法。
	public String solution3(String s, String t) {
		Map<Character, Integer> charMap = new HashMap<>();
		for (Character c : t.toCharArray()) {
			Integer n = charMap.containsKey(c) ? charMap.get(c) + 1 : 1;
			charMap.put(c, n);
		}
		// i表示左指针，j是右指针
		int i = 0, j = 0, count = 0;
		int len = Integer.MAX_VALUE;
		int ansL = -1, ansR = -1;
		while (j < s.length()) {
			Character cj = s.charAt(j++);
			boolean flag = false;
			if (charMap.containsKey(cj)) {
				Integer n = charMap.get(cj) - 1;
				if (n >= 0) count++;
				charMap.put(cj, n);
				flag = count == t.length() ? true : false;
			}
			while (flag && i <= j) {
				Character ci = s.charAt(i);
				if (charMap.containsKey(ci)) {
					if (j - i < len) {
						len = j - i;
						ansL = i;
						ansR = j;
					}
					Integer n = charMap.get(ci) + 1;
					if (n > 0) {
						flag = false;
						count--;
					}
					charMap.put(ci, n);
				}
				i++;
			}
		}
		return ansL == -1 ? "" : s.substring(ansL, ansR);
	}

	public static void main(String[] args) {
		new MinimumWindowSubstring().solution1("a", "aa");
	}
}

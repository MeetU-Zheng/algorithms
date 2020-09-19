package sliding_window;

import java.util.HashMap;
import java.util.Map;

//LeetCode 567
public class PermutationInString {
	
	public boolean solution1(String s1, String s2) {
		HashMap<Character, Integer> map = new HashMap<>();
		for(Character c : s1.toCharArray()){
			int n = map.getOrDefault(c, 0);
			map.put(c, n+1);
		}
		//拷贝
		HashMap<Character, Integer> tMap = new HashMap<>();
		tMap.putAll(map);
		
		boolean flag = false;
		//i为左指针，j为右指针,count用于确定是否已全部包含和重新计算
		int i=0,j=0;
		int count =0;
		while(j<s2.length()) {
			
			Character chR = s2.charAt(j++);
			if(tMap.containsKey(chR)) {
//				if(count==0)i=j;
				Integer n = tMap.get(chR)-1;
				if(n>=0)count++;
				tMap.put(chR,n);
			}
			else {
				count=0;
				i=j;
				tMap.putAll(map);
			}
			while(count==s1.length()&& j-i>s1.length()) {
				Character chL = s2.charAt(i++);
				if(tMap.containsKey(chL)) {
					Integer n = tMap.get(chL)+1;
					tMap.put(chL,n);
					if(n>0)count--;
				}
			}
			
			if(count == s1.length()&& j-i==s1.length()) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	//TODO:优化方法1
	
	
	public static void main(String[] args) {
		System.out.println(new PermutationInString().solution1("ky", 
				"ainwkckifykxlribaypk"));
	}
	
}

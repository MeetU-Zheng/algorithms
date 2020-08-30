package breadth_first_search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class OpenTheLock {
	public int solution1(String []deadends, String target) {
		LinkedList<String> queue = new LinkedList<>();
		for(String s : deadends) deads.add(s);
		if (deads.contains("0000")) return -1;
		int minStep = 0;
		queue.add("0000");
		while (!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				String s = queue.remove();
				if(target.equals(s))
					return minStep;
				for(int j = 0; j < 4; j++) {
					add(queue, plusOne(s, j));
					add(queue, minusOne(s, j));
				}
			}
			minStep++;
		}
		return -1;
	}
	
	private Set<String> deads = new HashSet<String>();
	private Set<String> visited = new HashSet<>();
	
	private void add(List<String> queue, String s) {
		//为什么判断是否在deadends中，不能放在这里。
		if(deads.contains(s))
			return;
		if(!visited.contains(s)) {
			queue.add(s);
			visited.add(s);
		}
	}
	
	
	
	private String plusOne(String s, int index) {
		char [] ch = s.toCharArray();
		if(ch[index] == '9')
			ch[index] = '0';
		else
			ch[index] += 1;
		return new String(ch);
	}
	
	private String minusOne(String s, int index) {
		char [] ch = s.toCharArray();
		if(ch[index] == '0')
			ch[index] = '9';
		else
			ch[index] -= 1;
		return new String(ch);
	}
	
	public static void main(String[] args) {
		OpenTheLock o = new OpenTheLock();
		String [] ss = {"0201","0001","0102","1212","2002"};
		System.out.print(o.solution1(ss, "0002"));
	}
	
	
}

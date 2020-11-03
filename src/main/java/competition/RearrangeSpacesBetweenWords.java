package competition;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/***
 * 给你一个字符串 text ，该字符串由若干被空格包围的单词组成。每个单词由一个或者多个小写
 * 英文字母组成，并且两个单词之间至少存在一个空格。题目测试用例保证 text 至少包含一个单词 。
 * 请你重新排列空格，使每对相邻单词之间的空格数目都 相等 ，并尽可能 最大化 该数目。
 * 如果不能重新平均分配所有空格，请 将多余的空格放置在字符串末尾 ，
 * 这也意味着返回的字符串应当与原 text 字符串的长度相等。
 * 返回 重新排列空格后的字符串 。
 * @author Maibenben
 *
 */
public class RearrangeSpacesBetweenWords {
	public String solution(String text) {
		StringBuilder str = new StringBuilder();
		Pattern p = Pattern.compile("[a-z]+");
		Matcher m = p.matcher(text);
		int num =0;
		List<String> array = new ArrayList<>();
		while(m.find()) {
			String s = m.group();
			array.add(s);
			num+=s.length();
		}
		int spaceNum=0;
		if(array.size()>1) {
			spaceNum= (text.length()-num)/(array.size()-1);
		}
		int remainSpace = text.length()-num-(array.size()-1)*spaceNum;
		for(int i=0;i<array.size();i++) {
			str.append(array.get(i));
			if(i<array.size()-1)
				str.append(getSpaceStr(spaceNum));
		}
		str.append(getSpaceStr(remainSpace));
		return str.toString();
	}
	
	private String getSpaceStr(int n) {
		StringBuilder s = new StringBuilder();
		while(n-->0) {
			s.append(" ");
		}
		return s.toString();
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(
		new RearrangeSpacesBetweenWords().solution("a")
		);
	}
}

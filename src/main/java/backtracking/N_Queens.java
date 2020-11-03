package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//leetCode 51
public class N_Queens {
	
	private List<List<String>> ans;
	private String initStr;
	private int n;
	private boolean [] majorDiagonal, minorDiagonal, column;
	
	public List<List<String>> solution1(int n) {
		this.n = n;
		ans = new ArrayList<>();
		char [] c = new char[n];
		Arrays.fill(c, '.');
		initStr =  new String(c);
		
		column = new boolean[n];
		majorDiagonal = new boolean[2*n-1];
		minorDiagonal = new boolean[2*n-1];
		
		dfs(new ArrayList<>());
		
		return ans;
		
	}
	
	private void dfs(List<Integer> queens) {
		if(queens.size() == n) 
			addSolution(queens);
		for(int i = 0; i < n; i++) {
			if(!isUnderAttack(i, queens.size())) {
				placeQueen(i, queens);
				dfs(queens);
				removeQueen(i, queens);
			}	
		}
	}
	
	private boolean isUnderAttack(int x, int y) {
		return column[x]||majorDiagonal[x-y + n-1]||minorDiagonal[x+y];
	}
	
	private void addSolution(List<Integer> queens) {
		ans.add(generateSolution(queens));
	}
	
	private void placeQueen(int x, List<Integer> queens) {
		int y = queens.size();
		column[x]= true;
		majorDiagonal[x-y + n-1] = true;
		minorDiagonal[x+y] = true;
		queens.add(x);
	}
	
	private void removeQueen(int x, List<Integer> queens) {
		//用size判断当前行数，要注意加前和加后是不同的。
		int y = queens.size()-1;
		column[x]= false;
		majorDiagonal[x-y + n-1] = false;
		minorDiagonal[x+y] = false;
		queens.remove(y);
	}
	
	private List<String> generateSolution(List<Integer> queens){
		List<String> s = new ArrayList<String>();
		for(int x : queens)
			s.add(generateQueensString(x));
		return s;
	}
	
	private String generateQueensString(int x) {
		StringBuilder s = new StringBuilder(initStr);
		s.setCharAt(x, 'Q');
		return s.toString();
	}
	
	public static void main(String[] args) {
		new N_Queens().solution1(4);
	}
}

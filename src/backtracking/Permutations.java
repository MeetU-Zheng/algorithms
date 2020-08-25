package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {

	public List<List<Integer>> solution1(int[] nums) {

		List<List<Integer>> lists = new ArrayList<>();
		List<Integer> output = new ArrayList<>();
		for (int i : nums)
			output.add(i);
		dfs(lists, output, 0);
		return lists;

	}

	private void dfs(List<List<Integer>> res, List<Integer> output, int first) {
		if (output.size() == first)
			res.add(new ArrayList<>(output));
		for (int i = first; i < output.size(); i++) {
			Collections.swap(output, first, i);
			dfs(res, output, first + 1);
			Collections.swap(output, first, i);
		}
	}
	
	//如果不使用递归、不用dfs，那么回溯算法的回退到上一个状态会比较麻烦，
	//如果不回溯，就需要使用很多中间变量保存

	public List<List<Integer>> solution2(int[] nums) {

		List<List<Integer>> lists = new ArrayList<>();
		List<Integer> output = new ArrayList<>();
		
		//第i个空格
		for(int i = 0;i<nums.length;i++) {
			//new ans;
			for(list:lists) {
				//第j个数
				for(int j = 0; j< nums.length;j++) {
					//判断list是否已有
					//把nums[j]加入list
					//拷贝list，等待尝试添加下一个空格
				}
			}
		}
		
	}

}

package binary_tree;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.TreeMap;

public class MinimumDepthOfBinaryTree {
	
	
	//递归，深度优先搜索
	public int solution1(TreeNode root) {
		if(root == null) return 0;
		int numLeft = Integer.MAX_VALUE;
		int numRight =  Integer.MAX_VALUE;
		if(root.left == null && root.right == null) {
			return 1;
		}else {
			if(root.left != null)
				numLeft = solution1(root.left)+1;
			if(root.right != null)
				numRight = solution1(root.right)+1;
		}
		return Math.min(numLeft, numRight);
	}
	
	//把方法1改得简练些
	public int solution2(TreeNode root) {
		if(root == null) return 0;
		if(root.left == null)
			return solution2(root.right)+1;
		if(root.right == null)
			return solution2(root.left)+1;
		return Math.min(solution2(root.right)+1, 
				solution2(root.left)+1);
	}
	
	
	private int depth = Integer.MAX_VALUE;
	//不需要像方法1、2 那样完全遍历所有节点,剪枝
	public int solution3(TreeNode root) {
		dfs(root, 0);
		return depth;
	}
	
	private void dfs(TreeNode root, int curr) {
		if(root == null) {
			depth = Math.min(curr, depth); 
		}
		if(depth > curr) {
			
		}
	}
	
	//bfs，迭代
	public int solution4(TreeNode root) {
		//最小深度
		int minDepth = 0;
		//Count按完全二叉树方式统计节点数，这样可确定层数
		int getCount = 0, putCount = 0;
		TreeNode node = root;
		//使用map,但不能使用hashmap，hashmap底层的哈希算法用的是取二进制尾数，而二叉树也可以
		//按二进制方式给每个节点排序，这样分布不平衡的二叉树，在hashmap存储是冲突的概率极大。
		//TODO: 尝试使用其他map替换HashMap。
		HashMap<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();
		if(root != null)
			map.put(++putCount, root);
		while(!map.isEmpty()) {
			//每次循环只加一，那么算法的时间复杂度最坏情况是二叉树退化成链表时会退化成O(2^n)
			//TODO: 尝试使用TreeMap，可排序的map，简化复杂度
			//但putCount必定递增，所以排序没必要，只要按放入的顺序取出即可,即队列。
			if(!map.containsKey(++getCount)) {
				putCount+=2;
				continue;
			}
			node = map.remove(getCount);
			if(getCount >> minDepth >= 1) minDepth++;
			if(node.right == null && node.left == null) {
				break;
			}
			putCount++;
			if(node.left != null) {
				map.put(putCount, node.left);
			}
			putCount++;
			if(node.right != null)
				map.put(putCount, node.right);
		}
		return minDepth;
	}
	
	//bfs,用常规的队列进行广度优先搜索, 直接存入层数，而不需要通过节点数判断。
	public int solution5(TreeNode root) {
		int minDepth = 0;
		//java8 没有pair或tuples，这里使用内置类
		LinkedList<AbstractMap.SimpleEntry<TreeNode, Integer>> queue = 
				new LinkedList<>();
		AbstractMap.SimpleEntry<TreeNode, Integer> current;
		TreeNode currNode = root;
		if(root != null) {
			current = new AbstractMap.SimpleEntry<>(root, ++minDepth);
			queue.add(current);
		}
		while(!queue.isEmpty()) {
			current = queue.poll();
			currNode = current.getKey();
			minDepth = current.getValue();
			if(currNode.left == null && currNode.right == null)
				break;
			if(currNode.left != null)
				queue.add(new AbstractMap.SimpleEntry<TreeNode, Integer>(
						currNode.left, minDepth+1));
			if(currNode.right != null)
				queue.add(new AbstractMap.SimpleEntry<TreeNode, Integer>(
						currNode.right, minDepth+1));
		}
		return minDepth;
	}
	
	//TODO:改进方法5，在进入每一层时入栈层数作为标记。（统一遍历方法）
	//或者像层序遍历中，先确定每一层的数量，进而确定循环次数。
	
	//dfs, 迭代, 用栈模拟递归
	public int solution6(TreeNode root) {
		int minDepth = 0;
		LinkedList<AbstractMap.SimpleEntry<TreeNode, Integer>> stack = 
				new LinkedList<>();
		AbstractMap.SimpleEntry<TreeNode, Integer> current;
		TreeNode currNode = root;
		if(root != null) {
			minDepth = Integer.MAX_VALUE;
			current = new AbstractMap.SimpleEntry<>(root, 1);
			stack.push(current);
		}
		while (!stack.isEmpty()) {
			current = stack.pop();
			currNode = current.getKey();
			if(currNode.left == null && currNode.right == null 
					&& minDepth > current.getValue())
				minDepth = current.getValue();
			if(currNode.right != null)
				stack.push(new AbstractMap.SimpleEntry<TreeNode, Integer>(
						currNode.right, current.getValue()+1));
			if(currNode.left != null)
				stack.push(new AbstractMap.SimpleEntry<TreeNode, Integer>(
						currNode.left, current.getValue()+1));
		}
		return minDepth;
	}
	
	public static void main(String[] args) {	
		TreeNode node0 = new TreeNode();
		node0.left = new TreeNode();
		new MinimumDepthOfBinaryTree().solution4(
				node0);
	}
	

}

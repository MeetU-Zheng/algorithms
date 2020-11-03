package binary_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class BinaryTreeLevelOrderTraversal {
	
	//递归, 由根到叶子节点。
	private ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
	public ArrayList<ArrayList<Integer>> solution1(TreeNode root){
		helper1(root, 0);
		return levels;
	}
	private void helper1(TreeNode root, Integer level) {
		if(root == null) return;
		if(levels.size() <= level)
			levels.add(new ArrayList<>());
		levels.get(level).add(root.val);
		helper1(root.left, level+1);
		helper1(root.right, level+1);
	}
	
	//方法1的输出循序是广度优先，但递归方法中实际是进行深度优先搜索，尝试递归中也用广度。
	private LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	public ArrayList<ArrayList<Integer>> solution2(TreeNode root){
		if(root != null)
			queue.add(root);
		helper2(0);
		return levels;
	}
	private void helper2(Integer level) {
		if(queue.isEmpty()) return;
		//在递归中写循环似乎有点奇怪，而且运行速度也比方法1慢
		IntStream.range(0, queue.size()).forEach(x ->{
			TreeNode node = queue.poll();
			if(levels.size() <= level)
				levels.add(new ArrayList<>());
			levels.get(level).add(node.val);
			if(node.left != null) queue.add(node.left);
			if(node.right != null) queue.add(node.right);
		});
		helper2(level+1);
	}
	
	//迭代实现方法2
	public ArrayList<ArrayList<Integer>> solution3(TreeNode root){
		ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		if(root != null)
			queue.add(root);
		for(int i = 0; !queue.isEmpty(); i++) {
			//函数式编程，只能访问外界不变的变量，
			int level = i;
			IntStream.range(0, queue.size()).forEach(x ->{
				TreeNode node = queue.poll();
				if(levels.size() <= level)
					levels.add(new ArrayList<>());
				levels.get(level).add(node.val);
				if(node.left != null) queue.add(node.left);
				if(node.right != null) queue.add(node.right);
			});
			//上述lambda实现比直接循环慢很多。。。。。
//			int size = queue.size();
//			for (int j = 0; j < size; j++) {
//				TreeNode node = queue.poll();
//				if(levels.size() <= level)
//					levels.add(new ArrayList<>());
//				levels.get(level).add(node.val);
//				if(node.left != null) queue.add(node.left);
//				if(node.right != null) queue.add(node.right);
//			}
		}
		return levels;
	}
	
	
	
	//由叶子节点到根。
	
	
	
	
	public static void main(String[] args) {
		new BinaryTreeLevelOrderTraversal().solution1(new TreeNode());
	}
	
	
}

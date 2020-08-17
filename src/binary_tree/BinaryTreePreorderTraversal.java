package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;

//前序遍历
public class BinaryTreePreorderTraversal {

	private ArrayList<Integer> list = new ArrayList<>();
	// 递归
	// recursion
	public ArrayList<Integer> solution1(TreeNode root) {
		if (root == null) {
			return list;
		}
		list.add(root.val);
		solution1(root.left);
		solution1(root.right);
		return list;
	}
	
	//循环
	//有问题：循环手动入栈的是逆序的节点，而递归入栈的是什么东西？各种局部和指令指针？
	public ArrayList<Integer> solution2(TreeNode root){
		ArrayList<Integer> list = new ArrayList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode node = null;
		if(root != null)
			stack.push(root);
		while(!stack.isEmpty()) {
			node = stack.pop();
			list.add(node.val);
			if(node.right != null) {
				stack.push(node.right);
			}
			if(node.left != null) {
				stack.push(node.left);
			}
		}
		return list;
	}

}

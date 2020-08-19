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
	
	public ArrayList<Integer> solution3(TreeNode root){
		ArrayList<Integer> list = new ArrayList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode node = root;
		while(!stack.isEmpty() || node != null) {
			while(node != null) {
				list.add(node.val);
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			node = node.right;
		}
		return list;
	}
	
	//简化方法3, 好像没简化成，越写越复杂，就少了点入栈和出栈操作
	public ArrayList<Integer> solution4(TreeNode root){
		ArrayList<Integer> list = new ArrayList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode node = root;
		while(node != null || !stack.isEmpty()) {
			if(node == null)
				node = stack.pop();
			while(true) {
				list.add(node.val);
				if(node.left == null)
					break;
				else {
					if(node.right != null)
						stack.push(node.right);
					node = node.left;
				}
			}
			node = node.right;
		}
		return list;
	}
	
	
	public static void main(String[] args) {
		TreeNode root= new TreeNode();
		root.val =1;
		TreeNode node = new TreeNode();
		node.val = 2;
		root.right = node;
		new BinaryTreePreorderTraversal().solution3(root);
	}

}

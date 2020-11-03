package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;

//中序遍历
//具体解法类似后序遍历
public class BinaryTreeInorderTraversal {
	
	private ArrayList<Integer> list = new ArrayList<Integer>();
	
	public ArrayList<Integer> solution1(TreeNode root){
		if(root == null) {
			return list;
		}
		solution1(root.left);
		list.add(root.val);
		solution1(root.right);
		return list;
	}
	

	//没有将根节点出栈又入栈的需要，所以不需要多余判断
	public ArrayList<Integer> solution2(TreeNode root){
		ArrayList<Integer> list = new ArrayList<>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode node = root;
		while(node != null || !stack.isEmpty()) {
			while(node != null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			list.add(node.val);
			node = node.right;
		}
		return list;
	}
	
	
	
	
}

package binary_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

//循环解后序和中序遍历为什么会比前序更困难？因为根在中间和后面，不能先解决掉？
public class BinaryTreePostorderTraversal {
	
	private ArrayList<Integer> list = new ArrayList<Integer>();
	
	public ArrayList<Integer> solution1(TreeNode root){
		if(root == null) {
			return list;
		}
		solution1(root.left);
		solution1(root.right);
		list.add(root.val);
		
		return list;
	}
	
	
	public ArrayList<Integer> solution2(TreeNode root){
		ArrayList<Integer> list = new ArrayList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode node = null;
		if(root != null)
			stack.push(root);
		while(!stack.isEmpty()) {
			node = stack.peek();
			if(node.left == null && node.right == null) {
				node = stack.pop();
				list.add(node.val);
			}else {
				if(node.right != null) {
					stack.push(node.right);
					//这样会改变原本树的结构，有更好的方法吗
					node.right = null;
				}
				if(node.left != null) {
					stack.push(node.left);
					node.left = null;
				}
			}
		}
		return list;
	}
	
	//方法2中，不设置null，会改变树的形状，通过判断父子关系解决不断重复的问题
	public ArrayList<Integer> solution3(TreeNode root){
		ArrayList<Integer> list = new ArrayList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode node = null, prePopedNode = root;
		if(root != null)
			stack.push(root);
		while(!stack.isEmpty()) {
			node = stack.peek();
			//如果没有子节点，则说明现在是叶子节点，list保存其值
			//或者，因为prePopedNode保存的是上一个被list保存值的节点，
			//如果当前节点与prePopedNode节点是父子关系，
			//则保存当前节点的值，防止进入else语句重复计算，此时须注意prePopedNode不能为初始值null
			if(node.left == null && node.right == null
				|| (prePopedNode == node.left || prePopedNode == node.right)) {
				node = stack.pop();
				list.add(node.val);
				prePopedNode = node;
			}else{
				if(node.right != null) {
					stack.push(node.right);
				}
				if(node.left != null) {
					stack.push(node.left);
				}
			}
		}
		return list;
	}
	
	//实现根->右->左，再逆序
	public ArrayList<Integer> solution4(TreeNode root){
		ArrayList<Integer> list = new ArrayList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode node = null;
		if(root != null)
			stack.push(root);
		while(!stack.isEmpty()) {
			node = stack.pop();
			list.add(node.val);
			if(node.left != null) {
				stack.push(node.left);
			}
			if(node.right != null) {
				stack.push(node.right);
			}
		}
		Collections.reverse(list);
		return list;
	}
	
	//尝试减少判断的行数，让代码更简练
	public ArrayList<Integer> solution5(TreeNode root){
		ArrayList<Integer> list = new ArrayList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode node = root;
		if(root != null)
			stack.push(root);
		while(!stack.isEmpty()) {
			node = stack.pop();
			while(node != null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			if(node.right != null)
				stack.push(node);
			else 
				list.add(node.val);
		}
		return list;
	}
	
}

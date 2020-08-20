package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//树不同遍历的循环结构有差异，尝试进行统一
public class BinaryTreeOrderTraversal {
	
	//像递归一样通过调换顺序
	public List<Integer> solution1(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		LinkedList<Object> stack = new LinkedList<>();
		Object e;
		TreeNode node;
		stack.add(root);
		while(!stack.isEmpty()) {
			e = stack.pop();
			if(e == null) continue;
			if(e instanceof TreeNode) {
				node = (TreeNode)e;
				//根据遍历方式调换顺序
				//层序遍历则将stack改为queue
				stack.push(node.right);
				stack.push(node.left);
				stack.push(node.val);
			}else if (e instanceof Integer) {
				list.add((Integer)e);
			}
		}
		return list;
	}
	
	
}

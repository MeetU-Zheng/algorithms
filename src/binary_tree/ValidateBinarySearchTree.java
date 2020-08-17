package binary_tree;


class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;
}

public class ValidateBinarySearchTree {
	private long pre = Long.MIN_VALUE;
	
	//深度优先搜索，递归，中序遍历。
	//depth-first search, recursion, Inorder Traversal
	public boolean solution1(TreeNode root) {
        if(root == null)
            return true;
        if(!isValidBST(root.left))
            return false;
        if(pre < root.val)
            pre = root.val;
        else
            return false;
        return isValidBST(root.right);
	}
	
	//DFS,
}

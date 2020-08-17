package binary_tree;

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
			dfs(root.left, curr+1);
			dfs(root.right, curr+1);
		}
	}
	

}

package binary_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class BinaryTreeVerticalOrderTraversal {

	// 新建结构体pair，保存TreeNode和x
	// 先进行层序遍历，统计每一层节点数，这样就不用考虑y坐标,queue存pair
	// 维护left变量，表示目前X最小值，每到新一层都有可能更新
	// 使用map，key为x坐标，value为list
	// 为什么要用map?因为需要一个能头插和尾插，还能根据index快速访问的数据结构
	// 每一层根据每个pair的x值相同的节点，按node.val大小排序，按x值从map中取出，并按序添加node.val
	// 最后按left变量循环，从map取出list，加到二维数组lists中。
	class Pair {
		int x;
		TreeNode node;

		public Pair(int x, TreeNode node) {
			this.x = x;
			this.node = node;
		}
	}

	public List<List<Integer>> solution1(TreeNode root) {
		List<List<Integer>> lists = new ArrayList<>();
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		int level, left = 0;
		Pair current;
		TreeNode node;
		if (root != null)
			queue.add(new Pair(0, root));
		for (level = 0; !queue.isEmpty(); level++) {
			HashMap<Integer, List<Integer>> levelMap = new HashMap<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				current = queue.remove();
				node = current.node;
				if (current.x < left)
					left = current.x;
				if (node.left != null)
					queue.add(new Pair(current.x - 1, node.left));
				if (node.right != null)
					queue.add(new Pair(current.x + 1, node.right));
				if (!levelMap.containsKey(current.x))
					levelMap.put(current.x, new ArrayList<>());
				levelMap.get(current.x).add(node.val);
			}
			for (Integer key : levelMap.keySet()) {
				List<Integer> list = levelMap.get(key);
				Collections.sort(list);
				if (map.containsKey(key)) {
					map.get(key).addAll(list);
				} else {
					map.put(key, list);
				}
			}
		}
		for(int i = left; map.containsKey(i); i++)
			lists.add(map.get(i));
//		lists.addAll(map.values());
		return lists;
	}


}

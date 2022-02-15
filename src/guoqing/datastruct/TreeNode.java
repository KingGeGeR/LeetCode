package guoqing.datastruct;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public static TreeNode createTreeByFirstVisitRoot(List<Integer> arr) {
		Queue<Integer> vals = new LinkedList<Integer>(arr);
		Queue<TreeNode> tree = new LinkedList<TreeNode>();
		TreeNode root = new TreeNode(vals.poll());
		tree.add(root);
		while (!tree.isEmpty() && !vals.isEmpty()) {
			TreeNode node = tree.poll();
			if (node == null) {
				continue;
			}
			Integer temp = vals.poll();
			node.left = (temp == null) ? null : new TreeNode(temp);
			tree.add(node.left);
			temp = vals.poll();
			node.right = (temp == null) ? null : new TreeNode(temp);
			tree.add(node.right);
		}
		return root;
	}
}

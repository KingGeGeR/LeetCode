package leetcode300;

import java.util.HashMap;
import java.util.Map;

import guoqing.datastruct.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
public class Leetcode337 {
	// if root > left + right then max_val = root + max_val, else max_val = left + right + max_val

    // the root select max value sel()
    Map<TreeNode, Integer> sel;
    Map<TreeNode, Integer> nsel;

    // the root not select max value nsel()
    // for a certain root the max value is vMax(root) = max{sel(root), nsel(root)}
    //
    public int rob(TreeNode root) {
        sel = new HashMap<TreeNode, Integer>();
        nsel = new HashMap<TreeNode, Integer>();
        sel.put(null, 0);
        nsel.put(null, 0);
        dfs(root);
        return Math.max(sel.get(root), nsel.get(root));
    }

    void dfs(TreeNode root) {
        // last root visit left child
        // last root visit right child
        // last root visit root
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        // sel root max
        int selMax = root.val + nsel.get(root.left) + nsel.get(root.right);
        //System.out.println(root.val + "sel max is:" + selMax);
        sel.put(root, selMax);
        int nselMax
            = Math.max(sel.get(root.left), nsel.get(root.left)) + Math.max(nsel.get(root.right), sel.get(root.right));
        nsel.put(root, nselMax);
        //System.out.println(root.val + "nsel max is:" + nselMax);
    }
}
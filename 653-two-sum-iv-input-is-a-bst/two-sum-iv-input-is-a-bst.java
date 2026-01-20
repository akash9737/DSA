/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashSet<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, k);
    }

    private boolean dfs(TreeNode root, int k) {
        if (root == null) return false;

        // Check if complement exists
        if (set.contains(k - root.val)) {
            return true;
        }

        // Add current value
        set.add(root.val);

        // Search left and right
        return dfs(root.left, k) || dfs(root.right, k);
    }
}
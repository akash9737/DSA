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
    private long totalSum = 0;
    private long maxProduct = 0;
    private static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        // Step 1: Compute total sum of tree
        totalSum = computeSum(root);

        // Step 2: DFS to compute subtree sums and maximize product
        computeSubtree(root);

        // Step 3: Return result modulo 1e9+7
        return (int)(maxProduct % MOD);
    }

    
    private long computeSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + computeSum(node.left) + computeSum(node.right);
    }

    
    private long computeSubtree(TreeNode node) {
        if (node == null) return 0;

        long left = computeSubtree(node.left);
        long right = computeSubtree(node.right);

        long subSum = node.val + left + right;

        // Product if we cut this subtree
        long product = subSum * (totalSum - subSum);
        maxProduct = Math.max(maxProduct, product);

        return subSum;
    }
}
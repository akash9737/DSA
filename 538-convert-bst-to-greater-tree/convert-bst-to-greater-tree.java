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
    
    private int sum = 0;   // Store running sum
    
    public TreeNode convertBST(TreeNode root) {
        reverseInorder(root);
        return root;
    }
    
    private void reverseInorder(TreeNode node) {
        if (node == null) return;
        
        // Visit right subtree first (greater values)
        reverseInorder(node.right);
        
        // Update running sum
        sum += node.val;
        node.val = sum;
        
        // Visit left subtree
        reverseInorder(node.left);
    }
}

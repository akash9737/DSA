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
    public String tree2str(TreeNode root) {
        if (root == null) return "";
        
        // If leaf node
        if (root.left == null && root.right == null) {
            return String.valueOf(root.val);
        }
        
        // If right child is null
        if (root.right == null) {
            return root.val + "(" + tree2str(root.left) + ")";
        }
        
        // If left child is null but right exists
        if (root.left == null) {
            return root.val + "()(" + tree2str(root.right) + ")";
        }
        
        // If both children exist
        return root.val + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")";
    }
}


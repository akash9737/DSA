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
    // 0 = has camera
    // 1 = covered (no camera)
    // 2 = not covered
    private int cameras = 0;

    public int minCameraCover(TreeNode root) {
        // If root is not covered after DFS, need one more camera at root
        if (dfs(root) == 2) {
            cameras++;
        }
        return cameras;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
    
            return 1;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        
        if (left == 2 || right == 2) {
            cameras++;
            return 0; 
        }

        
        if (left == 0 || right == 0) {
            return 1; 
        }

        
        return 2; 
    }
}

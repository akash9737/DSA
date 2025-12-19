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

    int tilt=0;
    public int findTilt(TreeNode root) {

        PostOrder(root);
        return tilt;

        
    }

    private int PostOrder(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftt=PostOrder(root.left);
        int rightt=PostOrder(root.right);

        tilt+=Math.abs(leftt-rightt);

        return leftt+rightt+root.val;
        
    }

    


}
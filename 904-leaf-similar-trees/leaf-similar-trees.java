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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leves1=new ArrayList<>();
        List<Integer> leves2=new ArrayList<>();


        collectLeves(root1,leves1);
        collectLeves(root2,leves2);

        return leves1.equals(leves2);
    }

    private void collectLeves(TreeNode node,List<Integer>leves){
        if(node == null) return;

        if(node.left == null && node.right==null){
            leves.add(node.val);
            return;
        }
        collectLeves(node.left,leves);
        collectLeves(node.right,leves);

    }
}
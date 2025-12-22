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
    public List<Double> averageOfLevels(TreeNode root) {

        Queue<TreeNode> levelorder = new LinkedList<>();
        levelorder.add(root);
        levelorder.add(null);

        List<Double> avgList = new ArrayList<>();

        while(levelorder.peek()!= null){
            double sum=0;
            int nodes=0;

            while(levelorder.peek()!= null){
                TreeNode node =levelorder.poll();
                sum +=node.val;
                nodes++;

                if(node.left != null)levelorder.add(node.left);
                if(node.right != null)levelorder.add(node.right);

            }

            levelorder.add(levelorder.poll());
            avgList.add(sum/nodes);

        }
        return avgList;
    }
}
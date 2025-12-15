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
    private Integer prev = null;
    private int count = 0;
    private int maxCount = 0;
    private List<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        // Process current node
        if (prev == null || node.val != prev) {
            count = 1;
        } else {
            count++;
        }

        if (count > maxCount) {
            maxCount = count;
            result.clear();
            result.add(node.val);
        } else if (count == maxCount) {
            result.add(node.val);
        }

        prev = node.val;

        inorder(node.right);
    }
}

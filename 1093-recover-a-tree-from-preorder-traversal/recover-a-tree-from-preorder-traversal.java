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
    private int index=0;
    public TreeNode recoverFromPreorder(String traversal) {
        return build(traversal,0);
    }
    private TreeNode build(String s,int depth){
        int n = s.length();
        int d = 0;

        // Count dashes to determine depth
        while (index + d < n && s.charAt(index + d) == '-') {
            d++;
        }

        // If depth doesn't match, return null
        if (d != depth) return null;

        index += d;

        
        int val = 0;
        while (index < n && Character.isDigit(s.charAt(index))) {
            val = val * 10 + (s.charAt(index) - '0');
            index++;
        }

        TreeNode node = new TreeNode(val);

        
        node.left = build(s, depth + 1);
        node.right = build(s, depth + 1);

        return node;

    }
}
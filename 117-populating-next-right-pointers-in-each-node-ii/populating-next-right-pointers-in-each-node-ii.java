/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    private Node prev, nextStart;

    public Node connect(Node root) {
        Node head = root;
        while (head != null) {
            prev = null;
            nextStart = null;
            for (Node curr = head; curr != null; curr = curr.next) {
                modify(curr.left);
                modify(curr.right);
            }
            head = nextStart;
        }
        return root;
    }

    private void modify(Node child) {
        if (child == null) return;
        if (nextStart == null) nextStart = child;
        if (prev != null) prev.next = child;
        prev = child;
    }
}

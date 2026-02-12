class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        // Create dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // Move fast n steps ahead
        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }
        
        // Move both until fast reaches last node
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // Remove nth node
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}

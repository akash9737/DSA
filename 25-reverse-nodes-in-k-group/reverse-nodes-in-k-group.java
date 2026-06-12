/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupTail=dummy;

        while(true){
            ListNode kthNode = getKthNode(prevGroupTail, k);
            if (kthNode == null) {
                break; // Fewer than 'k' nodes left; leave them as they are
            }

            // Keep track of the node starting the next group
            ListNode nextGroupHead = kthNode.next;

            // 2. Isolate the current group of k nodes
            ListNode currentGroupHead = prevGroupTail.next;
            kthNode.next = null; // Sever the link to isolate the group

            // 3. Reverse the isolated group and link it to the previous tail
            prevGroupTail.next = reverse(currentGroupHead);

            // 4. Reconnect the tail of the newly reversed group to the remaining list
            // Note: currentGroupHead is now the tail of the reversed group
            currentGroupHead.next = nextGroupHead;

            // Move the pointer forward for the next iteration
            prevGroupTail = currentGroupHead;
        }
        return dummy.next;
    }

        private ListNode getKthNode(ListNode start, int k) {
        while (start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start;
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev; // Returns the new head of the reversed portion
    }

}
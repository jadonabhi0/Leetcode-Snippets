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
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;

        ListNode dummy = null;
        ListNode curr = head;

        while(curr != null){
            ListNode ahead = curr.next;
            curr.next = dummy;
            dummy = curr;
            curr = ahead;
        }

        return dummy;
        
    }
}
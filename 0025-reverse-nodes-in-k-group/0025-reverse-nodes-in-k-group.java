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
        ListNode dummy = new ListNode(0);;
        dummy.next = head;
        ListNode pointer = dummy;

        while(pointer != null){

            // first check for the next K nodes
            ListNode temp = pointer;
            for(int i = 0 ; i < k && temp != null ; i++, temp = temp.next);
            if(temp == null) break; // no more k nodes further            

            // reverse k node
            ListNode prev = null, curr = pointer.next, next = null, tail = pointer.next;
            for(int i = 0 ; i < k ; i++){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            tail = pointer.next;
            pointer.next = prev;
            tail.next = curr;
            pointer = tail;
        }        

        return dummy.next;
    }
}
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

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pointer = dummy;

        while(pointer != null){ 
            // check k nodes ahead
            ListNode temp = pointer;
            for(int i = 0 ; i < k && temp != null ; i++, temp = temp.next){
                if(temp.next == null) return dummy.next;
            }
            ListNode saved = temp.next;
            temp.next = null;

            ListNode tail = pointer.next;
            ListNode rHead = reverseLL(pointer.next);
            pointer.next = rHead;
            tail.next = saved;
            pointer = tail;
        }
        return dummy.next;
        
    }


    private ListNode reverseLL(ListNode node){
        if(node == null || node.next == null){
            return node;
        }

        ListNode newHead = reverseLL(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }

}
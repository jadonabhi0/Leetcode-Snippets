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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        ListNode mm = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        
        
        int step = size-n;
        if(step == 0){
            return head.next;
        }
        ListNode prev = null;
        while(step-->0){
            prev = mm;
            mm = mm.next;
        }
        prev.next = mm.next;
        return head;
    }
    
}
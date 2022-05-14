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
    
    
    public ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        while(curr != null){
            ListNode store = curr.next;
            curr.next = prev;
            prev = curr;
            curr = store;
        }
        return prev;
    }
    
    
    public void merge(ListNode l1, ListNode l2){
        while(l2 != null){
            ListNode store = l1.next;
            l1.next = l2;
            l1 = l2;
            l2 = store;
        }
    }
    
    
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null){
            return;
        }
        
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        
        ListNode l1 = head;
        ListNode l2 = reverse(slow);
        merge(l1, l2);
    
    }
}
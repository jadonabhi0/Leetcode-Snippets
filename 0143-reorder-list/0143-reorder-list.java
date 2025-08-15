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
    public void reorderList(ListNode head) {

        // algo
        // 1 find mid first 
        // 2 reverse half portion 
        // 3 start merge

        // 1 -> 2 -> 3 -> 4 -> 5 -> null

        ListNode mid = getMidOfLL(head);
        ListNode next = reverseLL(mid.next);
        mid.next = null;
        mergeLL(head, next);
        
    }

    private void mergeLL(ListNode h1, ListNode h2){
        while(h2 != null){
            ListNode next1 = h1.next;
            ListNode next2 = h2.next;

            h1.next = h2;   // connect h1 → h2
            h2.next = next1;
            h2 = next2;
            h1 = next1;
        }
    }


    private ListNode getMidOfLL(ListNode head){
        if(head != null && head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseLL(ListNode head){
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;

        for(curr = head; curr != null ;){
            next = curr.next; // save next
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
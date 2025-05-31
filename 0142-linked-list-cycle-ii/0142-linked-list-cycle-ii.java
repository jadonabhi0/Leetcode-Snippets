/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    private ListNode getNodeIfCycle(ListNode head){

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return slow;
        }

        return null;

    }

    public ListNode detectCycle(ListNode head) {
        
        ListNode meet = getNodeIfCycle(head);

        if(meet == null) return meet;

        ListNode start = head;

        while(start != meet){
                start = start.next;
                meet = meet.next;
        }

        return meet;

    }
}
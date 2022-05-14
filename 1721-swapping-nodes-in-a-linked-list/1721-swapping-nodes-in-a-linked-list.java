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
    public ListNode swapNodes(ListNode head, int k) {
    ListNode val = new ListNode(-1, head), p1 = val;
    for(int i = 0; i < k - 1; i++) {
        p1 = p1.next;
    }
    ListNode ahead = val, p2 = val;
    for(int i = 0; i < k + 1; i++) {
        ahead = ahead.next;
    }
    while(ahead != null) {
        ahead = ahead.next;
        p2 = p2.next;
    }
    if(p1 != p2) {
        ListNode x = p1.next, y = p2.next;
        p1.next = y;
        p2.next = x;
        ListNode n2 = y.next;
        y.next = x.next;
        x.next = n2;
    }
    return val.next;
}
}
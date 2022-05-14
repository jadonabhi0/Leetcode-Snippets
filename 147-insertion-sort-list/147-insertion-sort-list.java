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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        ListNode cur = head;
        
        while(cur != null){
        
            while(temp.next != null && temp.next.val < cur.val){
                temp = temp.next;
            }
            
            ListNode store = cur.next;
            cur.next = temp.next;
            temp.next = cur;
            cur = store;
            temp = dummy;
        }
        return dummy.next;
    }
}
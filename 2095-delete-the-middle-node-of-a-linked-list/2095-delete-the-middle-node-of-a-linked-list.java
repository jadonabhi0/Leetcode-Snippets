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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null) return null;
        if(head.next==null) return null;
        int count = -1 ;
        ListNode temp = head;
        ListNode prev = null;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        if(count%2 == 0){
            count = count;
        }else{
            count = count+1;
        }
        int n = count/2;
        ListNode dummy1 = head;
        ListNode dummy2 = null;
        while(n-->0){
            dummy2 = dummy1;
            dummy1 =dummy1.next;
        }
        dummy2.next = dummy1.next;
        
        return head;
    }
}
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
    public ListNode partition(ListNode head, int x) {
        if(head == null){return null;} 
        else if (head != null && head.next == null){
            return head;}
        else{
      ListNode temp = head;
      ListNode dummy1 = new ListNode(0);
      ListNode small= dummy1;
      ListNode dummy2 = new ListNode(0);
      ListNode large = dummy2;

      while(temp!=null){
          if (temp.val<x){
              small.next = new ListNode(temp.val);
              small=small.next;
              temp = temp.next;
          }else{
              large.next = new ListNode(temp.val);
              large = large.next;
              temp = temp.next;
          }
      }
      large.next = null;
      small.next = dummy2.next;
      return dummy1.next;
    }}
}
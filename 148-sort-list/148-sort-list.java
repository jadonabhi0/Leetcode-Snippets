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
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        ListNode temp = head;
        ListNode temp2 = head;
        ListNode prev = null;
        int counter = 0 ;
        int c =0 ;
        while(temp!=null){
            counter ++;
            temp = temp.next;
        }
        int [] array = new int[counter];
        while(temp2!=null){
            prev = temp2;
            array[c++] = prev.val;
            temp2 = temp2.next;
        }
        Arrays.sort(array);
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        for(int i : array){
            res.next = new ListNode(i);
            res = res.next;
        }
        return dummy.next;
    }
}
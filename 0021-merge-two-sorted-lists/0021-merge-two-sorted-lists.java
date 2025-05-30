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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;


        while(list1 != null && list2 != null){

            int val1 = list1.val;
            int val2 = list2.val;

            if(val1 > val2){
                dummy.next = list2;
                list2 = list2.next;
            }else{
                dummy.next = list1;
                list1 = list1.next;
            }
            dummy = dummy.next;

        }


        if(list1 != null) dummy.next = list1;
        if(list2 != null) dummy.next = list2;

        return ans.next;
    }
}
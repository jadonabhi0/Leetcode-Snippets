/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dummy = new ListNode(0);
        dummy.next = headA;
        ListNode dummy2 = new ListNode(0);
        dummy2.next = headB;
        HashSet set = new HashSet<>();
        while(dummy!=null){
            set.add(dummy);
            dummy = dummy.next;
        }
        while(dummy2!=null){
            if(set.contains(dummy2)){
                return dummy2;
            }else{
                dummy2 = dummy2.next;
            }
        }
        return null;
    }
    
    
    
//     HashSetset=new HashSet<>();
// ListNode currA=headA,currB=headB;
// while (currA!=null){set.add(currA);currA=currA.next;}
// while (currB!=null){
// if (set.contains(currB))return currB;
// currB=currB.next;
// }
// return null;
    
    
    
}
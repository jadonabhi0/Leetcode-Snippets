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
    
    public ListNode rev(ListNode node){
        ListNode prev = null;
        ListNode cur = node;
        
        while(cur != null){
            ListNode store = cur.next;
            cur.next = prev;
            prev = cur;
            cur = store;
            
        }
        return prev;
        
    }
    
    
     public boolean isPalindrome(ListNode head) {
         
         //FIRST APPROACH
         
//         List<Integer> intList = new ArrayList<Integer>();
        
//         ListNode temp = head;
//         while(temp != null){
//             intList.add(temp.val);
//             temp = temp.next;
//         }        
        
//         for(int i=0, j=intList.size()-1; i<=j; i++, j--){
//             if(intList.get(i)!=intList.get(j)){
//                 return false;
//             }
//         }
        
//         return true;        
         
         
        // SECOND APPROACH
         
         
         
         ListNode slow = head;
         ListNode fast = head;
         
         while(fast != null && fast.next != null){
             slow = slow.next;
             fast = fast.next.next;
         }
         
         ListNode temp1 = head;
         ListNode temp2 = rev(slow);
         
         
         while(temp1 != null && temp2 != null){
             if(temp1.val != temp2.val){
                 return false;
             }
             temp1=temp1.next;
             temp2=temp2.next;
         }
         return true;
    }    
}
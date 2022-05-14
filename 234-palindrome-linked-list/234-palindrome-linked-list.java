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
    
    
     public boolean isPalindrome(ListNode head) {
        List<Integer> intList = new ArrayList<Integer>();
        
        ListNode temp = head;
        while(temp != null){
            intList.add(temp.val);
            temp = temp.next;
        }        
        
        for(int i=0, j=intList.size()-1; i<=j; i++, j--){
            if(intList.get(i)!=intList.get(j)){
                return false;
            }
        }
        
        return true;        
    }    
}
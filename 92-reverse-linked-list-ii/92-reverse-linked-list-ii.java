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
    
    
    // THIS APPROACH WORKS FOR INPUT >= 3 SIZE LIST
    
    
//     public ListNode rev(ListNode node){
//         ListNode prev = null;
//         ListNode cur = node;
//         ListNode store = null;
        
//         while(cur != null){
//             store = cur.next;
//             cur.next = prev;
//             prev = cur;
//             cur = store;
//         }
//         return prev;
//     }
    
//     public ListNode reverseBetween(ListNode head, int left, int right) {
        
//         if(head.next == null) return head;
        
//         ListNode prev1 = null;
//         ListNode prev2 = null;
//         ListNode store = null;
//         ListNode temp = head;
//         ListNode dummy = null;
        
//         while(temp != null){
//             if(temp.next.val == left){
//                 prev1 = temp;
//                 dummy = temp.next;
//                 prev1.next = null;
//             }
//             temp = temp.next;
//         }
//         prev2 = dummy;
            
//         while(prev2 != null){
//             if(prev2.val == right){
//                 store = prev2.next;
//                 prev2.next = null;
//             }
//             prev2 = prev2.next;
//         }
        
//         ListNode temp3 = head;
//         ListNode prev3 = null;
//         while(temp3 != null){
//             prev3 = temp3;
//             temp3 = temp3.next;
//         }
//         prev3.next = rev(dummy);
        
//         temp3 = head;
//         prev3 = null;
        
//         while(temp3 != null){
//             prev3 = temp3;
//             temp3 = temp3.next;
//         }
        
//         prev3.next = store;
//         return head;
//     }
    
    
    
    
    
    
    
      public static void reverseArr(int[] arr , int left , int right){
        int start=left-1;
        int end = right-1;
        
        for(int i=start ; start<=end ; start++ , end--){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode newnode = head;
        int size = 0;
        while(newnode!=null){
            size++;
            newnode=newnode.next;
        }
        newnode = head;
        int arr[] = new int[size];
        int k=0;
        while(newnode!=null){
            arr[k] = newnode.val;
            k++;
            newnode=newnode.next;
        }
        
        reverseArr(arr , left , right);
        
        newnode = head;
        int i=0;
        while(newnode!=null){
            newnode.val = arr[i];
            newnode = newnode.next;
            i++;
        }
        
        return head;
        
    }
    
    
    
    
    
    
    
    
}
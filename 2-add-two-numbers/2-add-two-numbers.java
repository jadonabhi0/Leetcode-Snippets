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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
//         ListNode one = l1;
//         ListNode two = l2;
//         ListNode prev1 = null;
//         ListNode prev2 = null;
//         ListNode ans = null;
//         ListNode dummy = new ListNode(0);
//         ListNode head = dummy;
//         String s1 = "";
//         String s2 = "";
//         Stack<Integer> st = new Stack<>();
        
//         while(one!=null){
//             prev1 = one;
//             st.add(prev1.val);
//             one = one.next;
//         }
//         while(!st.isEmpty()){
//             s1 = s1+st.pop();
//         }
//         while(two!=null){
//             prev2 = two;
//             st.add(prev2.val);
//             two = two.next;
//         }
//         while(!st.isEmpty()){
//             s2 = s2+st.pop();
//         }
        
//         int a = Integer.parseInt(s1);
//         int b = Integer.parseInt(s2);
//         int c = a+b;
        
//         while(c>0){
//             if(c == 0){
//                 head.next = new ListNode(0);
//                 head = head.next;
//             }else{
//                 int n = c%10;
//                 c = c/10;
//                 head.next = new ListNode(n);
//                 head = head.next;
//             }
            
//         }
//         return dummy.next;
        
        
        
        ListNode a=l1;
        ListNode b=l2,head=null,t=null;
        int c=0,s,l,m;
        while(a!=null || b!=null ||c!=0)
        {
            
            l=(a==null)?0:a.val;
            m=(b==null)?0:b.val;
            s=(l+m+c)%10;
            c=(l+m+c)/10;
            if(head==null)
            {
                head=new ListNode(s);
                t=head;
            }
            
            else
            {
                t.next=new ListNode(s);
                t=t.next;
            }
            if(a!=null)
            a=a.next;
            if(b!=null)
            b=b.next;
        }
        return head;
        
        
        
        
    }
}
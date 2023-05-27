//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node next;
    public Node(int data)
    {
        this.data=data;
    }
}
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n=Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            Node head=new Node(Integer.parseInt(s[0]));
            Node copy=head;
            for(int i=1;i<n;i++){
                Node temp=new Node(Integer.parseInt(s[i]));
                copy.next=temp;
                copy=copy.next;
            }
            Solution ob=new Solution();
            Node ans=ob.modifyTheList(head);
            while(ans!=null){
                out.print(ans.data+" ");
                ans=ans.next;
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public static Node reverse(Node node){
        Node prev = null;
        Node cur = node;
        Node ahead = null;
        while(cur != null){
            ahead = cur.next;
            cur.next = prev;
            prev = cur;
            cur = ahead;
        }
        return prev;
    }
    
    public static Node modifyTheList(Node head)
    {
        Node temp = head;
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        Node ahead = reverse(slow.next);
        slow.next = null;
        Node dummy = new Node(0);
        Node ans = dummy;
        
        while(ahead != null && temp != null){
            ans.next = new Node(ahead.data-temp.data);
            ahead = ahead.next;
            temp = temp.next;
            ans = ans.next;
        }
        
        ans.next = reverse(head);
        return dummy.next;
    }
}
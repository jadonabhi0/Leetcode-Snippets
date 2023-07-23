//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(s[i]));
                tail = tail.next;
            }

            head = new Solution().segregate(head);
            printList(head, out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node head,PrintWriter out)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        int zero = 0;
        int one = 0;
        int two = 0;
        Node dummy = new Node(0);
        Node ans =  dummy;
        
        while(head != null){
            if(head.data == 0) zero++;
            else if(head.data == 1) one++;
            else two++;
            head = head.next;
        }
        
        for(int i = 0 ; i < zero ; i++){
            ans.next = new Node(0);
            ans = ans.next;
        }
        
        for(int i = 0 ; i < one ; i++){
            ans.next = new Node(1);
            ans = ans.next;
        }
        
        for(int i = 0 ; i < two ; i++){
            ans.next = new Node(2);
            ans = ans.next;
        }
        
        return dummy.next;
    }
}



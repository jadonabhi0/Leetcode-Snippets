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
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
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
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    
    public static Node midNode(Node head){
        if(head == null || head.next == null) return head;
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public static Node merge(Node l1, Node l2){
        if(l1 == null || l2 == null) return l1 == null ? l2 : l1;
        Node dummy = new Node(-1);
        Node prev = dummy;
        while(l1 != null && l2 != null){
            if(l1.data < l2.data){
                prev.next = l1;
                l1 = l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
    
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        if(head == null || head.next == null) return head;
        // add your code here
        Node mid = midNode(head);
        Node nHead = mid.next;
        mid.next = null;
        Node l1 = mergeSort(nHead);
        Node l2 = mergeSort(head);
        return merge(l1, l2);
    }
}



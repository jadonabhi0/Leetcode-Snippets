//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}


// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }
class Solution{
    
    static class BSTPair{
        boolean isBst;
        int min;
        int max;
        int size;
        Node root;
    }
    public static BSTPair isBst(Node node){
        
        if(node == null){
            BSTPair bp = new BSTPair();
            bp.isBst = true;
            bp.max = Integer.MIN_VALUE;
            bp.min = Integer.MAX_VALUE;
            bp.size = 0;
            bp.root = null;
            return bp;
        }
        
        BSTPair lp = isBst(node.left);
        BSTPair rp = isBst(node.right);
        
        BSTPair mp = new BSTPair();
        mp.isBst = lp.isBst && rp.isBst && 
        (node.data > lp.max && node.data < rp.min);
        
        mp.max = Math.max(node.data, Math.max(lp.max, rp.max));
        mp.min = Math.min(node.data, Math.min(lp.min, rp.min));
        
        if(mp.isBst){
            mp.root = node;
            mp.size = lp.size + rp.size + 1;
        }else if(lp.size > rp.size){
            mp.root = lp.root;
            mp.size = lp.size;
        }else{
            mp.root = rp.root;
            mp.size = rp.size;
        }
        
        return mp;
    }
    

    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        return isBst(root).size;
        
        
    }
    
}
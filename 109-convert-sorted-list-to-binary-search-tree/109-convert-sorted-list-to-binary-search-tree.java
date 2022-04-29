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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static int c = 0;
    public int size(ListNode node){
        c = 0;
        while(node != null){
            c++;
            node = node.next;
        }
        return c;
    }
    
    public TreeNode getNode(int[] array, int lo, int hi){
        if(lo > hi) return null;
        int mid = (lo+hi)/2;
        TreeNode node = new TreeNode(array[mid]);
        node.left = getNode(array,lo,mid-1);
        node.right = getNode(array,mid+1,hi);
        return node;
        
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        int s = size(head);
        int cc = 0;
        int[] array = new int[s];
        while(head != null){
            array[cc++] = head.val;
            head = head.next;
            
        }
        return getNode(array,0,s-1);
    }
}
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> toBeDel = new HashSet<>();
        for(var num : nums)toBeDel.add(num);
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode curr = dummyHead, prev = dummyHead;
        while(curr != null){
            ListNode nextNode = curr.next;
            if(toBeDel.contains(curr.val)){
                prev.next = nextNode;
            }else{
                prev = curr;
            }
            curr = nextNode;
        }
        return dummyHead.next;
    }
}
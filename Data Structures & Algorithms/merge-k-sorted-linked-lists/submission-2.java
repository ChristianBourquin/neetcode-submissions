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
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length == 0){
            return null;
        }
        for(int i = 1; i < lists.length; i++){
            lists[i] = merge(lists[i-1], lists[i]); 
        }
        return lists[lists.length - 1];
    }

    private ListNode merge(ListNode left, ListNode right){
        ListNode pointer = new ListNode(0);
        ListNode curr = pointer;
        while(left != null && right != null){
            if(left.val <= right.val){
                curr.next = left;
                left = left.next;
            }else{
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }

        if(left == null){
            curr.next = right;
        }else{
            curr.next = left;
        }
        return pointer.next;
    }
}
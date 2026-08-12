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

        ListNode head = lists[0];
        for(int i = 1; i < lists.length; i++){
            ListNode current = lists[i];

            if(current == null){
                continue;
            }

            if(head == null || current.val < head.val){
                ListNode temp = current.next;
                current.next = head;
                head = current;
                current = temp;
            }

            ListNode finalList = head;

            while(current != null){
                
                if(finalList.next == null){
                    finalList.next = current;
                    break;
                }else if(finalList.next.val >= current.val){
                    ListNode temp = current.next;
                    current.next = finalList.next;
                    finalList.next = current;
                    current = temp;
                }else{
                    finalList = finalList.next;
                }
            }
        }
        return head;
    }
}

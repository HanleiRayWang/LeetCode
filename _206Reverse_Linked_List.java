/*

Reverse a singly linked list.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        
        if(head==null || head.next==null)
            return head;
        
        ListNode pre = new ListNode(0);
        pre.next = head;
        
        ListNode helper = head;
        
        while(head.next!=null){
            pre.next = head.next;
            head.next = head.next.next;
            pre.next.next = helper;
            helper = pre.next;
        }
        
        return pre.next;
    }
}

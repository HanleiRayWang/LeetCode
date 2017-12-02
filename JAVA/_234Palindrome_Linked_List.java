/*

Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
可以把linkedlist存成stack，再比较stack和原始的list，但是这样是O(n) space
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
//找到中点，reverse后半段，比较
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
            return true;
        ListNode slow=head, fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode helper = slow.next;
        helper=reverse(helper);
        
        while(helper!=null){
            if(head.val!=helper.val)
                return false;
            head=head.next;
            helper=helper.next;
        }
        
        return true;
    }
    
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode pre = new ListNode(0);
        pre.next=head;
        ListNode helper = head;
        while(head.next!=null){
            pre.next=head.next;
            head.next=head.next.next;
            pre.next.next=helper;
            helper=pre.next;
        }
        return pre.next;
    }
}

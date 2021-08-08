// Source : https://leetcode.com/problems/palindrome-linked-list/
// Author : Kris
// Date   : 2020-10-08

/***************************************************************************************************** 
 *
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Example 1:
 * 
 * Input: 1->2
 * Output: false
 * 
 * Example 2:
 * 
 * Input: 1->2->2->1
 * Output: true
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 ******************************************************************************************************/

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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        var slow = head;
        var fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        var second = slow.next;
        slow.next = null;
        second = reverse(second);
        
        // 前半段 len == 后半段 + 0/1
        while (second != null) {
            if (head.val == second.val) {
                head = head.next;
                second = second.next;
            } else {
                return false;
            }
        }
        
        return true;
    }
    
    ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            var next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        
        return newHead;
    }
}
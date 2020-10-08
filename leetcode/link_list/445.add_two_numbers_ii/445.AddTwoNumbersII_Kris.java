// Source : https://leetcode.com/problems/add-two-numbers-ii/
// Author : Kris
// Date   : 2020-10-08

/***************************************************************************************************** 
 *
 * You are given two non-empty linked lists representing two non-negative integers. The most 
 * significant digit comes first and each of their nodes contain a single digit. Add the two numbers 
 * and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * 
 * Example:
 * 
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 * 
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        var dummy = new ListNode();
        var tmp = dummy;
        
        var add = 0;
        while (l1 != null || l2 != null) {
            var sum = add;
            
            if (l1 != null && l2 != null) {
                sum += l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            } else {
                sum += l2.val;
                l2 = l2.next;
            }
            
            add = sum / 10;
            tmp.next = new ListNode(sum % 10);
            tmp = tmp.next;
        }
        
        if (add == 1) {
            tmp.next = new ListNode(1);
        }
        
        return reverse(dummy.next);
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
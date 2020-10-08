// Source : https://leetcode.com/problems/reorder-list/
// Author : Kris
// Date   : 2020-10-08

/***************************************************************************************************** 
 *
 * Given a singly linked list L: L0&rarr;L1&rarr;&hellip;&rarr;Ln-1&rarr;Ln,
 * reorder it to: L0&rarr;Ln&rarr;L1&rarr;Ln-1&rarr;L2&rarr;Ln-2&rarr;&hellip;
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * 
 * Example 1:
 * 
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * 
 * Example 2:
 * 
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        var mid = findMiddle(head);
        var second = mid.next;
        mid.next = null; // 断开
        
        second = reverse(second);
        
        var dummy = new ListNode();
        var cur = dummy;
        var isFirst = true;
       
        while (second != null) {
            if (isFirst) {
                cur.next = head;
                head = head.next;
            } else {
                cur.next = second;
                second = second.next;
            }
            cur = cur.next;
            isFirst = !isFirst;
        }
        
        if (head != null) {
            cur.next = head;
        }
    }
    
    ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
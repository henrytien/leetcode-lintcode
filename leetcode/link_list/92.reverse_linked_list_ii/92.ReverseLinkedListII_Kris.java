// Source : https://leetcode.com/problems/reverse-linked-list-ii/
// Author : Kris
// Date   : 2020-10-08

/***************************************************************************************************** 
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 &le; m &le; n &le; length of list.
 * 
 * Example:
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m >= n) {
            return head;
        }
        
        var dummy = new ListNode(-1, head);
        
        ListNode before = null, start = null, end = null, after = null;
        var len = n - m + 1;
        
        var cur = dummy;
        while (m-- > 0) {
            before = cur;
            if (cur == null) { // 异常情况
                return null;
            }
            cur = cur.next;
        }
        start = before.next;
        
        while (len-- > 0) {
            end = cur;
            if (cur == null) { // 异常情况
                return null;
            }
            cur = cur.next;
        }
        after = end.next;
        
        // System.out.println(before.val);
        // System.out.println(start.val);
        // System.out.println(end.val);
        // System.out.println(after == null ? -1 : after.val);
        
        // 这里传入 after 而不是 end
        reverse(start, after);
        
        before.next = end;
        start.next = after;
        
        return dummy.next;
    }
    
    private ListNode reverse(ListNode start, ListNode after) {
        ListNode newHead = null;
        while (start != after) {
            var next = start.next;
            start.next = newHead;
            newHead = start;
            start = next;
        }
        
        return newHead;
    }
}
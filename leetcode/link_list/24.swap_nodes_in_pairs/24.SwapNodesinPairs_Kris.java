// Source : https://leetcode.com/problems/swap-nodes-in-pairs/
// Author : Kris
// Date   : 2020-10-08

/***************************************************************************************************** 
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes. Only nodes itself may be changed.
 * 
 * Example 1:
 * 
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * 
 * Example 2:
 * 
 * Input: head = []
 * Output: []
 * 
 * Example 3:
 * 
 * Input: head = [1]
 * Output: [1]
 * 
 * Constraints:
 * 
 * 	The number of nodes in the list is in the range [0, 100].
 * 	0 <= Node.val <= 100
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
    // same to https://leetcode.com/problems/reverse-nodes-in-k-group/
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        var dummy = new ListNode(0, head);
        var tmp = dummy;
        
        while (tmp != null) {
            var tail = tmp;
            for (var i = 0; i < 2; i++) {
                if (tail != null) {
                    tail = tail.next;
                }
            }
            
            // 不足 k 个的
            if (tail == null) {
                break;
            }
            
            var before = tmp;
            var start = tmp.next;
            var end = tail;
            var after = tail.next;
            
            reverse(start, 2);
            
            before.next = end;
            start.next = after;
            
            tmp = start;
        }
        
        return dummy.next;
    }
    
    ListNode reverse(ListNode head, int k) {
        ListNode newHead = null;
        while (head != null && k-- > 0) {
            var next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        
        return newHead;
    }
}
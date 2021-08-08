// Source : https://leetcode.com/problems/reverse-nodes-in-k-group/
// Author : Kris
// Date   : 2020-10-08

/***************************************************************************************************** 
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked list. If the number 
 * of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * 
 * Follow up:
 * 
 * 	Could you solve the problem in O(1) extra memory space?
 * 	You may not alter the values in the list's nodes, only nodes itself may be changed.
 * 
 * Example 1:
 * 
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * 
 * Example 2:
 * 
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 * 
 * Example 3:
 * 
 * Input: head = [1,2,3,4,5], k = 1
 * Output: [1,2,3,4,5]
 * 
 * Example 4:
 * 
 * Input: head = [1], k = 1
 * Output: [1]
 * 
 * Constraints:
 * 
 * 	The number of nodes in the list is in the range sz.
 * 	1 <= sz <= 5000
 * 	0 <= Node.val <= 1000
 * 	1 <= k <= sz
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        
        var dummy = new ListNode(0, head);
        var tmp = dummy;
        
        while (tmp != null) {
            var tail = tmp; // 要从 head 前一个开始，因为要停在第 k 个元素上
            for (var i = 0; i < k && tail != null; i++) {
                tail = tail.next;
            }
            
            // 不足 k 个的
            if (tail == null) {
                break;
            }
            
            var before = tmp;
            var start = tmp.next;
            var end = tail;
            var after = tail.next;
            
            reverse(start, k);
            
            before.next = end;
            start.next = after;
            
            tmp = start;
        }
        
        return dummy.next;
    }
    
    ListNode reverse(ListNode head, int k) {
        ListNode newHead = null;
        while (/* head != null && */ k > 0) {
            var next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
            k--;
        }
        return newHead;
    }
}
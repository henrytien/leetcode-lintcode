// Source : https://leetcode.com/problems/sort-list/
// Author : Kris
// Date   : 2020-10-08

/***************************************************************************************************** 
 *
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * 
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 * 
 * Example 1:
 * 
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * 
 * Example 2:
 * 
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * 
 * Example 3:
 * 
 * Input: head = []
 * Output: []
 * 
 * Constraints:
 * 
 * 	The number of nodes in the list is in the range [0, 5 * 104].
 * 	-105 <= Node.val <= 105
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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    
    ListNode mergeSort(ListNode start) {
        if (start == null || start.next == null) {
            return start;
        }
        
        ListNode slow = start, fast = start.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        
        var second = slow.next;
        slow.next = null; // 使前后两段链表断开
        
        var left = mergeSort(start);
        var right = mergeSort(second);
        return merge(left, right);
    }
    
    // 简单的合并两个排序好的链表即可 https://leetcode.com/problems/merge-two-sorted-lists/
    ListNode merge(ListNode left, ListNode right) {
        var dummy = new ListNode();
        var cur = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        
        if (left != null) {
            cur.next = left;
        }
        
        if (right != null) {
            cur.next = right;
        }
        
        return dummy.next;
    }
}
// Source : https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
// Author : Kris
// Date   : 2020-10-15

/***************************************************************************************************** 
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct 
 * numbers from the original list.
 * 
 * Return the linked list sorted as well.
 * 
 * Example 1:
 * 
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * 
 * Example 2:
 * 
 * Input: 1->1->1->2->3
 * Output: 2->3
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        
        var dummy = new ListNode(-1, head);
        // 初始时 pre.next 指向的就是 cur，需要一直保持下去
        var pre = dummy;
        var cur = dummy.next;
        
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                var val = cur.val;
                while (cur != null && cur.val == val) {
                    cur = cur.next;
                }
                
                // System.out.println(cur != null ? cur.val : -1);
                // cur is null or cur.val != val
                // 这里 pre 其实没有移动，把重复的前 k - 1 个跳过了，取最后一个
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        
        return dummy.next;
    }
}
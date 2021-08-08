// Source : https://leetcode.com/problems/partition-list/
// Author : Kris
// Date   : 2020-10-08

/***************************************************************************************************** 
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes 
 * greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * Example:
 * 
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
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
    public ListNode partition(ListNode head, int x) {       
        if (head == null) {
            return null;
        }
        
        var dummyLess = new ListNode();
        var dummyGreater = new ListNode();
        var less = dummyLess;
        var greater = dummyGreater;
        
        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }
        
        less.next = dummyGreater.next;
        greater.next = null;
        
        return dummyLess.next;
    }
}
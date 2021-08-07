// Source : https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
// Author : Kris
// Date   : 2020-08-10

/***************************************************************************************************** 
 *
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height 
 * balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of 
 * the two subtrees of every node never differ by more than 1.
 * 
 * Example:
 * 
 * Given the sorted linked list: [-10,-3,0,5,9],
 * 
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * 
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        
        var pre = findMiddle(head);
        var mid = pre == null ? head : pre.next;
        
        var rightListNode = mid.next;
        mid.next = null;
        var right = sortedListToBST(rightListNode);
        
        TreeNode left = null;
        if (pre != null) {
            pre.next = null;
            left = sortedListToBST(head);
        }

        return new TreeNode(mid.val, left, right);
    }
    
    ListNode findMiddle(ListNode head) {
        ListNode pre = null, slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return pre;
    }
}
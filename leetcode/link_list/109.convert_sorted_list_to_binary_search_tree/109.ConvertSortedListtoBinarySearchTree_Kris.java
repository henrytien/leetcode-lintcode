// Source : https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
// Author : Kris
// Date   : 2020-10-15

/***************************************************************************************************** 
 *
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to 
 * a height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of 
 * the two subtrees of every node never differ by more than 1.
 * 
 * Example 1:
 * 
 * Input: head = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced 
 * BST.
 * 
 * Example 2:
 * 
 * Input: head = []
 * Output: []
 * 
 * Example 3:
 * 
 * Input: head = [0]
 * Output: [0]
 * 
 * Example 4:
 * 
 * Input: head = [1,3]
 * Output: [3,1]
 * 
 * Constraints:
 * 
 * 	The number of nodes in head is in the range [0, 2 * 104].
 * 	-10^5 <= Node.val <= 10^5
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
    // Time: O(n), Space: O(n)
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        
        var list = new ArrayList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        return helper(list, 0, list.size() - 1);
    }
    
    TreeNode helper(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        
        var mid = start + (end - start) / 2;
        var left = helper(list, start, mid - 1);
        var right = helper(list, mid + 1, end);
        return new TreeNode(list.get(mid), left, right);
    }
    
    // Time: O(nlogn), Space: O(logn)
    public TreeNode sortedListToBST_2(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) { // 仅有一个元素
            return new TreeNode(head.val);
        }
        
        var mid = findMiddle(head);
        
        var left = sortedListToBST(head);
        
        // mid != null
        var rightListNode = mid.next;
        // mid.next = null; // 这里断不断开 mid.next 都可以
        var right = sortedListToBST(rightListNode);

        return new TreeNode(mid.val, left, right);
    }
    
    ListNode findMiddle(ListNode head) {
        ListNode pre = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Handling the case when slow is equal to head.
        if (pre != null) {
            // Disconnect the left half from the mid node.
            pre.next = null; 
        }
        
        return slow;
    }
}
// Source : https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
// Author : Kris
// Date   : 2020-08-28

/***************************************************************************************************** 
 *
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example, given the following tree:
 * 
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 
 * The flattened tree should look like:
 * 
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * 
 ******************************************************************************************************/

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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        var left = root.left;
        var right = root.right; // 缓存起来，root.right 在 helper(left, root) 会被修改
        if (pre != null) {
            pre.left = null;
            pre.right = root;
        }
        pre = root;
        
        flatten(left);
        flatten(right);
    }
    
    TreeNode pre = null;
}
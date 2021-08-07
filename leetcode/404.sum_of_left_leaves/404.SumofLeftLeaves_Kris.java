// Source : https://leetcode.com/problems/sum-of-left-leaves/
// Author : Kris
// Date   : 2020-11-28

/***************************************************************************************************** 
 *
 * Find the sum of all left leaves in a given binary tree.
 * 
 * Example:
 * 
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
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
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }
    
    int helper(TreeNode node, boolean use) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return use ? node.val : 0;
        }

        var left = helper(node.left, true);
        var right = helper(node.right, false);
        return left + right;
    }
}
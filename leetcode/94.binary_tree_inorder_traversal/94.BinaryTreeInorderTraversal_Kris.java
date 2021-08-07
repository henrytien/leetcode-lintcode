// Source : https://leetcode.com/problems/binary-tree-inorder-traversal/
// Author : Kris
// Date   : 2020-08-28

/***************************************************************************************************** 
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * 
 * Output: [1,3,2]
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> inorderTraversal(TreeNode root) {
        var result = new ArrayList<Integer>();
        var stack = new Stack<TreeNode>();
        
        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else if (!stack.empty()) {
                var cur = stack.pop();
                result.add(cur.val);
                root = cur.right;
            }
        }
        
        return result;
    }
}
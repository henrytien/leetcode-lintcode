// Source : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
// Author : Kris
// Date   : 2020-08-28

/***************************************************************************************************** 
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * 
 * Return the following binary tree:
 * 
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0) {
            return null;
        }
        
        var root = helper(preorder, 0, inorder, 0, inorder.length - 1);
        return root;
    }
    
    private TreeNode helper(int[] preorder, int p1, int[] inorder, int i1, int i2) {
        if (i1 > i2) {
            return null;
        }
        
        var count = findCount(preorder[p1], inorder, i1);
        var left = helper(preorder, p1 + 1,
                          inorder, i1, i1 + count - 1);
        var right = helper(preorder, p1 + count + 1,
                          inorder, i1 + count + 1, i2);
        
        return new TreeNode(preorder[p1], left, right);
    }
    
    int findCount(int target, int[] inorder, int start) {
        var count = 0;
        while (inorder[start++] != target) {
            count++;
        }
        
        return count;
    }
}
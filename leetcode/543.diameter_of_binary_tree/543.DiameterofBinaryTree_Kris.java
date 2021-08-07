// Source : https://leetcode.com/problems/diameter-of-binary-tree/
// Author : Kris
// Date   : 2020-08-28

/***************************************************************************************************** 
 *
 * 
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a 
 * binary tree is the length of the longest path between any two nodes in a tree. This path may or may 
 * not pass through the root.
 * 
 * Example:
 * Given a binary tree 
 * 
 *           1
 *          / \
 *         2   3
 *        / \     
 *       4   5    
 * 
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * 
 * Note:
 * The length of path between two nodes is represented by the number of edges between them.
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
    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root).anyToAny;
    }
    
    ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, -1);
        }
        
        var left = helper(root.left);
        var right = helper(root.right);
        var rootToAny = Math.max(left.rootToAny, right.rootToAny) + 1;
        
        var anyToAny = Math.max(Math.max(left.anyToAny, right.anyToAny),
                               left.rootToAny + right.rootToAny + 2);
        
        return new ResultType(anyToAny, rootToAny);
    }
}

class ResultType {
    public int anyToAny;
    public int rootToAny;
    
    public ResultType(int anyToAny, int rootToAny) {
        this.anyToAny = anyToAny;
        this.rootToAny = rootToAny;
    }
}
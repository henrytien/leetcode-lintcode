// Source : https://leetcode.com/problems/binary-tree-maximum-path-sum/
// Author : Kris
// Date   : 2020-11-28

/***************************************************************************************************** 
 *
 * Given a non-empty binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any node sequence from some starting node to any node in the 
 * tree along the parent-child connections. The path must contain at least one node and does not need 
 * to go through the root.
 * 
 * Example 1:
 * 
 * Input: root = [1,2,3]
 * Output: 6
 * 
 * Example 2:
 * 
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * 
 * Constraints:
 * 
 * 	The number of nodes in the tree is in the range [0, 3 * 104].
 * 	-1000 <= Node.val <= 1000
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
    public int maxPathSum(TreeNode root) {
        return helper(root).anyToAny;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            // must use Integer.MIN_VALUE, e.g., [-3], we should get -3 rather than 0
            return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        int rootToAny = Math.max(Math.max(left.rootToAny, right.rootToAny), 0) + root.val;
        int anyToAny = Math.max(
            Math.max(left.anyToAny, right.anyToAny), 
            Math.max(left.rootToAny, 0) + Math.max(right.rootToAny, 0) + root.val);
        
        return new ResultType(rootToAny, anyToAny);
    }
    
    public class ResultType {
        public int rootToAny;
        public int anyToAny;
        
        public ResultType(int rootToAny, int anyToAny) {
            this.rootToAny = rootToAny;
            this.anyToAny = anyToAny;
        }
    }
}
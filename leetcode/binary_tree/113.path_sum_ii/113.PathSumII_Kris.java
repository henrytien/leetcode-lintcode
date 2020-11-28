// Source : https://leetcode.com/problems/path-sum-ii/
// Author : Kris
// Date   : 2020-11-28

/***************************************************************************************************** 
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given 
 * sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * 
 * Return:
 * 
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(root, sum, new ArrayList<>(), result);
        
        return result;
    }
    
    public void helper(TreeNode root, int sum, List<Integer> list, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                list.add(root.val);
                result.add(new ArrayList(list));
                list.remove(list.size() - 1);
            }
            return;
        }
        
        list.add(root.val);
        helper(root.left, sum - root.val, list, result);
        helper(root.right, sum - root.val, list, result);
        list.remove(list.size() - 1);
    }
}
// Source : https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
// Author : Kris
// Date   : 2020-11-28

/***************************************************************************************************** 
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left 
 * to right, then right to left for the next level and alternate between).
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 
 * return its zigzag level order traversal as:
 * 
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        var result = new ArrayList<List<Integer>>();
        var lStack = new Stack<TreeNode>();
        var rStack = new Stack<TreeNode>();
        
        if (root != null) {
            lStack.push(root);
        }
        
        while (!lStack.empty() || !rStack.empty()) {
            var list = new ArrayList<Integer>();
            
            if (!lStack.empty()) {
                var size = lStack.size();
                for (var i = 0; i < size; i++) {
                    var cur = lStack.pop();
                    list.add(cur.val);
                    
                    if (cur.left != null) {
                        rStack.push(cur.left);
                    }
                    if (cur.right != null) {
                        rStack.push(cur.right);
                    }
                }
            } else {
                var size = rStack.size();
                for (var i = 0; i < size; i++) {
                    var cur = rStack.pop();
                    list.add(cur.val);
                    
                    if (cur.right != null) {
                        lStack.push(cur.right);
                    }
                    if (cur.left != null) {
                        lStack.push(cur.left);
                    }
                }
            }
            
            result.add(list);
        }
        
        return result;
    }
}
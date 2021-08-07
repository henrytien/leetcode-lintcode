// Source : https://leetcode.com/problems/binary-tree-level-order-traversal/
// Author : Kris
// Date   : 2020-08-28

/***************************************************************************************************** 
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to 
 * right, level by level).
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
 * return its level order traversal as:
 * 
 * [
 *   [3],
 *   [9,20],
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        var result = new ArrayList<List<Integer>>();
        var queue = new LinkedList<TreeNode>();
        if (root != null) {
            queue.offer(root);
        }
        
        while (queue.size() > 0) {
            var list = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                var cur = queue.poll();
                
                list.add(cur.val);

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            result.add(list);
        }
        
        return result;
    }
}
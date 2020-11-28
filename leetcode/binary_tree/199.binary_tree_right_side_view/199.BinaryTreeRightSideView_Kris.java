// Source : https://leetcode.com/problems/binary-tree-right-side-view/
// Author : Kris
// Date   : 2020-11-28

/***************************************************************************************************** 
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the 
 * nodes you can see ordered from top to bottom.
 * 
 * Example:
 * 
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 * 
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
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
    public List<Integer> rightSideView(TreeNode root) {
        var result = new ArrayList<Integer>();
        var queue = new LinkedList<TreeNode>();
        if (root != null) {
            queue.offer(root);
        }
        
        while (queue.size() > 0) {
            var size = queue.size();
            for (var i = 0; i < size; i++) {
                var cur = queue.poll();
                
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                
                if (i == size - 1) {
                    result.add(cur.val);
                }
            }
        }
        
        return result;
    }
}
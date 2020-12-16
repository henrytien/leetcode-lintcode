// Source : https://leetcode.com/problems/average-of-levels-in-binary-tree/
// Author : Kris
// Date   : 2020-11-28

/***************************************************************************************************** 
 *
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of 
 * an array.
 * 
 * Example 1:
 * 
 * Input:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return 
 * [3, 14.5, 11].
 * 
 * Note:
 * 
 * The range of node's value is in the range of 32-bit signed integer.
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
    public List<Double> averageOfLevels(TreeNode root) {
        var result = new ArrayList<Double>();
        
        var queue = new LinkedList<TreeNode>();
        if (root != null) {
            queue.offer(root);
        }
        
        while (!queue.isEmpty()) {
            var size = queue.size();
            var sum = 0d;
            for (var i = 0; i < size; i++) {
                var cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            
            result.add(sum / size);
        }
        
        return result;
    }
}
// Source : https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
// Author : Kris
// Date   : 2020-08-28

/***************************************************************************************************** 
 *
 * Return the root node of a binary search tree that matches the given preorder traversal.
 * 
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of 
 * node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also 
 * recall that a preorder traversal displays the value of the node first, then traverses node.left, 
 * then traverses node.right.)
 * 
 * It's guaranteed that for the given test cases there is always possible to find a binary search tree 
 * with the given requirements.
 * 
 * Example 1:
 * 
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 * 
 * Constraints:
 * 
 * 	1 <= preorder.length <= 100
 * 	1 <= preorder[i] <= 10^8
 * 	The values of preorder are distinct.
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
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        
        nextGreater = findNextGreater(preorder);
        // System.out.println(Arrays.toString(nextGreater));
        
        return helper(preorder, 0, preorder.length - 1);
    }
    
    int[] findNextGreater(int[] nums) {
        var result = new int[nums.length];
        var stack = new Stack<Integer>();
        var index = 0;
        while (index < nums.length) {
            if (stack.isEmpty() || nums[stack.peek()] >= nums[index]) {
                stack.push(index);
                index++;
            } else {
                result[stack.pop()] = index;
            }
        }
        
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        
        return result;
    }
    
    TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        
        var cur = new TreeNode(nums[left]);
        if (nextGreater[left] != -1 && nextGreater[left] <= right) {
            cur.left = helper(nums, left + 1, nextGreater[left] - 1);
            cur.right = helper(nums, nextGreater[left], right);
        } else {
            cur.left = helper(nums, left + 1, right);
        }
        
        return cur;
    }
    
    int[] nextGreater;
}
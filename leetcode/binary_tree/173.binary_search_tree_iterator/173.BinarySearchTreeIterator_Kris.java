// Source : https://leetcode.com/problems/binary-search-tree-iterator/
// Author : Kris
// Date   : 2020-08-28

/***************************************************************************************************** 
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the 
 * root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Example:
 * 
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 * 
 * Note:
 * 
 * 	next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the 
 * height of the tree.
 * 	You may assume that next() call will always be valid, that is, there will be at least a 
 * next smallest number in the BST when next() is called.
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
class BSTIterator {
    private Queue<Integer> queue = new LinkedList<>();
    
    public BSTIterator(TreeNode root) {
        init(root);
    }
    
    private void init(TreeNode root) {
        if (root == null) {
            return;
        }
        
        init(root.left);
        queue.offer(root.val);
        init(root.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return queue.size() > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
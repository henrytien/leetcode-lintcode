// Source : https://leetcode.com/problems/delete-node-in-a-bst/
// Author : Kris
// Date   : 2020-11-28

/***************************************************************************************************** 
 *
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. 
 * Return the root node reference (possibly updated) of the BST.
 * 
 * Basically, the deletion can be divided into two stages:
 * 
 * 	Search for a node to remove.
 * 	If the node is found, delete the node.
 * 
 * Follow up: Can you solve it with time complexity O(height of tree)?
 * 
 * Example 1:
 * 
 * Input: root = [5,3,6,2,4,null,7], key = 3
 * Output: [5,4,6,2,null,null,7]
 * Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
 * One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
 * Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
 * 
 * Example 2:
 * 
 * Input: root = [5,3,6,2,4,null,7], key = 0
 * Output: [5,3,6,2,4,null,7]
 * Explanation: The tree does not contain a node with value = 0.
 * 
 * Example 3:
 * 
 * Input: root = [], key = 0
 * Output: []
 * 
 * Constraints:
 * 
 * 	The number of nodes in the tree is in the range [0, 104].
 * 	-105 <= Node.val <= 105
 * 	Each node has a unique value.
 * 	root is a valid binary search tree.
 * 	-105 <= key <= 105
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
    public TreeNode deleteNode(TreeNode root, int key) {
        var result = findNode(null, root, key);
        if (result == null) {
            return root;
        }
        
        var parent = result[0];
        var node = result[1];
        if (parent == null) { // node == root
            if (root.right == null) {
                root = root.left;
            } else {
                var leftMost = findLeftMost(root.right);
                leftMost.left = root.left;
                root = root.right;
            }
        } else if (node.right == null) {
            if (parent.left == node) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        } else {
            if (parent.left == node) {
                var leftMost = findLeftMost(node.right);
                parent.left = node.right;
                leftMost.left = node.left;
            } else {
                var leftMost = findLeftMost(node.right);
                parent.right = node.right;
                leftMost.left = node.left;
            }
        }

        return root;
    }
    
    TreeNode[] findNode(TreeNode parent, TreeNode node, int key) {
        if (node == null) {
            return null;
        }
        
        if (node.val == key) {
            return new TreeNode[] {parent, node};
        }
        
        var left = findNode(node, node.left, key);
        var right = findNode(node, node.right, key);
        if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else {
            return null;
        }
    }
    
    TreeNode findLeftMost(TreeNode root) {
        while (root != null && root.left != null) {
            root = root.left;
        }
        return root;
    }
}
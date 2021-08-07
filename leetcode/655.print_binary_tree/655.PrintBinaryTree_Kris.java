// Source : https://leetcode.com/problems/print-binary-tree/
// Author : Kris
// Date   : 2020-11-28

/***************************************************************************************************** 
 *
 * Print a binary tree in an m*n 2D string array following these rules: 
 * 
 * The row number m should be equal to the height of the given binary tree.
 * The column number n should always be an odd number.
 * The root node's value (in string format) should be put in the exactly middle of the first row it 
 * can be put. The column and the row where the root node belongs will separate the rest space into 
 * two parts (left-bottom part and right-bottom part). You should print the left subtree in the 
 * left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the 
 * right-bottom part should have the same size. Even if one subtree is none while the other is not, 
 * you don't need to print anything for the none subtree but still need to leave the space as large as 
 * that for the other subtree. However, if two subtrees are none, then you don't need to leave space 
 * for both of them. 
 * Each unused space should contain an empty string "".
 * Print the subtrees following the same rules.
 * 
 * Example 1:
 * 
 * Input:
 *      1
 *     /
 *    2
 * Output:
 * [["", "1", ""],
 *  ["2", "", ""]]
 * 
 * Example 2:
 * 
 * Input:
 *      1
 *     / \
 *    2   3
 *     \
 *      4
 * Output:
 * [["", "", "", "1", "", "", ""],
 *  ["", "2", "", "", "", "3", ""],
 *  ["", "", "4", "", "", "", ""]]
 * 
 * Example 3:
 * 
 * Input:
 *       1
 *      / \
 *     2   5
 *    / 
 *   3 
 *  / 
 * 4 
 * Output:
 * 
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 *  ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 *  ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 *  ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 * 
 * Note:
 * The height of binary tree is in the range of [1, 10].
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
    public List<List<String>> printTree(TreeNode root) {
        var height = getHeight(root);
        var len = (int) Math.pow(2, height) - 1;
        var matrix = new ArrayList<List<String>>();
        for (var i = 0; i < height; i++) {
            var list = new ArrayList<String>();
            for (var j = 0; j < len; j++) {
                list.add("");
            }
            matrix.add(list);
        }
        
        helper(matrix, 0, root, 0, len - 1);
        return matrix;
    }
    
    void helper(List<List<String>> matrix, int level, TreeNode root, int left, int right) {
        if (root == null || level == matrix.size()) {
            return;
        }

        var mid = (left + right) / 2;
        matrix.get(level).set(mid, String.valueOf(root.val));

        helper(matrix, level + 1, root.left, left, mid - 1);
        helper(matrix, level + 1, root.right, mid + 1, right);
    }
    
    int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        var left = getHeight(root.left);
        var right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }
}
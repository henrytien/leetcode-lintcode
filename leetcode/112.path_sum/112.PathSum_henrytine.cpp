// Source : https://leetcode.com/problems/path-sum/
// Author : henrytine
// Date   : 2020-11-20

/***************************************************************************************************** 
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up 
 * all the values along the path equals the given sum.
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
 *  /  \      \
 * 7    2      1
 * 
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 ******************************************************************************************************/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool hasPathSum(TreeNode* root, int sum) {
        if (!root) return false;
        if (!root->left && !root->right) 
            return root->val == sum;
        int new_sum = sum - root->val;
        return hasPathSum(root->left,new_sum) || hasPathSum(root->right,new_sum);
    }
};
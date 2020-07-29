// Source : https://leetcode.com/problems/symmetric-tree/
// Author : henrytine
// Date   : 2020-07-30

/***************************************************************************************************** 
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 
 * But the following [1,2,2,null,3,null,3] is not:
 * 
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 
 * Follow up: Solve it both recursively and iteratively.
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
    bool isSymmetric(TreeNode* root) {
        TreeNode* left, *right;
        if (!root) return true;
        queue<TreeNode*> q1, q2;
        q1.push(root->left);
        q2.push(root->right);
        
        while (!q1.empty() && !q2.empty()) {
            left = q1.front(); q1.pop();
            right = q2.front(); q2.pop();
            
            if (left == NULL && right == NULL) {
                continue;
            }
            
            if (left == NULL || right == NULL) {
                return false;
            }
            
            if (left->val != right->val) {
                return false;
            }
            
            q1.push(left->left);
            q1.push(left->right);
            
            q2.push(right->right);
            q2.push(right->left);
        }
        return true;
    }
};
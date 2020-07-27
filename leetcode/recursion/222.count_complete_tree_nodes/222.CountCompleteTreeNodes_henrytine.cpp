// Source : https://leetcode.com/problems/count-complete-tree-nodes/
// Author : henrytine
// Date   : 2020-07-28

/***************************************************************************************************** 
 *
 * Given a complete binary tree, count the number of nodes.
 * 
 * Note: 
 * 
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all 
 * nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive 
 * at the last level h.
 * 
 * Example:
 * 
 * Input: 
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 * 
 * Output: 6
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
    int countNodes(TreeNode* root) {
        if (root == NULL) return 0;
        
        int cnt = 0;
        helper(root, cnt);
        return cnt + 1;
        
    }
    
    void helper(TreeNode* node, int& cnt) {
        if (node == NULL) return;
        if (node->left) {
            ++cnt;
            helper(node->left,cnt);
        }
        
        if(node->right) {
            ++cnt;
            helper(node->right,cnt);
        }
    }
};
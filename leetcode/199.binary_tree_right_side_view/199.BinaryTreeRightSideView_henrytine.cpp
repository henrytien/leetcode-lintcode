// Source : https://leetcode.com/problems/binary-tree-right-side-view/
// Author : henrytine
// Date   : 2020-07-30

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

class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        vector<int> res;
        dfs(root, 0, res);
        return res;
    }
    
    void dfs (TreeNode* node, int lv, vector<int> &res) {
        if (!node) return;
        if (lv >= res.size()) res.emplace_back(node->val);
        dfs(node->right, lv+1, res);
        dfs(node->left, lv+1, res);
    }
};
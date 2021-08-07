// Source : https://leetcode.com/problems/average-of-levels-in-binary-tree/
// Author : henrytine
// Date   : 2020-11-18

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
    vector<double> averageOfLevels(TreeNode* root) {
        vector<double> ans;
        if (!root) return  ans;
        
        vector<TreeNode*> curr, next;
        curr.push_back(root);
        while (!curr.empty()) {
            long long sum  = 0;
            for (auto & p : curr) {
                sum += p->val;
                if (p->left) next.push_back(p->left);
                if (p->right) next.push_back(p->right);
            }
            
            ans.push_back(static_cast<double>(sum) / curr.size());
            curr.swap(next);
            next.clear();
        }
        return ans;
    }
};
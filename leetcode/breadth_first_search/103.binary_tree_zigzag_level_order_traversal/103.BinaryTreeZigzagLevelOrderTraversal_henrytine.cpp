// Source : https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
// Author : henrytine
// Date   : 2021-01-11

/***************************************************************************************************** 
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left 
 * to right, then right to left for the next level and alternate between).
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 
 * return its zigzag level order traversal as:
 * 
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        if (root == NULL) {
            return vector<vector<int>>();
        }
        vector<vector<int>> result;
        
        queue<TreeNode*> nodeQueue;
        nodeQueue.push(root);
        bool  leftToRight = true;
        while(!nodeQueue.empty()) {
            int size = nodeQueue.size();
            vector<int> row(size);
            
            for (int i = 0; i < size; i++) {
                TreeNode* node = nodeQueue.front();
                nodeQueue.pop();
                
                int index = leftToRight ? i : (size - i - 1);
                row[index] = node->val;
                
                if (node->left) {
                    nodeQueue.push(node->left);
                }
                
                if (node->right) {
                    nodeQueue.push(node->right);
                }
            }
            leftToRight = !leftToRight;
            result.push_back(row);
        }
        return result;
    }
};


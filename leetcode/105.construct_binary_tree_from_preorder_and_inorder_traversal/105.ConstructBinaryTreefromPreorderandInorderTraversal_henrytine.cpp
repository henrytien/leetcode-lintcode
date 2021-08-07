// Source : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
// Author : henrytine
// Date   : 2020-08-19

/***************************************************************************************************** 
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * 
 * Return the following binary tree:
 * 
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
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
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
       
       return helper(preorder, 0, preorder.size(), inorder, 0, inorder.size());
    }
    
    TreeNode* helper(vector<int>& preorder, int i, int j, vector<int>& inorder, int ii, int jj) {
        if (i >= j || ii >= j) {
            return NULL;
        }
        
        int mid = preorder[i];
        auto f = find(inorder.begin() + ii, inorder.begin() + jj, mid);
        
        int dis = f - inorder.begin() - ii;
        
        TreeNode* root = new TreeNode(mid);
        root->left = helper(preorder, i + 1, i + 1 + dis, inorder, ii, ii + dis);
        root->right = helper(preorder, i + 1 + dis, j, inorder, ii + dis + 1, jj);
        return root;
    }
    
};

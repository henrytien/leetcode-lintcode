// Source : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
// Author : henrytine
// Date   : 2020-07-03

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
#include"ac.h"

TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
    return builTreeHelper(preorder,0,preorder.size(),inorder,0,inorder.size());
}

TreeNode* builTreeHelper(vector<int>& preorder, int sp, int ep, vector<int>& inorder, int si, int ei) {
    if (sp == ep) return nullptr;
    TreeNode* root = new TreeNode(preorder[sp]);
    int dis = find(inorder.begin()+si,inorder.begin()+ei,preorder[sp]) - inorder.begin() - si;
    root->left = builTreeHelper(preorder,sp+1,sp+1+dis,inorder,si,si+dis);
    root->right = builTreeHelper(preorder,sp+1+dis,ep,inorder,si+dis+1,ei);
    return root;
}
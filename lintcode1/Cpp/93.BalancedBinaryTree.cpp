// https://www.lintcode.com/problem/balanced-binary-tree/description?_from=ladder&&fromId=1

/**
 * Definition of TreeNode:
 * class TreeNode {
 * public:
 *     int val;
 *     TreeNode *left, *right;
 *     TreeNode(int val) {
 *         this->val = val;
 *         this->left = this->right = NULL;
 *     }
 * }
 */

class Solution {
public:

    int Depth(TreeNode *root){
        if(NULL == root){
            return 0;
        }
        
        int left = Depth(root->left);
        int right = Depth(root->right);
        if(left == -1 || right == -1 || abs(left-right) > 1){
            return -1;
        }
        return max(left,right) + 1;
    }



    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    bool isBalanced(TreeNode * root) {
        if(NULL == root){
            return true;
        }
        return Depth(root) != -1;
    }
};
// https://www.lintcode.com/problem/validate-binary-search-tree/description?_from=ladder&&fromId=1
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
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    bool isValidBST(TreeNode * root) {
       inorder(root);
       int size = res.size();
       for (int i = 0; i < size - 1; i++) {
           if(res[i] >= res[i+1]){
               return false;
           }
       }
       return true;
    }
    
    void inorder(TreeNode *root){
        if(NULL == root){
            return;
        }
        
        inorder(root->left);
        res.push_back(root->val);
        inorder(root->right);
    }
    
    private:
    std::vector<int> res;
};
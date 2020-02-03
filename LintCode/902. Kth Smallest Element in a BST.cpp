// https://www.lintcode.com/problem/kth-smallest-element-in-a-bst/description?_from=ladder&&fromId=1
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
    void DFS(TreeNode *root,int &k, int &val){
       if(!root) return;
       DFS(root->left,k,val);
       if(--k == 0) val = root->val;
       DFS(root->right,k,val);
    }

    /**
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    int kthSmallest(TreeNode * root, int k) {
        int value = 0;
        DFS(root,k,value) ;
        return value;
    }
};
// https://www.lintcode.com/problem/lowest-common-ancestor-of-a-binary-tree/my-submissions
/* recursion */

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
    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    TreeNode * lowestCommonAncestor(TreeNode * root, TreeNode * A, TreeNode * B) {
        // write your code here
        if(NULL == root)
        {
            return NULL;
        }
        
        if(A == root || B == root)
        {
            return root;
        }
        
        TreeNode * left = lowestCommonAncestor(root->left,A,B);
        TreeNode * right = lowestCommonAncestor(root->right,A,B);
        
        if(NULL != left && NULL != right){
            return root;
        }
        
        if(NULL != left)
        {
            return left;
        }
        
        if(NULL != right)
        {
            return right;
        }
        
        return NULL;
    }
};
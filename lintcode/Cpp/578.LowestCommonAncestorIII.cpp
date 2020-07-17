// https://www.lintcode.com/problem/lowest-common-ancestor-iii/description?_from=ladder&&fromId=1 

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
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
     
    TreeNode * lowestCommonAncestor3(TreeNode * root, TreeNode * A, TreeNode * B) {
        helper(root,A,B);
        return ans;
    }
    
    int helper(TreeNode *root, TreeNode *A, TreeNode *B){
        if(NULL == root){
            return 0;
        }
        
        int total = 0;
        if(root == A){
            ++total;
        }
        if(root == B){
            ++total;
        }
        
        int leftCount = helper(root->left,A,B);
        int rightCount = helper(root->right,A,B);
        
        if(leftCount == 2||rightCount == 2){
            return 2;
        } 
        total += leftCount + rightCount;
        if(total == 2){
            ans = root;
        }
        return total;
    }
    private:
        TreeNode *ans = NULL;
};
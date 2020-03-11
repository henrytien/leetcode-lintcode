// https://www.lintcode.com/problem/binary-tree-maximum-path-sum/description
class Solution {
public:
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    int maxPathSum(TreeNode * root) {
       if(root == NULL){
           return 0;
       }
       
      sum = root->val;
      helper(root);
      return sum;
    }
    
private:
    int helper(TreeNode *node){
        if(node == NULL){
            return 0;
        }
        
        int leftSum = max(0,helper(node->left));
        int rightSum = max(0,helper(node->right));
        
        sum = max(sum, leftSum + rightSum + node->val);
      
        return max(leftSum, rightSum) + node->val;
    }

    int sum;
    
};
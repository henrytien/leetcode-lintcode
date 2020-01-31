/**
 * Definition of TreeNode:
 * class TreeNode {
 * public:
 *     int value;
 *     TreeNode *left, *right;
 *     TreeNode(int value) {
 *         this->val = value;
 *         this->left = this->right = NULL;
 *     }
 * }
 */

class Solution {
    private:
    
    // return node->value < target
    TreeNode* lowerBound(TreeNode *root, double target){
       if(NULL == root){
           return NULL;
       }
       
      if(target <= root->val)
      {
          return lowerBound(root->left,target);
      }
      
      TreeNode* lowerNode = lowerBound(root->right,target);
      if(NULL != lowerNode){
          return lowerNode;
      }
      return root;
            
    }
    
    
     // return node->value > target
    TreeNode* upperBound(TreeNode *root, double target){
        if(NULL == root){
            return NULL;
        }
        
        if(target > root->val)
        {
            return upperBound(root->right,target);
        }
        
       TreeNode* upperNode = upperBound(root->left,target);
      if(NULL != upperNode){
          return upperNode;
      }
      return root;
        
    }
    
    
    
public:
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    int closestValue(TreeNode * root, double target) {
       if(root == NULL){
           return 0;
       }
       
       TreeNode* upperNode = Solution::upperBound(root,target);
       TreeNode* lowerNode = Solution::lowerBound(root,target);
       
       if(NULL == upperNode){
           return lowerNode->val;
       }
       
       if(NULL == lowerNode){
           return upperNode->val;
       }
       
       if(abs(target - upperNode->val) <= abs(target- lowerNode->val))
       {
           return upperNode->val;
       }
       return lowerNode->val;
        
    }
};
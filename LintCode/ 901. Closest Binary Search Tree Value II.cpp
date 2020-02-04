//https://www.lintcode.com/problem/closest-binary-search-tree-value-ii/description?_from=ladder&&fromId=1
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
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    vector<int> closestKValues(TreeNode * root, double target, int k) {
        vector<int> res;
        if(NULL == root){
            return res;
        }
        
        std::stack<TreeNode *> leftStack;
        std::stack<TreeNode *> rightStack;
        
        while(root)
        {
            if(root->val > target){
                rightStack.push(root);
                root = root->left;
            }
            else{
                
                leftStack.push(root);
                root = root->right;
            }
        }
        
        for (int i = 0; i < k; i++) {
            if(leftStack.empty())
            {
                res.push_back(rightStack.top()->val);
                moveup(rightStack);
                continue;
            }
            if(rightStack.empty())
            {
                res.push_back(leftStack.top()->val);
                moveless(leftStack);
                continue;
            }
            
            if(target - leftStack.top()->val < rightStack.top()->val - target)
            {
               
                res.push_back(leftStack.top()->val);
                moveless(leftStack);
            }else
            {
                
                res.push_back(rightStack.top()->val);
                moveup(rightStack);
            }
        }
        
        return res;
    }
    
private:
    void moveless(stack<TreeNode *> &lStack)
    {
        TreeNode *node = lStack.top();
        lStack.pop();
        if(node){
            node = node->left;
            while(node){
                lStack.push(node);
                node = node->right;
            }
        }
    }
    
    void moveup(stack<TreeNode *> &rStack)
    {
        TreeNode *node = rStack.top();
        rStack.pop();
        if(node){
            node = node->right;
            while(node)
            {
                rStack.push(node);
                node = node->left;
            }
        }
    }
    
};
// https://www.lintcode.com/problem/binary-tree-zigzag-level-order-traversal/description


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
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    vector<vector<int>> zigzagLevelOrder(TreeNode * root) {
        vector<vector<int>> res;
        if(root == NULL){
            return res;
        }
        
        std::queue<TreeNode*> que;
        que.push(root);
        int high = 0;
        while(!que.empty()){
            int size = que.size();
            vector<int> level;
            
            for (int i = 0; i < size; i++) {
                TreeNode *node = que.front();
                que.pop();
                level.push_back(node->val);
                
                if(node->left){
                    que.push(node->left);
                }
                if(node->right){
                    que.push(node->right);
                }
            }
            if(high % 2 != 0){
                    reverse(level.begin(),level.end());
            }
                
            high++;
            res.push_back(level);
        }
        return res;
    }
};


// stack 
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
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    vector<vector<int>> zigzagLevelOrder(TreeNode * root) {
        vector<vector<int>> res;
        if(root == NULL){
            return res;
        }
        
        std::stack<TreeNode*> stack;
        stack.push(root);
        int high = -1;
        while(!stack.empty()){
            int size = stack.size();
            vector<int> level;
            high++;
            std::stack<TreeNode*> stackNew;
            for (int i = 0; i < size; i++) {
                TreeNode *node = stack.top();
                stack.pop();
                level.push_back(node->val);
                if(high % 2 == 0){
                    if(node->left){
                        stackNew.push(node->left);
                    }
                    if(node->right){
                        stackNew.push(node->right);
                    }
                }
                else{
                    if(node->right){
                        stackNew.push(node->right);
                    }
                    if(node->left){
                        stackNew.push(node->left);
                    }
                }
            }
            res.push_back(level);
            stack = stackNew;
        }
        return res;
    }
};
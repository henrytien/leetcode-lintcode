// https://www.lintcode.com/problem/binary-tree-level-order-traversal-ii/description
// bfs
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
     * @param root: A tree
     * @return: buttom-up level order a list of lists of integer
     */
    vector<vector<int>> levelOrderBottom(TreeNode * root) {
        vector<vector<int>> res;
        if(root == NULL){
            return res;
        }
        
        vector<int> level;
        // std::stack<vector<int>> stack;
        std::queue<TreeNode *> que;
        que.push(root);
        
        while(!que.empty()){
            int size = que.size();
            while(size--){
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
           res.insert(res.begin(),level);
           // stack.push(level); 
            level.clear();
        }
        
        // while(!stack.empty()){
        //     res.push_back(stack.top());
        //     stack.pop();
        // }
        return res;
    }
};
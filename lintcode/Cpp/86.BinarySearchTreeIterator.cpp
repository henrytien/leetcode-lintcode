// https://www.lintcode.com/problem/binary-search-tree-iterator/description?_from=ladder&&fromId=1
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
 * Example of iterate a tree:
 * BSTIterator iterator = BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode * node = iterator.next();
 *    do something for node
 */


class BSTIterator {
public:
    /*
    * @param root: The root of binary tree.
    */BSTIterator(TreeNode * root) {
        // do intialization if necessary
        TreeNode *cur = root;
        while(cur)
        {
            stack.push(cur);
            cur = cur->left;
        }
    }

    /*
     * @return: True if there has next node, or false
     */
    bool hasNext() {
        // write your code here
        return !stack.empty();
    }

    /*
     * @return: return next node
     */
    TreeNode * next() {
        // write your code here
        
        TreeNode *node = stack.top();
        stack.pop();
        
        TreeNode *cur = node->right;
        while(cur){
            stack.push(cur);
            cur = cur->left;
        }
        return node;
    }
    
private:
    std::stack<TreeNode *> stack;
    
};
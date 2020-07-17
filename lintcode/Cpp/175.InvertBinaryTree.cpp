// https://www.lintcode.com/problem/invert-binary-tree/leaderboard
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

class Solution
{
public:
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    void invertBinaryTree(TreeNode *root)
    {
        if (NULL == root)
        {
            return;
        }
        dfs(root);
    }

    void dfs(TreeNode *node)
    {
        TreeNode *left = node->left, *right = node->right;
        node->left = right;
        node->right = left;
        if (left)
            dfs(left);
        if (right)
            dfs(right);
    }
};

// no-recursion
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

class Solution
{
public:
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    void invertBinaryTree(TreeNode *root)
    {
        if (NULL == root)
        {
            return;
        }

        std::stack<TreeNode *> stack;
        stack.push(root);
        while (!stack.empty())
        {
            TreeNode *node = stack.top();
            stack.pop();

            swap(node->left, node->right);
            if (node->left)
            {
                stack.push(node->left);
            }
            if (node->right)
            {
                stack.push(node->right);
            }
        }
    }
};
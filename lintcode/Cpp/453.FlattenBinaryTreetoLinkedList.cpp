// https://www.lintcode.com/problem/flatten-binary-tree-to-linked-list/description?_from=ladder&&fromId=1
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
    void flatten(TreeNode *root)
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

            if (node->right)
            {
                stack.push(node->right);
            }

            if (node->left)
            {
                stack.push(node->left);
            }

            node->left = NULL;
            if (stack.empty())
            {
                node->right = NULL;
            }
            else
            {
                node->right = stack.top();
            }
        }
    }
};

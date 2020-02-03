//https://www.lintcode.com/problem/binary-tree-paths/description?_from=ladder&&fromId=1
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
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    vector<string> binaryTreePaths(TreeNode *root)
    {
        vector<string> res;
        if (NULL == root)
        {
            return res;
        }

        if (NULL == root->left && NULL == root->right)
        {
            res.push_back(to_string(root->val));
            return res;
        }

        vector<string> left = binaryTreePaths(root->left);
        vector<string> right = binaryTreePaths(root->right);

        for (auto &e : left)
        {
            res.push_back(to_string(root->val) + "->" + e);
        }

        for (auto &e : right)
        {
            res.push_back(to_string(root->val) + "->" + e);
        }
        return res;
    }
};
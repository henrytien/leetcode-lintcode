//https://www.lintcode.com/problem/subtree-with-maximum-average/description

/* dfs */

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
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    TreeNode *findSubtree2(TreeNode *root)
    {
        if (NULL == root)
        {
            return NULL;
        }
        dfs(root);
        return ans;
    }

    pair<double, int> dfs(TreeNode *root)
    {
        if (NULL == root)
        {
            return {0, 0};
        }

        auto left = dfs(root->left);
        auto right = dfs(root->right);
        int num = left.second + right.second + 1;
        double ave = (left.first * left.second + right.first * right.second + (double)root->val) / num;
        if (ave > average)
        {
            average = ave;
            ans = root;
        }
        return {ave, num};
    }

private:
    TreeNode *ans;
    double average = INT_MIN;
};
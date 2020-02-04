// https://www.lintcode.com/problem/validate-binary-search-tree/description?_from=ladder&&fromId=1
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
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    bool isValidBST(TreeNode *root)
    {
        inorder(root);
        int size = res.size();
        for (int i = 0; i < size - 1; i++)
        {
            if (res[i] >= res[i + 1])
            {
                return false;
            }
        }
        return true;
    }

    void inorder(TreeNode *root)
    {
        if (NULL == root)
        {
            return;
        }

        inorder(root->left);
        res.push_back(root->val);
        inorder(root->right);
    }

private:
    std::vector<int> res;
};

/* Divide && Conquer*/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution
{
public:
    bool isValidBST(TreeNode *root)
    {

        return helper(root, (long)INT_MIN - 1, (long)INT_MAX + 1);
    }

    bool helper(TreeNode *root, long min, long max)
    {
        if (NULL == root)
        {
            return true;
        }

        if (root->val <= min || root->val >= max)
        {
            return false;
        }

        bool left = helper(root->left, min, (long)root->val);
        bool right = helper(root->right, (long)root->val, max);

        return left && right;
    }
};

/* stack no-recursion */

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution
{
public:
    bool isValidBST(TreeNode *root)
    {
        stack<TreeNode *> stack;
        TreeNode *cur = root;

        while (!stack.empty() || cur)
        {
            while (cur)
            {
                stack.push(cur);
                cur = cur->left;
            }
            cur = stack.top();
            stack.pop();
            if (pre && pre->val >= cur->val)
            {
                return false;
            }
            pre = cur;
            cur = cur->right;
        }
        return true;
    }

private:
    TreeNode *pre;
};
